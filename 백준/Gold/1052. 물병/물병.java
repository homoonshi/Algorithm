import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int standard = N;
        int minWater = N;

        for(int i=0; i<K; i++){
            minWater = searchWaterPot(standard);
            standard -= minWater;
        }

        int res = standard > 0 ? minWater - standard : 0;

        bw.write(res+"");
        bw.flush();
    }

    private static int searchWaterPot(int standard) {
        int res = 1;
        int index = 1;
        while(res*2 < standard){
            res = (int) Math.pow(2, index++);
        }
        return res;
    }


}