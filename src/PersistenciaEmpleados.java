import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PersistenciaEmpleados {

    public static void main(String[] args) {
        File archivo = new File("C:\\AD\\Ejercicios\\Empleados.txt");

        // 1. Escritura del listado
        escribirEmpleados(archivo);

        // 2. Lectura y muestra por pantalla
        leerEmpleados(archivo);
    }

    private static void escribirEmpleados(File archivo) {
        // Aseguramos que la carpeta contenedora C:\AD\Ejercicios exista
        if (archivo.getParentFile() != null) {
            archivo.getParentFile().mkdirs();
        }

        // Usamos FileWriter encadenado con BufferedWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (int i = 1; i <= 10; i++) {
                String empleado = "ID: " + i + " | Nombre: Empleado_" + i;
                bw.write(empleado);
                bw.newLine(); // Salto de línea entre cada registro
            }
            System.out.println("Listado de 10 empleados guardado en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    private static void leerEmpleados(File archivo) {
        System.out.println("\n--- CONTENIDO DEL ARCHIVO " + archivo.getName() + " ---");

        // Usamos FileReader encadenado con BufferedReader para leer línea por línea
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            // br.readLine() lee una línea entera. Cuando llega al final del fichero devuelve null
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

            System.out.println("--- FIN DEL ARCHIVO ---");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

