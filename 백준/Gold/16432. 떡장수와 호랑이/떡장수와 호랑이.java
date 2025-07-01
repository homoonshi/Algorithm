import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] tteok;
    static Deque<Integer> res;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        tteok = new int[N+1][10];

        for(int i=1; i<=N; i++){
            Arrays.fill(tteok[i], -1);
        }

        res = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=1; j<input.length; j++){
                int t = Integer.parseInt(input[j]);
                for(int k=1; k<=9; k++){
                    if(t==k) continue;
                    if(tteok[i-1][k]!=-1){
                        tteok[i][t] = k;
                        break;
                    }
                }
            }
        }

        int index = -1;

        for(int j=1; j<=9; j++){
            if(tteok[N][j]!=-1){
                res.addFirst(j);
                index = j;
                break;
            }
        }

        if(index!=-1) {
            for (int i = N - 1; i >= 1; i--) {
                index = tteok[i + 1][index];
                res.addFirst(index);
            }
            while(!res.isEmpty()){
                bw.write(res.pollFirst()+"\n");
            }
        }else{
            bw.write(index+"");
        }

        bw.flush();

    }

}