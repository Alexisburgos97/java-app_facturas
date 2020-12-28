package org.aburgos.appFacturas;

import org.aburgos.appFacturas.modelo.*;

import java.util.Scanner;


public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNif("4422-2");
        cliente.setNombre("Alexis");

        Scanner s = new Scanner(System.in);

        System.out.println("Ingrese la descricion de la factura: ");
        String desc = s.nextLine();

        Factura factura = new Factura(desc,cliente);

        Producto producto;

        /*String nombre;
        double precio;
        int cantidad;*/

        System.out.println();

        for (int i = 0; i < 2; i++){
            producto = new Producto();
            System.out.print("Ingrese producto n° " + producto.getCodigo() + ": ");
            //nombre = s.nextLine();
            producto.setNombre(s.nextLine());

            System.out.print("Ingrese el precio: " );
            //precio = s.nextDouble();
            producto.setPrecio(s.nextDouble());

            System.out.print("Ingrese la cantidad: ");
            //cantidad = s.nextInt();

            //ItemFactura item = new ItemFactura(s.nextInt(),producto);
            factura.addItemFactura(new ItemFactura(s.nextInt(),producto));

            System.out.println();
            s.nextLine();

        }

        //System.out.println(factura.generarDetalle());
        System.out.println(factura);
    }
}
