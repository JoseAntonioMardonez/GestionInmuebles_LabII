package com.gestioninmuebles.controller;

import com.gestioninmuebles.model.Inmueble;
import com.gestioninmuebles.model.data.dao.InmuebleDAO;
import com.gestioninmuebles.model.data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "agregarInmuebleServlet", value = "/agregarInmueble")
public class agregarInmuebleServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("GestionInmueblesBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/agregarInmueble.jsp");
        respuesta.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("codigoInmueble").length() == 0 || req.getParameter("tipoInmueble").length() == 0 || req.getParameter("ciudad").length() == 0 || req.getParameter("direccion").length() == 0 || req.getParameter("precio").length() == 0) {
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
            respuesta.forward(req, resp);
        } else {
            String codigoInmueble = req.getParameter("codigoInmueble");
            String tipoConstruccion = req.getParameter("tipoConstruccion");
            String ciudad = req.getParameter("ciudad");
            String direccion = req.getParameter("direccion");
            int precio = Integer.parseInt(req.getParameter("precio"));
            Inmueble inmueble = new Inmueble(codigoInmueble, tipoConstruccion, ciudad, direccion, precio);
            RequestDispatcher respuesta = req.getRequestDispatcher("/index.jsp");
            respuesta.forward(req, resp);
        }
    }

    private boolean agregarInmueble(Inmueble inmueble) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("GestionInmueblesBD");
        List<Inmueble> inmuebles = InmuebleDAO.obtenerInmueble(query, "codigoInmueble", inmueble.getCodigoInmueble());
        if (inmuebles.size() != 0) {
            return false;
        } else {
            InmuebleDAO.agregarInmueble(query, inmueble);
            return true;
        }
    }
}
