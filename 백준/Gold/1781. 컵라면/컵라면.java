
import java.io.*;
import java.util.*;

public class Main {

    static class Problem implements Comparable<Problem> {
        int deadline;
        long noodle;

        public Problem(int deadline, long noodle) {
            this.deadline = deadline;
            this.noodle = noodle;
        }

        @Override
        public int compareTo(Problem o) {
            return (int)(o.noodle - this.noodle);
        }
    }

    static int N;
    static PriorityQueue<Problem> remains;
    static List<Problem> pro;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        remains = new PriorityQueue<>();
        pro = new ArrayList<>();

        String[] input;

        int maxDay = 0;

        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");
            int deadLine = Integer.parseInt(input[0]);
            long noodle = Integer.parseInt(input[1]);
            pro.add(new Problem(deadLine, noodle));
            maxDay = Math.max(maxDay, deadLine);
        }

        pro.sort(((o1, o2) -> o2.deadline == o1.deadline ? (int) (o2.noodle - o1.noodle) : o2.deadline - o1.deadline));

        long[] day = new long[maxDay+1];
        int currentDay = maxDay;

        for(int i=0; i<N; i++){
            Problem problem = pro.get(i);
            while(problem.deadline < currentDay){
                if(remains.isEmpty()){
                    currentDay = problem.deadline;
                    break;
                }
                Problem r = remains.poll();
                day[currentDay--] = r.noodle;
            }
            if(currentDay!=problem.deadline){
                remains.add(problem);
                continue;
            }
            if(!remains.isEmpty()) {
                Problem r = remains.peek();
                if (r.noodle > problem.noodle) {
                    r = remains.poll();
                    day[currentDay--] = r.noodle;
                    remains.add(problem);
                    continue;
                }
            }
            day[currentDay--] = problem.noodle;
        }

        if(currentDay>0){
            while(!remains.isEmpty()){
                if(currentDay==0){
                    break;
                }
                Problem p = remains.poll();
                day[currentDay--] = p.noodle;
            }
        }

        long res = 0;

        for(int i=1; i<=maxDay; i++){
            res += day[i];
        }

        bw.write(res+"");
        bw.flush();

    }
}