
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        long maxR = Math.max(R-1, N-R);
        long maxC = Math.max(C-1, N-C);

        if(maxR<2 && maxC<2){
            bw.write("1");
            bw.flush();
            return;
        }

        N = N*N;

        if(Math.sqrt(N)>=4 && N%2==1 && (R%2)==(C%2)){
            bw.write((N/2)+1+"");
        }else {
            bw.write(N/2 + "");
        }

        bw.flush();

    }

}
