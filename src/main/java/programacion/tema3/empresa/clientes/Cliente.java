/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.tema3.empresa.clientes;

/**
 *
 * @author Bernar
 */


/**
 * Clase Cliente
 * Representa un cliente con nombre y email.
 */
public class Cliente {
    private String nombre;
    private String email;
    
    public Cliente(String nombre, String email){
        this.nombre = nombre;
        this.email = email;
    }
    
    public void mostrarDatos(){
        System.out.println("Datos del cliente");
        System.out.println("Nombre : " + nombre);
        System.out.println("Email: " + email);
    }
}
