import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        long X = Long.parseLong(input[0]);
        long Y = Long.parseLong(input[1]);

        long R = Y-X;

        if(R==0){
            bw.write("0");
            bw.flush();
            return;
        }

        long start = 0;
        long end = Y;
        long ans = 0;

        if(R>2 && R <= 4){
            bw.write("3");
            bw.flush();
            return;
        }

        while(start <= end){
            long mid = (start+end) / 2;
            long sum = (mid)*(mid);
            if(sum > R){
                end = mid - 1;
            }else if(sum < R){
                ans = mid;
                start = mid + 1;
            }else {
                ans = mid;
                break;
            }
        }

        long day = 1;

        if(R<=(ans*ans)){
            day = (ans)*2-1;
        }else{
            day = R-(ans*ans) <= ans ? ans*2 : ans*2+1;
        }

        bw.write(day+"");
        bw.flush();

    }
}