import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < T; test_case++){

            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            if(N>32){
                bw.write("0\n");
                continue;
            }


            int res = 12;

            for(int i=0; i<N; i++){
                for(int j=i+1; j<N; j++){
                    int t1 = 4;
                    for (int k = 0; k < 4; k++) {
                        if (input[i].charAt(k) == input[j].charAt(k)) {
                            t1--;
                        }
                    }
                    for(int l=j+1; l<N; l++) {
                        int t2 = 4;
                        int t3 = 4;
                        for (int k = 0; k < 4; k++) {
                            if (input[j].charAt(k) == input[l].charAt(k)) {
                                t2--;
                            }
                            if (input[i].charAt(k) == input[l].charAt(k)) {
                                t3--;
                            }
                        }
                        res = Math.min(res, (t1+t2+t3));
                    }
                }
            }

            bw.write(res+"\n");

        }

        bw.flush();

    }
}