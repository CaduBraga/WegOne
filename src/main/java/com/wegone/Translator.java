package com.wegone;

import org.json.JSONObject;
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

    // O trecho abaixo é para fazer a tradução funcinoar dentro do TipoManual:

    private static JSONObject mensagens;

    public static void setMensagens(JSONObject mensagensNoIdioma) {
        mensagens = mensagensNoIdioma;
    }

    public static String t(String chave) {
        if (mensagens == null) {
            return chave;
        }
        return mensagens.optString(chave, chave);
    }
    
}