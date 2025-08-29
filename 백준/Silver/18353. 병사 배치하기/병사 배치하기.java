import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int[] res = new int[N];
        res[0] = Integer.parseInt(input[0]);

        int start = 0;
        int end = 0;

        int count = 0;

        int r = 0;

        for(int i=1; i<N; i++){
            int n = Integer.parseInt(input[i]);
            start = 0;
            end = count;
            while(start<=end){
                int mid = (start+end) / 2;
                if(res[mid]>n){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
            if(start>count){
                res[start] = n;
                count++;
                continue;
            }
            res[start] = n;
            r++;
        }

        bw.write(r+"");
        bw.flush();

    }
}