
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        int[] nums = new int[N];

        int day = 0;
        long eat = 0;

        nums[0] = Integer.parseInt(input[0]);

        for(int i=1; i<N; i++){
            int num = Integer.parseInt(input[i]);
            if(num!=nums[0]) {
                eat += num - nums[0];
                day++;
            }
        }

        bw.write(eat+" "+day);
        bw.flush();

    }


}
