import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.*;

public class MeteoAPI {

    public static void main(String[] args) throws Exception {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Inserire città: ");
            String citta = in.nextLine();

            final String KEY = "738e4aa8d76ffccc614a3acdffa6675c";

            String sURL = "https://api.openweathermap.org/data/2.5/weather?q=" + citta + "&appid=" + KEY + "&lang=it&units=metric";
            URL url = new URL(sURL);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == 404) {
                System.err.println("Errore, città inesistente!\n");
                Thread.sleep(300);
                continue;
            }
            if (connection.getResponseCode() != 200) {
                System.err.println("Errore, codice errore: " + connection.getResponseCode() + ".\n");
                Thread.sleep(300);
                continue;
            }

            BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = read.readLine();
            String responseBody = "";
            while (line != null) {
                responseBody += line;
                line = read.readLine();
            }

            JSONObject rispostacompleta = new JSONObject(responseBody);

            JSONArray weatherArray = rispostacompleta.getJSONArray("weather");
            JSONObject weatherObject = weatherArray.getJSONObject(0);
            String tempo = weatherObject.getString("description");

            JSONObject coord = rispostacompleta.getJSONObject("coord");
            double lat = coord.getDouble("lat");
            double lon = coord.getDouble("lon");

            JSONObject temp = rispostacompleta.getJSONObject("main");
            double tempAttuale = temp.getDouble("temp");
            double tempMax = temp.getDouble("temp_max");
            double tempMin = temp.getDouble("temp_min");
            int umidita = temp.getInt("humidity");

            System.out.println("Condizioni a " + citta + " (a coordinate " + lon + ", " + lat + "):"
                    + "\nTempo: " + tempo
                    + "\nTemperatura: " + tempAttuale + "°C"
                    + "\nTemperatura massima: " + tempMax + "°C"
                    + "\nTemperatura minima: " + tempMin + "°C"
                    + "\nUmidita: " + umidita + "%\n");

            connection.disconnect();
        }
    }
    
    private static JSONObject getRispostaCompleta(String citta) throws Exception {
        final String KEY = "738e4aa8d76ffccc614a3acdffa6675c";

        String sURL = "https://api.openweathermap.org/data/2.5/weather?q=" + citta + "&appid=" + KEY + "&lang=it&units=metric";
        URL url = new URL(sURL);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        if (connection.getResponseCode() == 404) {
            System.err.println("Errore, città inesistente!\n");
            Thread.sleep(300);
            return null;
        }
        if (connection.getResponseCode() != 200) {
            System.err.println("Errore, codice errore: " + connection.getResponseCode() + ".\n");
            Thread.sleep(300);
            return null;
        }

        BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = read.readLine();
        String responseBody = "";
        while (line != null) {
            responseBody += line;
            line = read.readLine();
        }

        return new JSONObject(responseBody);
    }
    
    public static String getTempo(String citta) throws Exception {
        JSONObject rispostaCompleta = getRispostaCompleta(citta);
        JSONArray weatherArray = rispostaCompleta.getJSONArray("weather");
        JSONObject weatherObject = weatherArray.getJSONObject(0);
        return weatherObject.getString("description");
    }

    public static double[] getCoord(String citta) throws Exception {
        JSONObject rispostaCompleta = getRispostaCompleta(citta);
        JSONObject coord = rispostaCompleta.getJSONObject("coord");
        double lat = coord.getDouble("lat");
        double lon = coord.getDouble("lon");
        return new double[] {lat, lon};
    }

    public static double[] getTemp(String citta) throws Exception {
        JSONObject rispostaCompleta = getRispostaCompleta(citta);
        JSONObject temp = rispostaCompleta.getJSONObject("main");
        double tempAttuale = temp.getDouble("temp");
        double tempMax = temp.getDouble("temp_max");
        double tempMin = temp.getDouble("temp_min");
        int umidita = temp.getInt("humidity");
        return new double[] {tempAttuale, tempMax, tempMin, umidita};
    }

}