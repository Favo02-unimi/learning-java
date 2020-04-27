import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gui gui = new Gui();
        while (true) {
            Scanner in = new Scanner(System.in);
            pause();
            //System.out.println("---------------");
            //System.out.print("Nome: ");
            String requestedName = in.next();
            String rawData = "";
            try {
                rawData = apiCall(requestedName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ArrayList<String> data = elaborateString(rawData);

            String name = "";
            int level = 0;
            int eu_mmr = 0;
            int na_mmr = 0;
            int as_mmr = 0;
            double kd = 0.0;
            boolean notFound = false;
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).equals("p_name")) {
                    name = data.get(i + 1);
                    if (name.equalsIgnoreCase(requestedName)) {
                        level = returnNextInt(data, "level");
                        eu_mmr = returnNextInt(data, "EU_mmr");
                        na_mmr = returnNextInt(data, "NA_mmr");
                        as_mmr = returnNextInt(data, "AS_mmr");
                        kd = returnNextDouble(data, "kd");
                        break;
                    } else {
                        //System.err.println("Error 404 - Name not found.");
                        notFound = true;
                        break;
                    }
                }
            }
            if (!notFound) {
                Player player = new Player(name, level, eu_mmr, na_mmr, as_mmr, kd);
                //System.out.println(player);
            }
        }
    }

    public static String apiCall(String name) throws Exception {
        String url = "https://r6.apitab.com/search/uplay/";
        url += name;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        String data = "";
        while ((inputLine = in.readLine()) != null) {
            data += inputLine;
        }
        in.close();
        return data;
    }

    private static ArrayList<String> elaborateString(String data) {
        List<String> word = Arrays.asList(data.split("[:\",{}]"));
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < word.size(); i++) {
            if (!(word.get(i).equals(""))){
                words.add(word.get(i));
            }
        }
        return words;
    }

    private static int returnNextInt(ArrayList<String> data, String request) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(request)) {
                return Integer.parseInt(data.get(i+1));
            }
        }
        return -1;
    }

    private static double returnNextDouble(ArrayList<String> data, String request) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(request)) {
                return Double.parseDouble(data.get(i+1));
            }
        }
        return -1.0;
    }

    private static void pause() {
        try {
            Thread.sleep(50);
        } catch (Exception ignore) {}
    }
}
