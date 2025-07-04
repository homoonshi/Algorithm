import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=N; i>1; i--){
            for (int j = N; j > 0; j--) {
                if (j <= i) {
                    bw.write("*");
                } else {
                    bw.write(" ");
                }
            }
            for (int j = 1; j < N; j++) {
                if (j < i) {
                    bw.write("*");
                }
            }
            bw.write("\n");
        }

        for(int i=N; i>0; i--) {
            for (int j = 0; j < N; j++) {
                if (j < i-1) {
                    bw.write(" ");
                } else {
                    bw.write("*");
                }
            }
            for (int j = 1; j < N; j++) {
                if (j <= N-i) {
                    bw.write("*");
                }
            }
            if (i != 1) {
                bw.write("\n");
            }
        }

        bw.flush();

    }
}