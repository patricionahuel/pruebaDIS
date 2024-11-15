package es.ufv.TurismoComunidades.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;


public class CustomNumberDeserializer implements JsonDeserializer<String> {
    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String numberStr = json.getAsString();

        // Retornar null si no es un número válido
        if (numberStr == null || numberStr.trim().isEmpty() || numberStr.equals(".")) {
            return null;
        }

        // Eliminar comas y retornar el número en formato String
        return numberStr.replace(",", "");
    }
}
