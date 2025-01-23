
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] nums = new int[T];
        int maxNum = 0;

        for(int i=0; i<T; i++){
            nums[i] = Integer.parseInt(br.readLine());
            maxNum = Math.max(nums[i], maxNum);
        }

        boolean[] minority = searchMinority(maxNum);

        int[][] result = new int[T][2];

        for(int i=0; i<T; i++){

            int a = nums[i]/2;

            while(a>=0){
                int b = nums[i] - a;
                if(!minority[a] && !minority[b]){
                    result[i][0] = Math.min(a, b);
                    result[i][1] = Math.max(a, b);
                    bw.write(result[i][0]+" "+result[i][1]+"\n");
                    break;
                }
                a--;
            }

        }

        bw.flush();

    }

    public static boolean[] searchMinority(int n){

        boolean[] result = new boolean[n+1];
        result[0] = true;
        result[1] = true;

        for(int i=2; i<Math.sqrt(n); i++){

            if(result[i]){
                continue;
            }

            for(int j=i*i; j<=n; j+=i){
                result[j] = true;
            }

        }

        return result;
    }

}
