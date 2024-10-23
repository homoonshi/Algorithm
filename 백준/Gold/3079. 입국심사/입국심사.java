
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        int[] times = new int[m];

        for(int i=0; i<m; i++){

            times[i] = Integer.parseInt(br.readLine());

        }

        long end = (long) 1000000000 * n;
        long start = 0;

        long person = 0;

        while (start <= end){

            long mid = (long) (start+end) / 2;

            person = 0;

            for(int i=0; i<times.length; i++){

                person += (long) mid / times[i];

                if( n < person ){
                    break;
                }

            }

            if ( n <= person ){
                end = mid-1;
            }else {
                start = mid+1;
            }

        }


        bw.write(start+"");
        bw.flush();

    }

}
