package com.gestioninmuebles.model;
//tipo de construcción (Madera, Cemento, etc..), la ubicación geográfica (Ciudad y dirección) y su precio.
public class Inmueble {
    private String codigoInmueble;
    private String tipoConstruccion;
    private String ciudad;
    private String direccion;
    private int precio;
    public Inmueble(String codigoInmueble, String tipoConstruccion, String ciudad, String direccion, int precio){
        this.codigoInmueble=codigoInmueble;
        this.tipoConstruccion=tipoConstruccion;
        this.ciudad=ciudad;
        this.direccion=direccion;
        this.precio=precio;
    }
    public String getCodigoInmueble(){
        return codigoInmueble;
    }
    public void setCodigoInmueble(String codigoInmueble){
        this.codigoInmueble=codigoInmueble;
    }
    public String getTipoConstruccion(){
        return tipoConstruccion;
    }
    public void setTipoConstruccion(String tipoConstruccion){
        this.tipoConstruccion=tipoConstruccion;
    }
    public String getCiudad(){
        return ciudad;
    }
    public void setCiudad(String ciudad){
        this.ciudad=ciudad;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public int getPrecio(){
        return precio;
    }
    public void setPrecio(int precio){
        this.precio=precio;
    }
}
