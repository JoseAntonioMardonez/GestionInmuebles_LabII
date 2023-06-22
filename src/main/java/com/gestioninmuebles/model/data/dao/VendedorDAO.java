package com.gestioninmuebles.model.data.dao;

import com.gestioninmuebles.model.*;

import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.VARCHAR;

public class VendedorDAO {
    public static void agregarVendedor(DSLContext query, Inmueble inmueble){
        Table tablaVendedor= table(name("Vendedor"));
        Field[] columnas = tablaVendedor.fields("rut","nombre","direccion","tituloProfesional","estadocivil");
        query.insertInto(tablaVendedor, columnas[0], columnas[1],columnas[2],columnas[3],columnas[4])
                .values(inmueble.getCodigoInmueble(),inmueble.getTipoConstruccion(),inmueble.getCiudad(),inmueble.getDireccion(),inmueble.getPrecio())
                .execute();
    }
    public static void modificarVendedor(DSLContext query, String rut, String columnaTabla, Object dato){
        query.update(DSL.table("Vendedor")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("rut").eq(rut)).execute();
    }
    public static List obtenerVendedor(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Vendedor")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaVendedores(resultados);
    }
    public static List obtenerVendedores(DSLContext query){
        Result resultados = query.select().from(DSL.table("Vendedor")).fetch();
        return obtenerListaVendedores(resultados);
    }
    public static void eliminarVendedor(DSLContext query, String rut){
        Table tablaVendedor= table(name("Vendedor"));
        query.delete(DSL.table("Vendedor")).where(DSL.field("rut").eq(rut)).execute();
    }
    private static List obtenerListaVendedores(Result resultados){
        List<Vendedor> vendedores= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String rut = (String) resultados.getValue(fila,"rut");
            String nombre = (String) resultados.getValue(fila,"nombre");
            String direccion = (String) resultados.getValue(fila,"direccion");
            String tituloProfesional = (String) resultados.getValue(fila,"tituloProfesional");
            String estadoCivil = (String) resultados.getValue(fila,"estadoCivil");
            vendedores.add(new Vendedor(rut,nombre,direccion,tituloProfesional,estadoCivil));
        }
        return vendedores;
    }

}
