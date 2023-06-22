package com.gestioninmuebles.model.data.dao;

import com.gestioninmuebles.model.*;

import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.VARCHAR;

public class InmuebleDAO {
    public static void agregarInmueble(DSLContext query, Inmueble inmueble){
        Table tablaInmueble= table(name("Inmueble"));
        Field[] columnas = tablaInmueble.fields("codigoInmueble","tipoConstruccion","ciudad","direccion","precio");
        query.insertInto(tablaInmueble, columnas[0], columnas[1],columnas[2],columnas[3],columnas[4])
                .values(inmueble.getCodigoInmueble(),inmueble.getTipoConstruccion(),inmueble.getCiudad(),inmueble.getDireccion(),inmueble.getPrecio())
                .execute();
    }
    public static void modificarInmueble(DSLContext query, String codigoInmueble, String columnaTabla, Object dato){
        query.update(DSL.table("Inmueble")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("codigoInmueble").eq(codigoInmueble)).execute();
    }
    public static List obtenerInmueble(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Inmueble")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaInmuebles(resultados);
    }
    public static List obtenerInmuebles(DSLContext query){
        Result resultados = query.select().from(DSL.table("Inmueble")).fetch();
        return obtenerListaInmuebles(resultados);
    }
    public static void eliminarInmueble(DSLContext query, String codigoInmueble){
        Table tablaInmueble= table(name("Inmueble"));
        query.delete(DSL.table("Inmueble")).where(DSL.field("codigoInmueble").eq(codigoInmueble)).execute();
    }
    private static List obtenerListaInmuebles(Result resultados){
        List<Inmueble> inmuebles= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String codigoInmueble = (String) resultados.getValue(fila,"codigoInmueble");
            String tipoConstruccion = (String) resultados.getValue(fila,"tipoConstruccion");
            String ciudad = (String) resultados.getValue(fila,"ciudad");
            String direccion = (String) resultados.getValue(fila,"direccion");
            int precio = (Integer) resultados.getValue(fila,"precio");
            inmuebles.add(new Inmueble(codigoInmueble,tipoConstruccion,ciudad,direccion,precio));
        }
        return inmuebles;
    }

}
