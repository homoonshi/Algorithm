
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] sixItem = new int[M];
        int[] oneItem = new int[M];

        for(int i=0; i<M; i++){

            input = br.readLine().split(" ");

            sixItem[i] = Integer.parseInt(input[0]);
            oneItem[i] = Integer.parseInt(input[1]);

        }

        Arrays.sort(sixItem);
        Arrays.sort(oneItem);

        int result = 0;

        if(sixItem[0]>=oneItem[0]*6){
            result = oneItem[0]*N;
        }else{
            result = sixItem[0]*(N/6);
            N%=6;
            if(sixItem[0]>=oneItem[0]*N){
                result += oneItem[0]*N;
            }else{
                result += sixItem[0];
            }
        }

        bw.write(result+"");
        bw.flush();

    }

}
