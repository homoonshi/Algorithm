import java.io.*;
import java.util.*;

public class Main {

    static class Segment {

        long[][] tree;
        int[] arr;

        public Segment(int[] arr) {
            this.arr = arr;
            tree = new long[arr.length*4][2];
            build(1, 0, arr.length - 1);
        }

        private void build(int node, int start, int end) {
            if (start == end){
                tree[node][0] = arr[start];
                tree[node][1] = start;
            } else {
                int mid = (start + end) / 2;
                build(2*node, start, mid);
                build(2*node + 1, mid+1, end);
                tree[node] = min(tree[2*node], tree[2*node+1]);
            }
        }

        private long[] min(long[] a, long[] b){
            if (a[0] < b[0]) return a;
            if (a[0] > b[0]) return b;
            return a[1] < b[1] ? a : b;
        }

        public long[] query(int node, int start, int end, int l, int r){
            if (r < start || end < l) return new long[]{Integer.MAX_VALUE, -1};
            if (l <= start && end <= r) return tree[node];
            int mid = (start + end)/2;
            return min(query(node * 2, start, mid, l, r),
                    query(node * 2 + 1, mid + 1, end, l, r));
        }

        public void update(int node, int start, int end, int index, int value){
            if (start == end){
                tree[node][0] = value;
                tree[node][1] = index;
            } else {
                int mid = (start + end) / 2;
                if (index <= mid) update(node*2, start, mid, index, value);
                else update(node*2+1, mid+1, end, index, value);
                tree[node] = min(tree[node*2], tree[node*2+1]);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(input[i]);
            arr[i] = num;
        }

        Segment segment = new Segment(arr);

        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){

            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            switch (a){
                case 1:
                    segment.update(1, 0, N-1, b-1, c);
                    break;
                case 2:
                    bw.write(segment.query(1, 0, N-1, b-1, c-1)[1]+1+"\n");
            }

        }

        bw.flush();

    }
}