import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] button = {60, 10, -10, 1, -1};

        for(int test_case=0; test_case<T; test_case++){

            int N = Integer.parseInt(br.readLine());
            int[] result = new int[5];

            int time = 0;

            while(time != N){
                int index = setTime(N, time);
                result[index]++;
                time += button[index];
            }

            for(int i=0; i<5; i++){
                bw.write(result[i] + " ");
            }

            bw.write("\n");
        }

        bw.flush();
    }

    public static int setTime(int time, int current){

        int t = time-current;

        if(t <= -10){
            return 2;
        }else if(t >= 36){
            return 0;
        }else if(t >= 10){
            return 1;
        }else if(t > 0){
            if (t<=5){
                return 3;
            }
            return 1;
        }else {
            if (t>=-5){
                return 4;
            }
            return 2;
        }

    }

}