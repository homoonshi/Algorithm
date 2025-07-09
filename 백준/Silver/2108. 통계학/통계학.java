import java.io.*;
import java.util.*;

public class Main {

    static class Num implements Comparable<Num> {

        int num;
        int count;

        public Num(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Num o) {
            return o.count == this.count ? this.num - o.num : o.count - this.count;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] res = new int[4];

        int min = 4001;
        int max = -4001;

        PriorityQueue<Num> pq = new PriorityQueue<>();
        Map<Integer, Num> map = new HashMap<>();

        int[] nums = new int[N];

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());

            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);

            res[0] += nums[i];

            if(map.containsKey(nums[i])){
                map.get(nums[i]).count++;
            }else{
                Num num = new Num(nums[i], 1);
                map.put(nums[i], num);
            }
        }

        pq.addAll(map.values());

        Arrays.sort(nums);
        res[0] = (int) Math.round((double) res[0]/N);
        res[1] = nums[N/2];
        Num temp = pq.poll();
        if(pq.isEmpty() || pq.peek().count!=temp.count){
            res[2] = temp.num;
        }else{
            res[2] = pq.poll().num;
        }
        res[3] = max-min;

        for(int i=0; i<4; i++){
            bw.write(res[i]+"\n");
        }

        bw.flush();

    }
}