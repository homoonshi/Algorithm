
import java.io.*;
import java.util.*;

public class Main {

    static class University implements Comparable<University>{

        int d, p;

        University(int p, int d){
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(University o) {
            return o.p-this.p;
        }

    }

    static int n;
    static PriorityQueue<University> pq = new PriorityQueue<>();
    static int[] day;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int maxDay = 0;

        for(int i=0; i<n; i++){

            String[] input = br.readLine().split(" ");

            int p = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);

            maxDay = Math.max(maxDay, d);

            pq.add(new University(p, d));

        }

        day = new int[maxDay+1];
        int result = 0;

        int length = pq.size();


        for(int i=0; i<length; i++){

            University u = pq.poll();
            int d = u.d;

            while (d>0){

                if(day[d]==0){
                    day[d]=1;
                    result+=u.p;
                    break;
                }

                d--;

            }


        }

        bw.write(result+"\n");
        bw.flush();

    }


}
