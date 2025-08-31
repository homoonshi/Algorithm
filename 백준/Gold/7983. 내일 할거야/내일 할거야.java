import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] work = new int[n][2];
        int end = 0;

        for(int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");
            work[i][0] = Integer.parseInt(input[0]);
            work[i][1] = Integer.parseInt(input[1]);
            end = Math.max(end, work[i][1]);
        }

        Arrays.sort(work, (o1, o2) -> {
            if(o1[1]>o2[1]) return -1;
            return 1;
        });

        for(int i=0; i<n; i++){
            if(end > work[i][1]){
                end = work[i][1] - work[i][0];
                continue;
            }
            end -= work[i][0];
        }

        bw.write(end+"");
        bw.flush();

    }
}