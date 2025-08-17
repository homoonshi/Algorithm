import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int before = Integer.parseInt(br.readLine());
        int after = Integer.parseInt(br.readLine());
        int res = 0;

        for(int i=0; i<3; i++){
            int current = after%10;
            res += before*current * Math.pow(10, i);
            bw.write(before*current+"\n");
            after = after/10;
        }

        bw.write(res+"");
        bw.flush();

    }
}