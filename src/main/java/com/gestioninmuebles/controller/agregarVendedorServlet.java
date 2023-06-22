package com.gestioninmuebles.controller;

import com.gestioninmuebles.model.Vendedor;
import com.gestioninmuebles.model.data.dao.VendedorDAO;
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

@WebServlet(name = "agregarVendedorServlet", value = "/agregarVendedor")
public class agregarVendedorServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("GestionLibrosBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/agregarVendedor.jsp");
        respuesta.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("rut").length() == 0 || req.getParameter("nombre").length() == 0 || req.getParameter("direccion").length() == 0 || req.getParameter("tituloProfesional").length() == 0 || req.getParameter("estadoCivil").length() == 0) {
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
            respuesta.forward(req, resp);
        } else {
            String rut = req.getParameter("rut");
            String nombre = req.getParameter("nombre");
            String direccion = req.getParameter("direccion");
            String tituloProfesional = req.getParameter("tituloProfesional");
            String estadoCivil = req.getParameter("estadoCivil");
            Vendedor vendedor = new Vendedor(rut, nombre, direccion, tituloProfesional, estadoCivil);
            RequestDispatcher respuesta = req.getRequestDispatcher("/index.jsp");
            respuesta.forward(req, resp);
        }
    }

    private boolean agregarVendedor(Vendedor vendedor) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("GestionLibrosBD");
        List<Vendedor> vendedores = VendedorDAO.obtenerVendedor(query, "rut", vendedor.getRut());
        if (vendedores.size() != 0) {
            return false;
        } else {
            VendedorDAO.agregarVendedor(query, vendedor);
            return true;
        }
    }
}
