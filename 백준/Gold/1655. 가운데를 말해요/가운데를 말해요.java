
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> nums = new ArrayList<>();
        nums.add(Integer.parseInt(br.readLine()));

        bw.write(nums.get(0)+"\n");

        for(int i=1; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            int start = 0;
            int end = nums.size() - 1;

            while(start<=end){

                int mid = (start+end) / 2;
                int val = nums.get(mid);

                if(val<=num){
                    start = mid+1;
                }else{
                    end = mid-1;
                }

            }

            nums.add(start, num);
            int size = nums.size();

            if(size%2==0){
                bw.write(nums.get(size/2-1)+"\n");
            }else{
                bw.write(nums.get(size/2)+"\n");
            }
        }

        bw.flush();

    }
}