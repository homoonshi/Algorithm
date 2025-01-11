
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case=0; test_case<T; test_case++){

            int N = Integer.parseInt(br.readLine());
            int[] num = new int[N+1];

            String[] input = br.readLine().split(" ");

            for(int i=1; i<=N; i++){
                num[i] = Integer.parseInt(input[i-1]);
            }

            boolean visited[] = new boolean[N+1];

            int result = 0;

            for(int i=1; i<=N; i++){

                if(visited[i]){
                    continue;
                }

                int next = i;

                while(!visited[next]){

                    visited[next] = true;
                    next = num[next];

                }

                result++;

            }

            bw.write(result+"\n");
            bw.flush();

        }

    }

}
