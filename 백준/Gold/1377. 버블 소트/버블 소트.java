
import java.util.*;
import java.io.*;

public class Main {

    static class Num implements Comparable<Num> {

        int index;
        int num;

        public Num(int index, int num) {
            this.index = index;
            this.num = num;
        }

        @Override
        public int compareTo(Num o) {
            return this.num - o.num;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Num[] nums = new Num[N];

        for(int i=0; i<N; i++){
            nums[i] = new Num(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(nums);
        int result = 0;

        for(int i=0; i<N; i++){
            result = Math.max(result, nums[i].index-i);
        }

        bw.write(result+1+"");
        bw.flush();

    }

}
