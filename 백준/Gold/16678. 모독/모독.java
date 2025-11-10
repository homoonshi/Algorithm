import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        long res = 0;
        int defile = 1;

        for(int i=0; i<N; i++){
            if(nums[i] >= defile){
                res += nums[i] - defile;
                defile++;
            }
        }

        bw.write(res+"");
        bw.flush();

    }
}