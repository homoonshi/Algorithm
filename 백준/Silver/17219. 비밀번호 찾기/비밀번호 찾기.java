
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, String> passwords = new HashMap<>();

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");

            passwords.put(input[0], input[1]);
        }

        for(int i=0; i<M; i++){
            String site = br.readLine();
            bw.write(passwords.get(site)+"\n");
        }

        bw.flush();
    }

}
