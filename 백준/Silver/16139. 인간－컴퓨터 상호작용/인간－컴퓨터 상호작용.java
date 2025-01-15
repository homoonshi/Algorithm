
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        int q = Integer.parseInt(br.readLine());
        int[][] dp = new int[S.length()+1][26];

        for(int i=0; i<S.length(); i++){

            for(int j=0; j<26; j++){
                dp[i+1][j] = dp[i][j];
            }

            char c = S.charAt(i);
            int index = c - 'a';

            dp[i+1][index] = dp[i][index] + 1;

        }

        String[] input;

        for(int i=0; i<q; i++){

            input = br.readLine().split(" ");

            char c = input[0].charAt(0);
            int index = c - 'a';

            int start = Integer.parseInt(input[1]);
            int end = Integer.parseInt(input[2]);

            int result = dp[end+1][index] - dp[start][index];

            bw.write(result+"\n");

        }

        bw.flush();

    }

}
