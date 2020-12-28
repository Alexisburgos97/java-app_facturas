package org.aburgos.appFacturas.modelo;

public class Cliente {
    private String nombre;
    private String nif; //identificación fiscal o tributaria

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }
}
