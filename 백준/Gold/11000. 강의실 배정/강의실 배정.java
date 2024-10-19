
import java.io.*;
import java.util.*;

public class Main {

    static class Lesson implements Comparable<Lesson>{

        int startTime, endTime;

        Lesson(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Lesson o) {
            return this.startTime - o.startTime;
        }

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Lesson[] lessons = new Lesson[N];

        int start, end;

        for(int i=0; i<N; i++){

            String[] input = br.readLine().split(" ");

            start = Integer.parseInt(input[0]);
            end = Integer.parseInt(input[1]);

            Lesson lesson = new Lesson(start, end);
            lessons[i] = lesson;

        }

        Arrays.sort(lessons);
        int result = 0;

        pq.add(lessons[0].endTime);

        for(int i=1; i<N; i++){

            int time = pq.poll();

            if(time > lessons[i].startTime){
                pq.add(time);
                pq.add(lessons[i].endTime);
            }else{
                pq.add(lessons[i].endTime);
            }

        }

        result = pq.size();

        bw.write(result+"");
        bw.flush();

    }

}
