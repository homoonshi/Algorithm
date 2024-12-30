
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < T; test_case++){

            String[] input = br.readLine().split(" ");

            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            BigInteger result = new BigInteger("1");

            for(int i=m; i>m-n; i--){
                result = result.multiply(new BigInteger(String.valueOf(i)));
            }

            for(int i=1; i<=n; i++){
                result = result.divide(new BigInteger(String.valueOf(i)));
            }

            bw.write(result.toString()+"\n");
        }

        bw.flush();

    }

}
