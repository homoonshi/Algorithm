import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=N; i>0; i--) {
            for (int j = 0; j < N; j++) {
                if (j < N-i) {
                    bw.write(" ");
                } else {
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