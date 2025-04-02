
import java.io.*;
import java.util.*;

public class Main {

    static class Time implements Comparable<Time>{
        long t;
        long d;

        public Time(int t, int d) {
            this.t = t;
            this.d = d;
        }

        @Override
        public int compareTo(Time o) {
            return (int)(this.t-o.t);
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case=0; test_case<T; test_case++) {
            int m = Integer.parseInt(br.readLine());

            Time[] times = new Time[m * 2];

            String[] input = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                times[i] = new Time(Integer.parseInt(input[i]), 0);
            }
            input = br.readLine().split(" ");
            for (int i = m; i < m*2; i++) {
                times[i] = new Time(Integer.parseInt(input[i-m]), 1);
            }

            Arrays.sort(times);

            Deque<Time> completed = new ArrayDeque<>();
            Deque<Time> onGoing = new ArrayDeque<>();

            m: for (int i = 0; i < m*2; i++) {

                Time current = times[i];

                for (Time time : onGoing) {
                    long t = time.t;
                    if (t + 1500 == current.t){
                        completed.add(time);
                        onGoing.remove(time);
                        continue m;
                    }
                    if(t+500 == current.t || t+1000 == current.t){
                        continue m;
                    }
                }

                onGoing.add(current);

            }

            int result = 0;

            for (Time time : completed) {
                if(time.d==0){
                    result++;
                }
            }

            bw.write(result+"\n");
        }

        bw.flush();

    }

}
