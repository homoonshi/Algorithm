import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int index = 0;
        int max = 0;
        
        for(int i=1; i<=9; i++){
            int num = Integer.parseInt(br.readLine());
            
            if(num>max){
                index = i;
                max = num;
            }
        }
        
        bw.write(max+"\n");
        bw.write(index+"");
        bw.flush();

    }
}