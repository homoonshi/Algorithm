import java.io.*;
import java.util.*;

public class Main {

    static boolean[] p;
    static int max_value = 1_000_000;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        p = new boolean[max_value+1];

        List<Integer> primes = prime();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");

            int[] nums = new int[2];

            nums[0] = Integer.parseInt(input[0]);
            nums[1] = Integer.parseInt(input[1]);

            int start = 0;
            int end = primes.size() - 1;

            while(start<=end){
                int mid = (start+end) / 2;
                if(nums[0]<=primes.get(mid)){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }

            int startIndex = start;

            start = 0;
            end = primes.size() - 1;

            while(start<=end){
                int mid = (start+end) / 2;
                if(nums[1]<=primes.get(mid)){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }

            int endIndex = start;
            if (endIndex >= primes.size()) {
                endIndex = primes.size() - 1;
            }
            if (startIndex >= primes.size() || endIndex < startIndex) {
                bw.write("-1\n");
                continue;
            }
            
            int len = primes.get(endIndex) > nums[1] ? endIndex - startIndex : endIndex - (startIndex-1);

            if(len<=0 || len%2==0){
                bw.write("-1\n");
                continue;
            }

            bw.write(primes.get((endIndex+startIndex)/2)+"\n");

        }

        bw.flush();

    }

    public static List<Integer> prime(){
        List<Integer> lists = new ArrayList<>();
        for (int i = 2; i <= max_value; i++) {
            if (!p[i]) {
                lists.add(i);
                for (long j = (long) i * i; j <= max_value; j += i) {
                    p[(int) j] = true;
                }
            }
        }
        return lists;
    }
}