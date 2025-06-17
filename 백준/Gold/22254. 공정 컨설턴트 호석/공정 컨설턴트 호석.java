import java.io.*;
import java.util.PriorityQueue;

public class Main {

    static class Factory implements Comparable<Factory> {
        int index;
        int sum;

        public Factory(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }

        @Override
        public int compareTo(Factory o) {
            return this.sum - o.sum;
        }
    }

    static int N, X;
    static int[] nums;
    static PriorityQueue<Factory> pq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);

        nums = new int[N];

        input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        int start = 1;
        int end = N;

        while(start<=end){
            int mid = (start + end) / 2;
            pq = new PriorityQueue<>();

            for(int i=0; i<mid; i++){
                pq.add(new Factory(i, 0));
            }

            if(batchGift()){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        bw.write(start+"");
        bw.flush();

    }

    private static boolean batchGift() {
        for(int i=0; i<N; i++){
            if(pq.isEmpty()){
                return false;
            }
            Factory f = pq.poll();
            f.sum += nums[i];
            if(f.sum > X){
                return false;
            }
            if(f.sum != X){
                pq.add(f);
            }
        }
        return true;
    }
}