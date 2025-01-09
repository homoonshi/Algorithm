
import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String s = br.readLine();
        String t = br.readLine();

        dp = new int[s.length()+1][t.length()+1];
        int result = 0;

        for(int i=0; i<s.length(); i++){

            for(int j=0; j<t.length(); j++){

                if(s.charAt(i)==t.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    result = Math.max(dp[i+1][j+1], result);
                }

            }

        }

        bw.write(result+"");
        bw.flush();

    }

}
