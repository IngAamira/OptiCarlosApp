package com.opticarlos.application.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Clase para gestionar la subida y eliminación de archivos.
 */
public class UploadFile {
    private final String FOLDER = "images//"; // Carpeta donde se guardarán los archivos.
    private final String IMG_DEFAULT = "default.jpg"; // Nombre del archivo predeterminado en caso de que no se cargue ninguno.

    /**
     * Sube un archivo al servidor.
     *
     * @param multipartFile El archivo a subir.
     * @return El nombre del archivo subido.
     * @throws IOException Si ocurre un error al leer o escribir el archivo.
     */
    public String upload(MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(FOLDER + multipartFile.getOriginalFilename());
            Files.write(path, bytes);
            return multipartFile.getOriginalFilename();
        }
        return IMG_DEFAULT;
    }

    /**
     * Elimina un archivo del servidor.
     *
     * @param nameFile El nombre del archivo a eliminar.
     */
    public void delete(String nameFile) {
        File file = new File(FOLDER + nameFile);
        file.delete();
    }

}
