public class ConversionYFormateo {
    public static void main(String[] args) {

        // Parte 1: Texto a número
        String edadTexto = "30"; // Esta es una cadena de texto que contiene un número
        // Convertimos la cadena a un int usando Integer.parseInt()
        int edad = Integer.parseInt(edadTexto);
        // Ahora podemos hacer operaciones aritméticas
        System.out.println("Edad + 5 = " + (edad + 5)); // Resultado: 35

        // Parte 2: Número a texto
        double precio = 19.99; // Número real (double)
        // Convertimos el número a texto con Double.toString()
        String precioTexto = Double.toString(precio);
        // Ahora es una cadena y se puede concatenar con otros textos
        System.out.println("El precio es: " + precioTexto); // Resultado: "El precio es: 19.99"

        // Parte 3: Conversión a otras bases
        int numero = 255; // Número decimal

        // Convertimos el número a distintas bases numéricas
        String hex = Integer.toHexString(numero);   // Base 16: "ff"
        String bin = Integer.toBinaryString(numero); // Base 2: "11111111"
        String oct = Integer.toOctalString(numero);  // Base 8: "377"

        // Mostramos todas las representaciones
        System.out.println("Hex: " + hex + " | Bin: " + bin + " | Oct: " + oct);

        // Parte 4: Formateo de número real
        double pi = 3.141592; // Número real con muchos decimales

        // Formateo simple con todos los decimales por defecto
        String f1 = String.format("%f", pi); // Resultado: "3,141592" (o "3.141592" dependiendo del locale)

        // Formateo con solo 2 decimales
        String f2 = String.format("%.2f", pi); // Resultado: "3,14"

        // Formateo con ancho mínimo de 6 caracteres y 3 decimales
        String f3 = String.format("%6.3f", pi); // Resultado: " 3,142" (espacio si no se llena)

        // Formateo con 6 caracteres, 1 decimal y relleno con ceros
        String f4 = String.format("%06.1f", pi); // Resultado: "0003,1"

        // Formateo con 4 decimales y texto "cm" al final
        String f5 = String.format("%.4f cm", pi); // Resultado: "3,1416 cm"

        // Mostramos todos los formateos
        System.out.println("Formateos:");
        System.out.println("1: " + f1);
        System.out.println("2: " + f2);
        System.out.println("3: " + f3);
        System.out.println("4: " + f4);
        System.out.println("5: " + f5);
    }
}
