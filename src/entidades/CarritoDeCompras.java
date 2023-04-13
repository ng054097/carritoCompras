package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarritoDeCompras {
    Supermercado supermercado;
    private ArrayList<Producto> productos= new ArrayList<>();
    private Producto producto;
    public CarritoDeCompras(Supermercado supermercado) {
        this.supermercado=supermercado;
        this.productos = productos;
    }

    public CarritoDeCompras() {
    }

    public ArrayList<Producto> getProductos() {

        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }







    public long unidadesDeProductosConNombre(String nombreProducto){
    return productos.stream().filter(producto -> producto.getNombreDelProducto()==nombreProducto).count();
    }


    public void agregarProducto(String nombreProducto) {
        boolean existe = supermercado.existeProductoConNombre(nombreProducto);
        if (existe) {
            this.productos.add(this.supermercado.darProductoConNombre(nombreProducto));
        }
    }





    public void devolverProducto(String nombreProducto){
        boolean existe = unidadesDeProductosConNombre(nombreProducto) > 0;
        if(existe){
            Producto producto1= productos.stream().filter(producto2 -> producto2.getNombreDelProducto()==nombreProducto).findFirst().get();
            this.supermercado.agregarProductoEnStock(producto1);
            this.productos.remove(producto1);
        }
    }


    public void definirCantidadDeProducto(String nombreProducto, int cantidad) {
        List<Producto> productosADevolver =productos.stream().filter(producto -> producto.getNombreDelProducto()==nombreProducto ).collect(Collectors.toList());
        productosADevolver.forEach(producto1 -> devolverProducto(producto1.getNombreDelProducto()));

        int i;
        for(i=0; i<cantidad; i++){
            agregarProducto(nombreProducto);
        }

}}


