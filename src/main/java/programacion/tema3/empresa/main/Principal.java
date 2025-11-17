package programacion.tema3.empresa.main;

import programacion.tema3.empresa.clientes.Cliente;
import programacion.tema3.empresa.productos.Producto;

/**
 * Clase Principal
 * Demuestra el uso de varios paquetes dentro del Tema 3.
 */
public class Principal {

    public static void main(String[] args) {

        Cliente c = new Cliente("Bernardo", "bernardo@example.com");
        Producto p = new Producto("Teclado mecánico", 59.99);

        c.mostrarDatos();
        p.mostrarDatos();
    }
}
