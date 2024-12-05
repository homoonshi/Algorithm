import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] speed = new int[8];

        String[] input = br.readLine().split(" ");

        int start = Integer.parseInt(input[0]);
        speed[0] = start;
        
        if(start!=1 && start!=8){
            bw.write("mixed");
            bw.flush();
            return;
        }

        int distance = 0;
        
        for(int i=1; i<8; i++){
            speed[i] = Integer.parseInt(input[i]);
            distance = speed[i] - speed[i-1];
            if((start==1&&distance!=1) || (start==8&&distance!=(-1)) || distance > 1){
                bw.write("mixed");
                bw.flush();
                return;
            }
        }

        if(start==1 && speed[7]==8){
            bw.write("ascending");
        }

        if(start==8 && speed[7]==1){
            bw.write("descending");
        }

        bw.flush();
    }

    
}
