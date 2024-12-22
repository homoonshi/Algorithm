
import java.util.*;
import java.io.*;

public class Main {

    static class Log implements Comparable<Log>{

        int T;
        int S;
        int N;

        Log (int T, int S,int N){
            this.T = T;
            this.S = S;
            this.N = N;
        }


        @Override
        public int compareTo(Log o) {
            return this.T-o.T;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int X = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int[] position = new int[C+1];
        int[] student = new int[X+1];
        Log[] logs = new Log[K];

        for(int i=0; i<K; i++){

            input = br.readLine().split(" ");

            int T = Integer.parseInt(input[0]); // 신청 시간
            int S = Integer.parseInt(input[1]); // 좌석 번호
            int N = Integer.parseInt(input[2]); // 학생 학번

            logs[i] = new Log(T, S, N);

        }

        Arrays.sort(logs);

        for(int i=0; i<K; i++){

            int S = logs[i].S;
            int N = logs[i].N;

            if(position[S]==0){
                if(student[N]!=0){
                    position[student[N]]=0;
                }
                position[S]=N;
                student[N]=S;
            }

        }

        for(int i=1; i<=X; i++){
            if(student[i]!=0){
                bw.write(i+" "+student[i]+"\n");
            }
    }

        bw.flush();

    }

}
