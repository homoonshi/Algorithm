import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int t = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        if(t>=12 && t<=16 && s==0){
            bw.write("320");
            bw.flush();
            return;
        }

        bw.write("280");
        bw.flush();

    }
}