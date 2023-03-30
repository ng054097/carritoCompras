package entidades;


import java.util.ArrayList;
import java.util.stream.Stream;

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









     public Stream<Producto> filtrarProductosXNombre(String nombreProducto){



         Stream producto1=listaDeProductos.stream().filter(x->x.getNombreDelProducto()==nombreProducto);


         return producto1;


     }

     public Producto filtrarProductoXProducto (Stream<Producto> producto2){
          return (Producto) listaDeProductos.stream().filter(Producto-> producto==producto2);


     }

     public Producto enviarProductoAlCarrito(Producto productoDar){
     boolean existe = listaDeProductos.contains(productoDar);

     if(existe){

          carrito.agregarProducto(productoDar);
          sacarProductoDeStock(productoDar);

     }else{

               System.out.println("No existe el producto");

          }

     return productoDar;
     }

     public  void sacarProductoDeStock(Producto ProductoAgregado){
          listaDeProductos.remove(ProductoAgregado);


     }

    public void agregarProductoEnStock(Producto productoStock){

         listaDeProductos.add(productoStock);

    }

}













//
//     public Producto dameProducto(String yerba) {
//          //elimina una  yerba (si hay) yl a retorna
//     }





