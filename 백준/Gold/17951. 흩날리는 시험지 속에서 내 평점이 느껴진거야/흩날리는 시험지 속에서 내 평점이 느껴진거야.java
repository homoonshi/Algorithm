
import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] pages;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        pages = new int[N];

        int start = 0;
        int end = 0;

        input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            pages[i] = Integer.parseInt(input[i]);
            end += pages[i];
        }

        while(start<=end){

            int mid = (start + end) / 2;

            if(isScore(mid)){
                start = mid + 1;
            }else{
                end = mid - 1;
            }

        }

        bw.write(end+"");
        bw.flush();

    }

    public static boolean isScore(int score){
        int k = 0;
        int sum = 0;

        for(int i=0; i<N; i++){
            sum += pages[i];
            if(sum >= score){
                k++;
                sum = 0;
            }
        }

        return K <= k;
    }

}