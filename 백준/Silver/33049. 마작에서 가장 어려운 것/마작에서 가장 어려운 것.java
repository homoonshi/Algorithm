
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int P3 = Integer.parseInt(input[0]);
        int P4 = Integer.parseInt(input[1]);
        int P0 = Integer.parseInt(input[2]);

        int T3 = 0;
        int T4 = 0;

        T3 = (P3/3);
        if(P3%3!=0) {
            P0 -= 3 - (P3 % 3);
            T3++;
        }

        T4 = (P4)/4;
        if(P4%4!=0){
            P0 -= 4 - (P4%4);
            T4++;
        }

        if(P0 > 0) {
            for (int i = (P0 / 4); i >= 0; i--) {

                int T0 = P0 - i * 4;

                if (T0 == 0 || T0 % 3 == 0) {
                    T4 += i;
                    T3 += T0 / 3;
                    P0 = 0;
                    break;
                }

            }
        }

        if(P0!=0){
            bw.write("-1");
        }else{
            bw.write(T3+" "+T4);
        }

        bw.flush();

    }

}
