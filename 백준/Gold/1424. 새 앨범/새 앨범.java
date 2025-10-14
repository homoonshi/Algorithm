import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int L = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int start = 0;
        int end = N;

        while(start <= end){
            int mid = (start + end) / 2;
            long len = (long) (L + 1) * mid - 1;

            if(len > C){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        for(int i=start; i>0; i--){
            if((long)(L+1)*i-1 > C || i%13==0){
                continue;
            }
            if(N%i != 0 && (N%i)%13 == 0){
                boolean e = false;
                for(int j=0; j<i-(N%i); j++){
                    if((i-j)%13!=0 && ((N%i)+j)%13!=0){
                        e = true;
                        break;
                    }
                }
                if(!e) continue;
            }
            start = i;
            break;
        }

        int res = N%start == 0 ? N/start : N/start + 1;

        bw.write(res+"");
        bw.flush();

    }
}