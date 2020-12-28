package org.aburgos.appFacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceItems;

    public static final int MAX_ITEMS = 12;
    private static int ultimoFolio;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    public void addItemFactura(ItemFactura item){
        if(this.indiceItems < MAX_ITEMS){
            this.items[indiceItems++] = item;
        }
    }

    public double calcularTotal(){
        double total = 0.0;
        for (ItemFactura item : this.items){
            if(item == null){
                continue;
            }
            total += item.calcularImporte();
        }
        return total;
    }

    public String generarDetalle() {

        StringBuilder sb = new StringBuilder();
        sb.append("\nFactura N°: ").
                append(this.folio).
                append("\nCliente: ").
                append(this.cliente.getNombre()).
                append("\nNIF: ").
                append(this.cliente.getNif()).
                append("\nDescripcion: ").
                append(this.descripcion).
                append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy ");
        sb.append("Fecha emision de la factura: ").
                append(df.format(this.fecha)).
                append("\n").
                append("\n#\t Nombre \t $ \t Cant. \t Total \n");



        for(ItemFactura item : this.items){
            if(item == null){
                continue;
            }
            sb.append(item.toString()).append("\n");
                    /*.getProducto().getCodigo()).
                    append("\t").
                    append(item.getProducto().getNombre()).
                    append("\t").
                    append(item.getProducto().getPrecio()).
                    append("\tt").
                    append(item.getCantidad()).
                    append("\t").
                    append(item.calcularImporte()).
                    append("\n");*/
        }

        sb.append("\n Gran Total: ").append(calcularTotal());


        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
