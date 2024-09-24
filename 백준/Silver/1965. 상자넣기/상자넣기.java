
import java.util.*;
import java.io.*;

public class Main {

    static int[] increase;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        increase = new int[n];

        int result = 1;

        increase[0] = Integer.parseInt(input[0]);

        int maxIndex;

        for(int i=1; i<n; i++){
            int num = Integer.parseInt(input[i]);
            maxIndex = -1;
            for(int j=0; j<result; j++){
                if(maxIndex!=-1&&increase[j]>num){
                    break;
                }
                if(increase[j]>=num){
                    maxIndex=j;
                }
            }
            if(maxIndex==-1){
                increase[result++] = num;
                continue;
            }
            increase[maxIndex] = num;
        }

        bw.write(result+"");
        bw.flush();

    }

}
