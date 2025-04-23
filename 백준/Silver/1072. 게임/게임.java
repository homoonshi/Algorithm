
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        long X = Integer.parseInt(input[0]);
        long Y = Integer.parseInt(input[1]);

        long Z = (Y*100)/X;

        if(Z==100||Z==99){
            bw.write("-1");
            bw.flush();
            return;
        }

        long start = 1;
        long end = Integer.MAX_VALUE;

        while(start<=end){

            long mid = (start+end)/2;
            long z = (Y+mid)*100/(X+mid);

            if(z>=Z+1){
                end = mid-1;
            }else{
                start = mid+1;
            }

        }


        bw.write(start+"");
        bw.flush();

    }
}