
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long[] solution;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        solution = new long[N];

        String input[] = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            solution[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(solution);

        long[] res = new long[3];

        long distance = Long.MAX_VALUE;

        int start, end;

        for(int i=0; i<N-2; i++) {

            start = i + 1;
            end = N - 1;

            while (start < end) {

                long sum = solution[i] + solution[start] + solution[end];
                long absSum = Math.abs(sum);

                if ( absSum < distance ) {
                    distance = absSum;
                    res[0] = solution[i];
                    res[1] = solution[start];
                    res[2] = solution[end];
                }

                if ( sum > 0) {
                    end--;
                } else if ( sum < 0){
                    start++;
                }else{
                    Arrays.sort(res);
                    for (int m = 0; m < 3; m++) {
                        bw.write(res[m] + " ");
                    }
                    bw.flush();
                    return;
                }

            }

        }

        Arrays.sort(res);
        for(int m=0; m<3; m++){
            bw.write(res[m]+" ");
        }
        bw.flush();

    }

}
