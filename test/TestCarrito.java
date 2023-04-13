import entidades.CarritoDeCompras;
import entidades.Producto;
import entidades.Supermercado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCarrito {
    @Test
    public void agregoDosProductosFideosDeSupermercado(){
        Supermercado supermercado= new Supermercado() ;



        supermercado.agregarProductoEnStock(new Producto("Fideos"));
        supermercado.agregarProductoEnStock(new Producto("Fideos"));
        CarritoDeCompras carritoDeCompras= new CarritoDeCompras(supermercado);
        carritoDeCompras.agregarProducto("Fideos");
        carritoDeCompras.agregarProducto("Fideos");

        Assertions.assertEquals(carritoDeCompras.unidadesDeProductosConNombre("Fideos"),2);
    }
    @Test
    public void agregoUnProductoFideoDeSupermercadoQueNoLoTieneEnStock(){
        Supermercado supermercado= new Supermercado() ;

        CarritoDeCompras carritoDeCompras= new CarritoDeCompras(supermercado);
        carritoDeCompras.agregarProducto("Fideos");

        Assertions.assertEquals(carritoDeCompras.unidadesDeProductosConNombre("Fideos"),0);
    }
    @Test
    public void devuelvoUnProductoQueTengoEnElCarrito(){
        Supermercado supermercado= new Supermercado() ;
        supermercado.agregarProductoEnStock(new Producto("Fideos"));

        CarritoDeCompras carritoDeCompras= new CarritoDeCompras(supermercado);
        carritoDeCompras.agregarProducto("Fideos");
        carritoDeCompras.devolverProducto("Fideos");

        Assertions.assertEquals(carritoDeCompras.unidadesDeProductosConNombre("Fideos"),0);
    }
    @Test
    public void devuelvoUnProductoQueNoTengoEnElCarrito(){
        Supermercado supermercado= new Supermercado() ;

        CarritoDeCompras carritoDeCompras= new CarritoDeCompras(supermercado);
        carritoDeCompras.agregarProducto("Fideos");
        carritoDeCompras.devolverProducto("Fideos");

        Assertions.assertEquals(carritoDeCompras.unidadesDeProductosConNombre("Fideos"),0);
    }
    @Test
    public void pidoAlCarritoTener4Fideos(){
        Supermercado supermercado= new Supermercado() ;

        CarritoDeCompras carritoDeCompras= new CarritoDeCompras(supermercado);
        supermercado.agregarProductoEnStock(new Producto("Fideos"));
        supermercado.agregarProductoEnStock(new Producto("Fideos"));
        supermercado.agregarProductoEnStock(new Producto("Fideos"));

        carritoDeCompras.agregarProducto("Fideos");
        carritoDeCompras.agregarProducto("Fideos");
        carritoDeCompras.agregarProducto("Fideos");

        carritoDeCompras.definirCantidadDeProducto("Fideos",4);
        Assertions.assertEquals(carritoDeCompras.unidadesDeProductosConNombre("Fideos"),4);
    }
    @Test
    public void pidoAlCarritoTener3FideosYElSupermercadoNoLosTiene(){
        Supermercado supermercado= new Supermercado() ;

        CarritoDeCompras carritoDeCompras= new CarritoDeCompras(supermercado);




        carritoDeCompras.definirCantidadDeProducto("Fideos",3);
        Assertions.assertEquals(carritoDeCompras.unidadesDeProductosConNombre("Fideos"),3);
    }
}
