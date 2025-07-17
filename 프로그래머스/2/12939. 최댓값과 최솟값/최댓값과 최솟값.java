import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder ans = new StringBuilder("");
        String[] nums = s.split(" ");
        int[] n = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            n[i] = Integer.parseInt(nums[i]);
        }
        Arrays.sort(n);
        ans.append(n[0]+" "+n[nums.length-1]);
        return ans.toString();
    }
}