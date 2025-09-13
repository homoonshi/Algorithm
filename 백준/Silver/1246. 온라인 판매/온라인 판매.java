import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int cost = 0;
        int sum = 0;

        Integer[] customer = new Integer[M];

        for(int i=0; i<M; i++){
            customer[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(customer, (o1, o2) -> o2 - o1);

        for(int i=1; i<=M; i++){
            int s = customer[i-1] * (Math.min(N, i));
            if(sum < s){
                cost = customer[i-1];
                sum = s;
            }
        }

        bw.write(cost+" "+sum);
        bw.flush();

    }
}