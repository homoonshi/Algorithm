
import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> decimal = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        findDecimal();

        tc : for(int test_case=0; test_case<N; test_case++){

            long S = Long.parseLong(br.readLine());

            for (Integer d : decimal) {
                if(S%d==0){
                    bw.write("NO\n");
                    continue tc;
                }
            }

            bw.write("YES\n");

        }

        bw.flush();

    }

    public static void findDecimal(){

        boolean[] isDecimal = new boolean[1000001];

        for(int i=2; i<=1000000; i++){

            if(isDecimal[i]){
                continue;
            }

            if(!isDecimal[i]){
                decimal.add(i);
            }

            for(long j=(long)i*i; j<=1000000; j++){
                if(j%i==0){
                    isDecimal[(int)j] = true;
                }
            }
        }

    }

}
