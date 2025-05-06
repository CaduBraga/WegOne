package com.wegone;

import java.io.FileReader;
import java.io.IOException;

public class Translator {

    public Translator(String languageCode) {
        loadTranslations(languageCode);
    }

    private void loadTranslations(String languageCode) {
        try {
            String filePathString = "translate/" + languageCode + ".json";
            FileReader reader = new FileReader(filePathString);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}