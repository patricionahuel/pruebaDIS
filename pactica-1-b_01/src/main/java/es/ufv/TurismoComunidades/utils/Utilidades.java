package es.ufv.TurismoComunidades.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import es.ufv.TurismoComunidades.TurismoData;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class Utilidades {

    public static ArrayList<TurismoData> leerCsv(String path) throws IOException {
        BufferedReader lector = new BufferedReader(new FileReader(path));
        ArrayList<TurismoData> salidaCsv = new ArrayList<>();
        lector.readLine(); // Saltamos la primera linea
        String linea;
        TurismoData objeto;
        for (linea = lector.readLine(); linea != null; linea = lector.readLine()) {
            objeto = TurismoData.parserCsv(linea);
            if (objeto!=null)
            salidaCsv.add(objeto);
        }
        return salidaCsv;


    }
    public static void guardarjsonTurismo(ArrayList<TurismoData> arrayListTurismo, String filename ) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd")
                .create();

        try (FileWriter writer = new FileWriter(filename)) {
            // Convertir la lista de objetos a formato JSON y escribirlo en un archivo
            gson.toJson(arrayListTurismo, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarJsonComunidades (HashMap<String, ArrayList<TurismoData>> arrayListTurismo, String filename ) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd")
                .create();

        try (FileWriter writer = new FileWriter(filename)) {
            // Convertir la lista de objetos a formato JSON y escribirlo en un archivo
            gson.toJson(arrayListTurismo, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<TurismoData> filtrar (ArrayList<TurismoData> listaJson, Date date){
        ArrayList<TurismoData> listaJsonSalida= new ArrayList<>();
        for(TurismoData objeto:listaJson)
            if(objeto.getPeriodo().fechaEnPeriodo(date)){
                listaJsonSalida.add(objeto);
            }
        return listaJsonSalida;
    }


    public static ArrayList<TurismoData> leerJson (String path) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                //.registerTypeAdapter(int.class,new CustomNumberDeserializer())
                .create();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            ArrayList<TurismoData>listaObjetosJson = gson.fromJson(reader,new TypeToken<ArrayList<TurismoData>>(){}.getType());
            return listaObjetosJson;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }



    }

    public static HashMap<String, ArrayList<TurismoData>> agrupar (ArrayList<TurismoData> turismoList)
    {
        HashMap<String, ArrayList<TurismoData>> salida = new HashMap<String,ArrayList<TurismoData>>();

        for (TurismoData turismo:turismoList )
        {
            if(salida.containsKey(turismo.getDestino().getComunidad()))
            {
                salida.get(turismo.getDestino().getComunidad()).add(turismo);
            }
            else  {
                ArrayList<TurismoData> valor = new ArrayList<>();
                valor.add(turismo);
                salida.put(turismo.getDestino().getComunidad(),valor);
            }
        }
        return salida;
    }




}
