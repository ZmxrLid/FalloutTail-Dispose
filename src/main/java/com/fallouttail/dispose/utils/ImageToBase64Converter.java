package com.fallouttail.dispose.utils;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageToBase64Converter {
    public static void main(String[] args) {
        String imagePath = "D:\\素材\\屏幕截图 2023-11-15 225105.png";
        String base64Image = convertImageToBase64(imagePath);
        System.out.println(base64Image);
    }

    public static String convertImageToBase64(String imagePath) {
        try {
            Path path = Paths.get(imagePath);
            byte[] imageBytes = Files.readAllBytes(path);
            return DatatypeConverter.printBase64Binary(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
