import java.io.*;
import java.util.*;

public class Main {

    static class Segment {

        int n;
        long[] tree;

        Segment(long[] temp){
            n = temp.length;
            tree = new long[n * 2];
            build(temp);
        }

        public void build(long[] temp){
            for (int i = 0; i < n; i++) {
                tree[i + n] = temp[i];
            }
            for (int i = n - 1; i > 0; i--) {
                tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % 1000000007;
            }
        }

        public void update(int index, int num){
            index += n;
            tree[index] = num;
            while(index > 1){
                index >>= 1;
                tree[index] = (tree[2*index] * tree[2*index+1]) % 1000000007;
            }
        }

        public long sum(int l, int r){
            l += n;
            r += n;
            long result = 1;
            while (l < r) {
                if ((l & 1) == 1) {
                    result = (result * tree[l++]) % 1000000007;
                }
                if ((r & 1) == 1) {
                    result = (result * tree[--r]) % 1000000007;
                }
                l >>= 1;
                r >>= 1;
            }
            return result;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        long[] data = new long[N];

        for (int i = 0; i < N; i++) {
            data[i] = Long.parseLong(br.readLine());
        }

        Segment seg = new Segment(data);

        int a, b, c;

        for (int i = 0; i < M + K; i++) {
            input = br.readLine().split(" ");

            a = Integer.parseInt(input[0]);

            if (a == 1) {
                b = Integer.parseInt(input[1]);
                c = Integer.parseInt(input[2]);

                seg.update(b - 1, c);
            } else {
                b = Integer.parseInt(input[1]);
                c = Integer.parseInt(input[2]);

                long result = seg.sum(b - 1, c);
                bw.write(result + "\n");
            }
        }

        bw.flush();
    }
}
