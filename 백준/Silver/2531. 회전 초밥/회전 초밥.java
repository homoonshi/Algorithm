import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 접시 수
        int d = Integer.parseInt(input[1]); // 초밥 가짓 수
        int k = Integer.parseInt(input[2]); // 연속해서 먹는 접시 수 k
        int c = Integer.parseInt(input[3]); // 쿠폰 번호 c

        int[] velt = new int[N];
        int[] food = new int[d+1];

        food[c] = 1;

        int res = 1;

        for(int i=0; i<N; i++){
            velt[i] = Integer.parseInt(br.readLine());
            if(i<k){
                if(velt[i]==c) {
                    continue;
                }
                food[velt[i]]++;
                if(food[velt[i]]==1) {
                    res++;
                }
            }
        }

        int end = 0;

        for(int i=k; i<N+k; i++){
            if(velt[i-k]!=c){
                food[velt[i-k]]--;
                if(food[velt[i-k]]==0){
                    res--;
                }
            }
            int index = i;
            if(i>=N){
                index -= N;
            }
            if(velt[index]!=c){
                food[velt[index]]++;
                if(food[velt[index]]==1){
                    res++;
                }
            }
            end = Math.max(end, res);
        }

        bw.write(end+"");
        bw.flush();

    }
}