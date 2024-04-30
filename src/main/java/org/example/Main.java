package org.example;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) {
        String sourceDirectory = "C:\\Users\\evazzz\\Desktop\\gbtest";
        backupFiles(sourceDirectory);
    }
    public static void backupFiles(String sourceDirectory) {
        File backupDir = new File("C:\\Users\\evazzz\\Desktop\\gbtest\\backup");
        if (!backupDir.exists()) {
            backupDir.mkdirs();
        }

        File sourceDir = new File(sourceDirectory);
        File[] files = sourceDir.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                try {
                    Path sourcePath = file.toPath();
                    Path backupPath = new File(backupDir, file.getName()).toPath();
                    Files.copy(sourcePath, backupPath, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}