
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder("");
        
        int five = n/5;
        int one = n%5;
        
        for(int i=0; i<five; i++){
            sb.append("V");
        }
        
        for(int i=0; i<one; i++){
            sb.append("I");
        }
        
        bw.write(sb.toString());
        bw.flush();
        
    }
}