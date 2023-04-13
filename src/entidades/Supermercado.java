package entidades;


import java.util.ArrayList;
import java.util.stream.Collectors;

public class Supermercado {



    private ArrayList<Producto> listaDeProductos = new ArrayList<>();


    CarritoDeCompras carrito ;
    Producto producto;



     public Supermercado(CarritoDeCompras carrito, ArrayList<Producto> listaDeProductos) {
          this.carrito = carrito;
          this.listaDeProductos = listaDeProductos;
     }

     public Supermercado() {
     }

     public ArrayList<Producto> getListaDeProductos() {
          return listaDeProductos;
     }

     public void setListaDeProductos(ArrayList<Producto> listaDeProductos) {
          this.listaDeProductos = listaDeProductos;
     }












     public  void sacarProductoDeStock(Producto ProductoAgregado){
          listaDeProductos.remove(ProductoAgregado);
     }

     public void agregarProductoEnStock(Producto productoStock){
         listaDeProductos.add(productoStock);
    }


    public Producto darProductoConNombre(String nombreProducto) {
        Producto productoADar = this.listaDeProductos.stream().filter(p -> p.getNombreDelProducto().equals(nombreProducto)).collect(Collectors.toList()).get(0);
        sacarProductoDeStock(productoADar);
        return  productoADar;
    }

    public boolean existeProductoConNombre(String nombreProducto) {

        return this.listaDeProductos.stream().filter(p->p.getNombreDelProducto().equals(nombreProducto)).count()>0;
    }
}

















