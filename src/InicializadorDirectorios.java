import java.io.File;
import java.io.IOException;

public class InicializadorDirectorios {

    public static void main(String[] args) {

        String rutaBase = "C:\\AD\\Ejercicios\\miDirectorio";

        File midirectorio = new File(rutaBase);
        File archivo = new File(midirectorio, "fichero_de_texto.txt");

        try {
            // Crear el directorio
            if (!midirectorio.exists()) {
                if (midirectorio.mkdirs()) {
                    System.out.println("Directorio creado correctamente.");
                } else {
                    System.out.println("No se pudo crear el directorio.");
                }
            } else {
                System.out.println("El directorio ya existe.");
            }

            // Crear el archivo
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado correctamente.");
            } else {
                System.out.println("El archivo ya existe.");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

