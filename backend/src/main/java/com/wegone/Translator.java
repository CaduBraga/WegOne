package com.wegone;

import java.util.Map;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class Translator {
    private Map<String, String> translations;

    public Translator(String languageCode) {
        loadTranslations(languageCode);
    }

    private void loadTranslations(String languageCode) {
        try {
            String filePathString = "translate/" + languageCode + ".json";
            FileReader reader = new FileReader(filePathString);
            Gson gson = new Gson();
            translations = gson.fromJson(reader, Map.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}