
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String result = "";

        for(int i=0; i<N; i++){
            String input = br.readLine();
            if(input.contains("S")){
                result = input;
                break;
            }
        }

        bw.write(result);
        bw.flush();

    }

}
