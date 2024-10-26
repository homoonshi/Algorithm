import java.io.*;
import java.util.*;

class Solution {
    
    static int[][] tree;
    static int[] leafSheep;
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        tree = new int[info.length][2];
        leafSheep = new int[info.length];

        for(int i=0; i<edges.length; i++){
            if(tree[edges[i][0]][0]==0){
                tree[edges[i][0]][0] = edges[i][1];
            }else{
                tree[edges[i][0]][1] = edges[i][1];
            }
        }
        
        Set<Integer> set = new HashSet<>();
        
        if(tree[0][0]!=0) {
            set.add(tree[0][0]);
        }

        if(tree[0][1]!=0) {
            set.add(tree[0][1]);
        }

        answer = dfs(info, set, 1, 0);
        
        return answer;
    }
    
    public int dfs(int[] info, Set<Integer> nodes, int sheep, int wolf){

        if(wolf==sheep){
            return sheep;
        }

        int result = sheep;

        for(Integer node : nodes){

            if(leafSheep[node]==1){
                continue;
            }

            int left = tree[node][0];
            int right = tree[node][1];

            Set<Integer> set = new HashSet<>();
            set.addAll(nodes);
            set.remove(node);

            if(info[node]==1){
                if(left==0 && (leafSheep[right]==1)){
                    leafSheep[node]=1;
                    continue;
                }else if(right==0 && (leafSheep[left]==1)){
                    leafSheep[node]=1;
                    continue;
                }else if(leafSheep[left]==1 && leafSheep[right]==1){
                    leafSheep[node]=1;
                    continue;
                }
            }

            if(left!=0 && leafSheep[left]==0){
                set.add(left);
            }

            if(right!=0 && leafSheep[right]==0){
                set.add(right);
            }

            if(info[node]==0){
                result = Math.max(result, dfs(info, set, sheep+1, wolf));
            }else{
                result = Math.max(result, dfs(info, set, sheep, wolf+1));
            }

        }

        return result;

    }
    
}