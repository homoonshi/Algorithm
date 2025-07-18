import java.io.*;
import java.util.*;

class Solution {
    
    static int n;
    static int[] p;
    static int res;
    static int[] m;
    static int mlen;
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        n = picks[0] + picks[1] + picks[2];
        p = new int[3];
        p[0] = picks[0];
        p[1] = picks[1];
        p[2] = picks[2];
        mlen = minerals.length;
        
        m = new int[mlen];
        
        for(int i=0; i<mlen; i++){
            if(minerals[i].equals("diamond")){
                m[i] = 1;
            }else if(minerals[i].equals("iron")){
                m[i] = 2;
            }else{
                m[i] = 3;
            }
        }
        
        res = 50*25+1;
        
        recursion(0, 0, new int[3]);
        answer = res;
        
        return answer;
    }
    
    public static void recursion(int count, int tired, int[] pick){
        
        if(count==n){
            res = Math.min(res, tired);
            return;
        }
        
        for(int i=0; i<3; i++){
            if(pick[i]==p[i]){
                continue;
            }
            int t = tired;
            pick[i]++;
            for(int j=count*5; j<count*5+5; j++){
                if(j>=mlen){
                    break;
                }
                if(i==0){
                    t++;
                }else if(i==1){
                    if(m[j]==1){
                        t+=5;
                    }else{
                        t++;
                    }
                }else{
                    if(m[j]==1){
                        t+=25;
                    }else if(m[j]==2){
                        t+=5;
                    }else{
                        t++;
                    }
                }
            }
            recursion(count+1, t, pick);
            pick[i]--;
        }
        
    } 
    
}