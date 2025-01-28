
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] nums = new int[N];

        boolean up = true;
        nums[0] = Integer.parseInt(input[0]);
        int result = 0;
        int current = 1;

        for(int i=1; i<N; i++){
            nums[i] = Integer.parseInt(input[i]);
            if(nums[i]>nums[i-1]){
                if(!up){
                    result = Math.max(result, current);
                    current = 2;
                    up = true;
                    continue;
                }
                current++;
            }else if(nums[i]<nums[i-1]){
                current++;
                up = false;
            }else {
                result = Math.max(result, current);
                current = 1;
                up = true;
            }
        }

        result = Math.max(result, current);

        bw.write(result+"");
        bw.flush();

    }

}
