
import java.util.*;
import java.io.*;

public class Main {

    static int L, N;
    static int[] tape;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);

        tape = new int[N];

        input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            tape[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(tape);

        int result = N;
        double start = tape[0]-0.5;
        double end = start + L;

        for(int i=1; i<N; i++){

            double temp = tape[i] + 0.5;

            if(end<temp){
                start = tape[i] - 0.5;
                end = start + L;
            }else{
                result--;
            }

        }

        bw.write(result+"");
        bw.flush();

    }

}
