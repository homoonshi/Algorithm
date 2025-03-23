
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, String> maps = new HashMap<>();

        maps.put("NLCS", "North London Collegiate School");
        maps.put("BHA", "Branksome Hall Asia");
        maps.put("KIS", "Korea International School");
        maps.put("SJA", "St. Johnsbury Academy");

        bw.write(maps.get(br.readLine())+"");
        bw.flush();

    }

}
