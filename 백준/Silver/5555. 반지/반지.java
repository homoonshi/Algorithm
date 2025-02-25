
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String search = br.readLine();

        int n = Integer.parseInt(br.readLine());

        String[] ring = new String[n];

        for(int i=0; i<n; i++){
            ring[i] = br.readLine();
            ring[i] += ring[i];
        }

        int result = 0;

        for(int i=0; i<n; i++){

            if(ring[i].contains(search)){
                result++;
            }

        }


        bw.write(result+"");
        bw.flush();

    }

}
