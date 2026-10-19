# Sistema de Gestión de Ficheros y Persistencia en Java

Aplicación desarrollada en **Java** centrada en la administración programática del sistema de archivos local (`java.io.File`) y la persistencia secuencial de datos mediante flujos con búfer (`BufferedReader` y `BufferedWriter`).

## 🚀 Características Principales

- **Consola Interactiva de Operaciones (`GestorSistemaArchivos.java`):** Menú interactivo con validación de entrada (`Scanner`) para crear directorios, generar ficheros de texto, eliminar archivos individuales y volcar colecciones de datos.
- **Borrado Recursivo de Árboles de Directorios:** Implementación de un algoritmo recursivo con `listFiles()` capaz de recorrer, vaciar y eliminar directorios completos aunque contengan subcarpetas y archivos.
- **Persistencia y Lectura Secuencial (`PersistenciaEmpleados.java`):** Escritura estructurada de registros de empleados y lectura secuencial línea a línea utilizando `BufferedWriter`, `FileWriter`, `BufferedReader` y `FileReader`.
- **Gestión Segura de Recursos (`InicializadorDirectorios.java`):** Uso de bloques `try-with-resources` para garantizar el cierre automático de flujos de entrada/salida y control de excepciones `IOException`.

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java (JDK 17+)
- **APIs Estándar:** `java.io.File`, `java.io.BufferedReader`, `java.io.BufferedWriter`, `java.io.FileReader`, `java.io.FileWriter`, `java.util.Scanner`
- **Paradigmas:** Programación modular, Recursividad, Gestión segura de recursos (`try-with-resources`)

## 📂 Estructura del Proyecto

```text
├── src/
│   ├── GestorSistemaArchivos.java      # Menú interactivo y borrado recursivo de directorios
│   ├── PersistenciaEmpleados.java      # Escritura y lectura secuencial de registros
│   └── InicializadorDirectorios.java   # Validación y creación de estructura de ficheros
└── README.md
```

## ▶️ Cómo Ejecutarlo

1. Clona este repositorio:
   ```bash
   git clone https://github.com/hugomsedeno/java-gestion-ficheros-persistencia.git
   ```
2. Compila cualquiera de los módulos desde la carpeta `src`:
   ```bash
   javac src/GestorSistemaArchivos.java
   java -cp src GestorSistemaArchivos
   ```

---
Desarrollado por **Hugo Marín Sedeño** — [LinkedIn](https://www.linkedin.com/in/hugo-marín-sedeño-79bb27302) | [GitHub](https://github.com/hugomsedeno)

