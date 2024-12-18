import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long result = 0;
        
        Arrays.sort(works);
        int size = works.length;
        int max = works[size-1];
        int[] work = new int[max+1];
        
        for(int i=size-1; i>=0; i--){
            work[works[i]]++;
        }
        
        for(int i=max; i>=0; i--){
            
            if(n==0){
                result += Math.pow(i, 2) * work[i];
                size -= work[i];
                if(size==0){
                    break;
                }
                continue;
            }
            
            if(work[i] > n){
                work[i]-=n;
                if(i!=0){
                    work[i-1]+=n;
                }
                result += Math.pow(i, 2) * work[i];
                size -= n;
                n=0;
                continue;
            }
            int num = work[i];
            work[i]=0;
            if(i!=0){
                work[i-1] += num;
                n -= num;
            }
        }
        
        return result;
    }
}