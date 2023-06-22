package com.gestioninmuebles.model;
//nombre, rut, dirección, título profesional y estado civil (Soltero, casado, Viudo).
public class Vendedor {
    private String rut;
    private String nombre;
    private String direccion;
    private String tituloProfesional;
    private String estadoCivil;
    public Vendedor(String rut, String nombre, String direccion, String tituloProfesional, String estadoCivil){
        this.rut=rut;
        this.nombre=nombre;
        this.direccion=direccion;
        this.tituloProfesional=tituloProfesional;
        this.estadoCivil=estadoCivil;
    }
    public String getRut(){
        return rut;
    }
    public void setRut(String rut){
        this.rut=rut;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public String getTituloProfesional(){
        return tituloProfesional;
    }
    public void setTituloProfesional(String tituloProfesional){
        this.tituloProfesional=tituloProfesional;
    }
    public String getEstadoCivil(){
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil){
        this.estadoCivil=estadoCivil;
    }
}
