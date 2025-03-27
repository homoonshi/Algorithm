
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] input;

        for(int testCase = 0; testCase<T; testCase++){

            input = br.readLine().split(" ");

            int sx = Integer.parseInt(input[0]);
            int sy = Integer.parseInt(input[1]);
            int dx = Integer.parseInt(input[2]);
            int dy = Integer.parseInt(input[3]);

            int N = Integer.parseInt(br.readLine());

            int result = 0;

            for(int n=0; n<N; n++){

                input = br.readLine().split(" ");

                int ox = Integer.parseInt(input[0]);
                int oy = Integer.parseInt(input[1]);
                int r = Integer.parseInt(input[2]);

                boolean sp = Math.pow((sx-ox),2) + Math.pow((sy-oy), 2) <= Math.pow(r,2);
                boolean dp = Math.pow((dx-ox),2) + Math.pow((dy-oy), 2) <= Math.pow(r,2);

                if(sp && !dp){
                    result++;
                }else if(!sp && dp){
                    result++;
                }

            }

            bw.write(result+"\n");

        }

        bw.flush();

    }

}
