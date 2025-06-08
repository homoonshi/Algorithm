import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        int[][] dp = new int[a.length()+1][b.length()+1];

        for(int i=1; i<=a.length(); i++){
            for(int j=1; j<=b.length(); j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        Deque<Character> res = new ArrayDeque<>();

        int c = a.length();
        int r = b.length();

        while(true){

            if(dp[c][r]==0){
                break;
            }

            if((dp[c-1][r]==dp[c][r-1])&&(dp[c-1][r]<dp[c][r])){
                res.addFirst(a.charAt(c-1));
                c = c-1;
                r = r-1;
            }else{
                if(dp[c-1][r]>dp[c][r-1]){
                    c--;
                }else{
                    r--;
                }
            }

        }

        bw.write(dp[a.length()][b.length()]+"\n");

        while(!res.isEmpty()){
            bw.write(res.pollFirst());
        }

        bw.flush();

    }
}