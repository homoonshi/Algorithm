import java.io.*;
import java.util.*;

public class Main {
    static String str1;
    static String str2;
    static int[][] dp;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str1 = br.readLine();
        str2 = br.readLine();

        dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int len = dp[str1.length()][str2.length()];
        bw.write(len+"\n");

        StringBuilder res = new StringBuilder("");

        if(len>0){
            int i = str1.length();
            int j = str2.length();
            while( i > 0 && j > 0 ){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    res.append(str1.charAt(i-1));
                    i--;
                    j--;
                }else{
                    if(dp[i-1][j]>=dp[i][j-1]){
                        i--;
                    }else{
                        j--;
                    }
                }
            }
            bw.write(res.reverse().toString());
        }
        bw.flush();
    }
}