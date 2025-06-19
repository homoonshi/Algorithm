
import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] len;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        len = new int[n];

        String[] input = br.readLine().split(" ");

        for(int i=0; i<n; i++){
            len[i] = Integer.parseInt(input[i]);
        }

        int[] res = new int[n];
        Arrays.fill(res, Integer.MIN_VALUE);
        int index = 0;

        res[0] = len[0];

        for(int i=1; i<n; i++){

            int start = 0;
            int end = index;

            while(start<=end){
                int mid = (start + end) / 2;
                if(res[mid]<len[i]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }

            if(res[start]>=len[i]) {
                res[start] = len[i];
            }else{
                res[start] = len[i];
                index++;
            }

        }

        bw.write((index+1)+"");
        bw.flush();

    }

}