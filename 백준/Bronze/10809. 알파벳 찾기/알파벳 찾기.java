
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int[] nums = new int[26];

        Arrays.fill(nums, -1);

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(nums[c-97]==-1) {
                nums[c - 97] = i;
            }
        }

        for(int i=0; i<26; i++){
            bw.write(nums[i]+" ");
        }

        bw.flush();

    }
}

