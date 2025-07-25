import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] tang = new int[N];
        for (int i = 0; i < N; i++) {
            tang[i] = Integer.parseInt(input[i]);
        }

        int[] count = new int[10]; 
        int left = 0, right = 0, type = 0, maxLen = 0;

        while (right < N) {
            if (count[tang[right]] == 0) type++;
            count[tang[right]]++;
            right++;

            while (type > 2) {
                count[tang[left]]--;
                if (count[tang[left]] == 0) type--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        bw.write(maxLen+"");
        bw.flush();
        
    }
}
