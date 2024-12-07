
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static int[] code;
    static BigInteger result;
    static int N;
    static BigInteger[][] dp;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        N = input.length();
        code = new int[N];
        dp = new BigInteger[N][3];

        for(int i=0; i<N; i++){
            code[i] = input.charAt(i) - '0';
            dp[i][1] = new BigInteger("0");
            dp[i][2] = new BigInteger("0");
        }

        result = new BigInteger("0");

        interpret(0);

        result = result.mod(BigInteger.valueOf(1000000));

        bw.write(result.toString()+"");
        bw.flush();

    }

    public static void interpret(int position){

        if(position==N){
            result = result.add(BigInteger.ONE);
            return;
        }

        BigInteger res = new BigInteger(result.toString());

        if(code[position]>0){
            if(dp[position][1].equals(BigInteger.ZERO)){
                interpret(position+1);
                dp[position][1] = result.subtract(res);
            }else{
                result = result.add(dp[position][1]);
            }
        }

        res = new BigInteger(result.toString());

        if(position+1 < N){
            int c = code[position]*10 + code[position+1];
            if(10<=c && c<=26) {
                if (dp[position][2].equals(BigInteger.ZERO)) {
                    interpret(position + 2);
                    dp[position][2] = result.subtract(res);
                }else{
                    result = result.add(dp[position][2]);
                }
            }
        }

    }

}
