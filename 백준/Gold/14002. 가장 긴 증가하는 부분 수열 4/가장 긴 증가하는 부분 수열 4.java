
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] A;
    static int[] dp;
    static int[] indexs;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp = new int[N+1];
        indexs = new int[N+1];

        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(input[i]);
        }

        int maxCount = 0;
        int maxIndex = 0;

        for(int i=0; i<N; i++){

            dp[i] = 1;

            for(int j=0; j<i; j++){
                if(A[i] > A[j] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    indexs[i] = j;
                }
            }

            if(dp[i] > maxCount) {
                maxCount = dp[i];
                maxIndex = i;
            }

        }

        bw.write(maxCount+"\n");

        int[] res = new int[maxCount];
        int index = maxIndex;

        for(int i=maxCount-1; i>=0; i--){
            res[i] = A[index];
            index = indexs[index];
        }

        for(int i=0; i<maxCount; i++){
            bw.write(res[i]+" ");
        }

        bw.flush();

    }

}
