
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] dp = new int[k+1];
        Arrays.fill(dp, 10001);

        List<Integer> coins = new ArrayList<>();
        Set<Integer> has = new HashSet<>();

        for(int i=0; i<n; i++){
            int t = Integer.parseInt(br.readLine());
            if(!has.contains(t) && t<=k){
                coins.add(t);
                has.add(t);
                dp[t] = 1;
            }
        }

        for(int i=1; i<k; i++){
            if(dp[i]<=10000){
                for(int j=0; j<coins.size(); j++){
                    int next = i + coins.get(j);
                    if(next<=k){
                        dp[next] = Math.min(dp[next], dp[i] + 1);
                    }
                }
            }
        }

        if(dp[k]<=10000) {
            bw.write(dp[k] + "");
        }else{
            bw.write("-1");
        }
        bw.flush();

    }
}