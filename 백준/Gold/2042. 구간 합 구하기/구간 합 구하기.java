import java.io.*;
import java.util.*;

public class Main {

    static class SegmentTree{

        long[] tree;
        int n;

        SegmentTree(long[] arr){

            n = arr.length;
            tree = new long[n*2];

            for(int i=0; i<n; i++){
                tree[n+i] = arr[i];
            }

            for(int i=n-1; i>0; i--){
                tree[i] = tree[i*2] + tree[i*2+1];
            }

        }

        public long sum(int l, int r){
            long sum = 0;
            l += n;
            r += n;
            while(l < r){
                if((l & 1) == 1){
                    sum += tree[l++];
                }
                if((r & 1) == 1){
                    sum += tree[--r];
                }
                l >>= 1;
                r >>= 1;
            }
            return sum;
        }

        public void update(int index, long num){
            index += n;
            tree[index] = num;
            while(index > 1){
                index >>= 1;
                tree[index] = tree[2*index] + tree[2*index+1];
            }
        }

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        long[] arr = new long[N];

        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        SegmentTree seg = new SegmentTree(arr);

        for(int i=0; i<M+K; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            long c = Long.parseLong(input[2]);

            if(a == 1){
                seg.update(b-1, c);
            } else {
                bw.write(seg.sum(b-1, (int)c) + "\n");
            }
        }

        bw.flush();

    }
}
