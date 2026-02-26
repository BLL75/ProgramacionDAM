package programacion.tema6;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

/**
 * EJ20 - 6.3.1 Ejemplo de implementación de interfaces (API Java): Comparable.
 *
 * <p>Objetivo:</p>
 * <ul>
 *   <li>Implementar {@link Comparable} en una clase propia.</li>
 *   <li>Definir un criterio de comparación (aquí: edad).</li>
 *   <li>Probar la comparación y el ordenamiento con {@link Arrays#sort(Object[])}.</li>
 * </ul>
 *
 * <p>Regla de compareTo:</p>
 * <ul>
 *   <li>Devuelve un número NEGATIVO si this &lt; other</li>
 *   <li>Devuelve 0 si this == other</li>
 *   <li>Devuelve un número POSITIVO si this &gt; other</li>
 * </ul>
 *
 * @author Bernar
 */
public class Ej20_Comparable_Persona {

    public static void main(String[] args) {

        PersonaE20 p1 = new PersonaE20("Ana", "López", LocalDate.of(2005, 3, 10));
        PersonaE20 p2 = new PersonaE20("Luis", "García", LocalDate.of(1980, 8, 20));
        PersonaE20 p3 = new PersonaE20("Marta", "Sanz", LocalDate.of(1995, 1, 1));

        System.out.println("=== Comparación directa (compareTo) ===");
        System.out.println(p1 + " vs " + p2 + " -> " + p1.compareTo(p2));
        System.out.println(p2 + " vs " + p3 + " -> " + p2.compareTo(p3));
        System.out.println(p3 + " vs " + p3 + " -> " + p3.compareTo(p3));

        System.out.println("\nInterpretación:");
        System.out.println("- Si compareTo devuelve negativo: this es 'menor' según criterio.");
        System.out.println("- Aquí definimos 'menor' = más joven (menos edad).");

        System.out.println("\n=== Ordenación con Arrays.sort (usa compareTo internamente) ===");
        PersonaE20[] personas = { p1, p2, p3 };
        System.out.println("Antes: " + Arrays.toString(personas));

        Arrays.sort(personas); // llama a compareTo para ordenar
        System.out.println("Después: " + Arrays.toString(personas));
    }
}

/**
 * PersonaE20 implementa Comparable para poder compararse con otras personas.
 *
 * <p>Criterio elegido:</p>
 * <ul>
 *   <li>Comparar por edad (años).</li>
 *   <li>Más joven = "menor".</li>
 *   <li>Más mayor = "mayor".</li>
 * </ul>
 */
class PersonaE20 implements Comparable<PersonaE20> {

    private final String nombre;
    private final String apellidos;
    private final LocalDate fechaNacimiento;

    public PersonaE20(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Calcula edad actual aproximada en años.
     *
     * @return edad en años
     */
    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    /**
     * Método de la interfaz Comparable.
     *
     * <p>Decisión de diseño:</p>
     * <ul>
     *   <li>Compararemos por edad.</li>
     *   <li>this "menor" = más joven (menos años).</li>
     * </ul>
     *
     * @param other otra persona con la que compararse
     * @return negativo / 0 / positivo según la regla de Comparable
     */
    @Override
    public int compareTo(PersonaE20 other) {
        // Forma correcta y segura (evita errores por restar ints en otros contextos)
        return Integer.compare(this.getEdad(), other.getEdad());
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " (" + getEdad() + " años)";
    }
}