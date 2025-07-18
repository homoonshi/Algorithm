import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] cards = new int[N];

        for(int i=0; i<N; i++){
            cards[i] = Integer.parseInt(input[i]);
        }

        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");

        Arrays.sort(cards);

        for(int i=0; i<M; i++){

            int s = Integer.parseInt(input[i]);

            int start = 0;
            int end = N-1;

            while(start<=end){

                int mid = (start + end) / 2;

                if(cards[mid]>=s){
                    end = mid-1;
                }else{
                    start = mid+1;
                }

            }

            if(start<N && cards[start]==s){
                bw.write("1 ");
            }else{
                bw.write("0 ");
            }

        }

        bw.flush();

    }
}