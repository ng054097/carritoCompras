package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarritoDeCompras {
    Supermercado supermercado;
    private ArrayList<Producto> productos= new ArrayList<>();
    private Producto producto;
 nestor gil
    public CarritoDeCompras(Supermercado supermercado,ArrayList<Producto> productos) {
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


    public long cantidadProductoDeNombreX (String nombreProducto){
    return productos.stream().filter(producto -> this.producto.getNombreDelProducto()==nombreProducto).count();

    }

    public Producto productoXNombre (String nombreProducto){
        return  productos.stream().filter(producto -> producto.getNombreDelProducto()==nombreProducto).findAny().orElse(null);
    }


    public void agregarProducto(Producto producto ){
        Producto productoAAgregar = supermercado.enviarProductoAlCarrito(producto);

     boolean existe = productos.contains(producto);

     if (existe){productos.add(productoAAgregar);}
       }



    public void eliminarProducto( Producto productoPorEliminar){

        boolean existe = productos.contains(productoPorEliminar);

        if(existe){productos.remove(productoPorEliminar);}
    }





    public List<Producto> CantidadProd(Producto producto){

        return supermercado.getListaDeProductos().stream().filter(x->x.equals(producto)).collect(Collectors.toList());

    }

}


//        public void AgregarProcuctos (String nombreProducto){
//        do{
//
//        Producto productosPorAgregar= supermercado.dameProducto("yerba");
//        Scanner leer = new Scanner(System.in);
//        System.out.println(" Digame el nommbre del producto" );
//        productosPorAgregar.setNombreDelProducto(leer.next());
//        supermercado.listaDeProductos.add(productosPorAgregar);
//
//
//
//            Iterator iterador = supermercado.listaDeProductos.iterator();
//
//            while(iterador.hasNext()){
//
//               Producto productosDelIterador= (Producto) iterador.next();
//                if ( productosPorAgregar.getNombreDelProducto().equalsIgnoreCase(productosDelIterador.nombreDelProducto)){
//
//                    productosDelIterador.cantidadDeProductos= productosDelIterador.cantidadDeProductos + 1;
//                }
//
//
//
//            }
//            System.out.println(" desea agregar otro producto?");
//            String respuesta=leer.next();
//        }while(respuesta.equalsIgnoreCase("Si"));




