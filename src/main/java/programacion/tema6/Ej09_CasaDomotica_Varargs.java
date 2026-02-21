/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.tema6;

/**
 *
 * @author Bernar
 */
public class Ej09_CasaDomotica_Varargs {
    
}

abstract class DispositivoE09 {

    /** Rango válido de ubicación (como en el temario). */
    public static final int MIN_UBICACION = 1;
    public static final int MAX_UBICACION = 10;

    /** Contador estático para generar ids únicos. */
    private static int nextId = 1;

    /** Atributos comunes. */
    private final int id;
    private final String descripcion;
    private final int ubicacion;

    /**
     * Constructor común.
     *
     * @param descripcion texto descriptivo
     * @param ubicacion estancia (1..10)
     */
    protected DispositivoE09(String descripcion, int ubicacion) {
        if (ubicacion < MIN_UBICACION || ubicacion > MAX_UBICACION) {
            throw new IllegalArgumentException(String.format("Ubicación no válida: %d", ubicacion));
        }
        this.id = nextId++;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    /** @return id del dispositivo */
    public int getId() { return id; }

    /** @return descripción */
    public String getDescripcion() { return descripcion; }

    /** @return ubicación */
    public int getUbicacion() { return ubicacion; }

    /**
     * Representación base reutilizable (ampliable por subclases con super.toString()).
     */
    @Override
    public String toString() {
        return String.format(
                "tipo:%-12s id:%d descripción:\"%s\" ubicacion:%d",
                this.getClass().getSimpleName(), id, descripcion, ubicacion
        );
    }
}


final class BombillaE09 extends DispositivoE09{
    
    public static final int MIN_INTENSIDAD = 0;
    public static final int MAX_INTENSIDAD = 10;
    
    private boolean encendida;
    private int intensidad;
    
    public BombillaE09(String descripcion, int ubicacion) {
        this(descripcion, ubicacion, MIN_INTENSIDAD);
    }
    
    public BombillaE09(String descripcion, int ubicacion, int intensidadInicial){
        super(descripcion, ubicacion);
        
        if(intensidadInicial < MIN_INTENSIDAD || intensidadInicial > MAX_INTENSIDAD){
            throw new IllegalArgumentException("Intensidad inicial no válida: " + intensidadInicial);
        }
        
        this.intensidad = intensidadInicial;
        this.encendida = intensidadInicial > 0;
    }
}