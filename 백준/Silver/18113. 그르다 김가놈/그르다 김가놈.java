import java.io.*;
import java.util.*;

public class Main {

    static int N, K, M;
    static List<Integer> bap;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        M = Integer.parseInt(input[2]);

        bap = new ArrayList<>();
        int end = 0;

        for(int i=0; i<N; i++){
            int b = Integer.parseInt(br.readLine());
            if(b==2*K || b<=K){
                continue;
            } else if(b>2*K){
                b-=2*K;
            }else if(b>K){
                b-=K;
            }
            bap.add(b);
            end = Math.max(end, b);
        }

        int start = 1;

        while(start<=end){

            int mid = (start+end) / 2;
            int count = 0;

            for (Integer b : bap) {
                if(b>=mid){
                    count += b/mid;
                }
            }

            if(count>=M){
                start = mid+1;
            }else{
                end = mid-1;
            }

        }

        if(end==0){
            bw.write("-1");
        }else{
            bw.write(end+"");
        }

        bw.flush();

    }
}