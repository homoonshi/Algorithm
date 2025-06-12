
import java.io.*;
import java.util.*;

public class Main {

    static class Solution {

        int index;
        Set<Integer> parent;
        List<Integer> child;

        Solution(int index){
            this.index = index;
            this.parent = new HashSet<>();
            this.child = new ArrayList<>();
        }

    }

    static Solution[] solutions;
    static PriorityQueue<Integer> pq;
    static int N;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        solutions = new Solution[N+1];
        pq = new PriorityQueue<>();

        for(int i=1; i<=N; i++){
            solutions[i] = new Solution(i);
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");

            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            solutions[A].child.add(B);
            solutions[B].parent.add(A);
        }

        for(int i=1; i<=N; i++){
            if(solutions[i].parent.size()==0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            int index = pq.poll();
            bw.write(index+" ");
            Solution s = solutions[index];
            for(int i=0; i<s.child.size(); i++){
                int c = s.child.get(i);
                solutions[c].parent.remove(index);
                if(solutions[c].parent.size()==0){
                    pq.add(c);
                }
            }
        }

        bw.flush();

    }
}