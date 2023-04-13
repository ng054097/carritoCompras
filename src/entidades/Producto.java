package entidades;

import java.util.ArrayList;

public class Producto {
    private String nombreDelProducto ;



    public Producto(String nombreDelProducto) {
        this.nombreDelProducto = nombreDelProducto;


    }

    public Producto() {
        getNombreDelProducto();
    }

    public long cantidadProducto(ArrayList<Producto> listaDeProductoStock ,String nombreDeProducto ) {

        return  listaDeProductoStock.stream().filter(x->x.getNombreDelProducto()==nombreDeProducto).count();

    }


    public String getNombreDelProducto() {
        return nombreDelProducto;
    }

    public void setNombreDelProducto(String nombreDelProducto) {
        this.nombreDelProducto = nombreDelProducto;
    }
}
