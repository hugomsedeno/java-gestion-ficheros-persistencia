import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorSistemaArchivos {

    // Ruta base sobre la que trabajaremos
    private static final String RUTA_BASE = "C:\\AD\\Ejercicios";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // Declaramos los objetos File para tener sus rutas listas
        File dirNuevo = new File(RUTA_BASE, "nuevoDirectorio");
        File txtOriginal = new File(RUTA_BASE + "\\miDirectorio", "fichero_de_texto.txt");
        File txtNuevo = new File(dirNuevo, "fichero_de_texto2.txt");

        // Bucle do-while para repetir el menú hasta seleccionar "Salir"
        do {
            System.out.println("\n--- MENÚ DE GESTIÓN DE FICHEROS ---");
            System.out.println("1) Crear directorio 'nuevoDirectorio'");
            System.out.println("2) Crear 'fichero_de_texto2.txt' en nuevoDirectorio");
            System.out.println("3) Eliminar 'fichero_de_texto.txt'");
            System.out.println("4) Eliminar 'nuevoDirectorio' (aunque contenga archivos)");
            System.out.println("5) Escribir provincias de Andalucía en 'fichero_de_texto2.txt'");
            System.out.println("6) Salir");
            System.out.print("Elige una opción: ");

            // Validación para evitar que el programa falle si se introduce una letra
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiamos el buffer
            } else {
                System.out.println("Por favor, introduce un número válido.");
                sc.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    crearDirectorio(dirNuevo);
                    break;
                case 2:
                    crearArchivo(txtNuevo);
                    break;
                case 3:
                    eliminarArchivo(txtOriginal);
                    break;
                case 4:
                    eliminarDirectorioRecursivo(dirNuevo);
                    break;
                case 5:
                    escribirProvincias(txtNuevo);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción fuera de rango.");
            }
        } while (opcion != 6);

        sc.close();
    }

    // Método para crear el directorio
    private static void crearDirectorio(File dir) {
        if (dir.exists()) {
            System.out.println("El directorio ya existe.");
        } else if (dir.mkdirs()) {
            System.out.println("Directorio creado: " + dir.getAbsolutePath());
        } else {
            System.out.println("No se pudo crear el directorio.");
        }
    }

    // Método para crear un archivo vacío
    private static void crearArchivo(File archivo) {
        try {
            if (!archivo.getParentFile().exists()) {
                System.out.println("Error: El directorio contenedor no existe. Ejecuta primero la Opción 1.");
                return;
            }
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getAbsolutePath());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    // Método para borrar un solo archivo
    private static void eliminarArchivo(File archivo) {
        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("Archivo eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }

    // Método para borrar un directorio aunque contenga elementos (Borrado Recursivo)
    private static void eliminarDirectorioRecursivo(File dir) {
        if (!dir.exists()) {
            System.out.println("El directorio no existe.");
            return;
        }

        File[] contenido = dir.listFiles();
        if (contenido != null) {
            for (File elemento : contenido) {
                if (elemento.isDirectory()) {
                    eliminarDirectorioRecursivo(elemento);
                } else {
                    elemento.delete();
                }
            }
        }

        if (dir.delete()) {
            System.out.println("Directorio eliminado exitosamente.");
        } else {
            System.out.println("No se pudo eliminar el directorio.");
        }
    }

    // Método para escribir las provincias de Andalucía
    private static void escribirProvincias(File archivo) {
        if (!archivo.exists()) {
            System.out.println("El archivo no existe. Ejecuta primero la Opción 2.");
            return;
        }

        String[] provincias = {
                "Almería", "Cádiz", "Córdoba", "Granada",
                "Huelva", "Jaén", "Málaga", "Sevilla"
        };

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String provincia : provincias) {
                bw.write(provincia);
                bw.newLine();
            }
            System.out.println("Provincias escritas correctamente en " + archivo.getName());
        } catch (IOException e) {
            System.err.println("Error de escritura: " + e.getMessage());
        }
    }
}

