package com.reintegro.profuturo.app.util;

import android.util.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;

public class Base64Utils {
    public static String encodeFile(File file) {
        StringWriter stringWriter;
        stringWriter = new StringWriter();

        byte[] bytes;
        bytes = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream;
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytes, 0, (int) file.length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }
}
