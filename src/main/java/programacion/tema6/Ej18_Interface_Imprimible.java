/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.tema6;

import java.time.LocalDate;

/**
 *
 * @author Bernar
 */
public class Ej18_Interface_Imprimible {
    
}


interface imprimible {
    int getNumAtributos();
    String[] getNombreAtributos();
    String[] getContenidoArray();
    String getContenidoString();
}

abstract class PersonaE18 implements imprimible {
    
    protected String nombre;
    protected String apellidos;
    protected LocalDate fechaNacimiento;
    
    public PersonaE18(String nombre, String apellidos, LocalDate fechaNacimiento){
        
        this.nombre = nombre;
        this.apellidos = apellidos;
        
    }
}