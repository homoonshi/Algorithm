
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);

        int[] map = new int[W];

        input = br.readLine().split(" ");

        for(int i=0; i<W; i++){
            map[i] = Integer.parseInt(input[i]);
        }

        int left = 0;
        int leftMax = 0;
        int right = W-1;
        int rightMax = W-1;
        int result = 0;

        while(left<=right){

            if(map[left]<=map[right]){
                left++;
                if(left <= W-1 && map[left]>=map[leftMax]){
                    for(int i=leftMax+1; i<left; i++){
                        result += map[leftMax] - map[i];
                    }
                    leftMax = left;
                }
            }else{
                right--;
                if(right >= 0 && map[right]>=map[rightMax]){
                    for(int i=rightMax; i>right; i--){
                        result += map[rightMax] - map[i];
                    }
                    rightMax = right;
                }
            }

        }

        bw.write(result+"");
        bw.flush();

    }

}
