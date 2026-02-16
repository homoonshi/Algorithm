import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        boolean equalCheck = true;
        int res = 0;
        int dis = input[1].length() - input[0].length();

        if(dis==0) {
            for (int i = 0; i < input[0].length(); i++) {
                int min = input[0].charAt(i) - '0';
                int max = input[1].charAt(i) - '0';
                if (!equalCheck) continue;
                if (equalCheck) {
                    if (min == max) {
                        if (min == 8) {
                            res++;
                        }
                        continue;
                    }
                    equalCheck = false;
                }
            }
        }

        bw.write(res+"");
        bw.flush();
    }
}