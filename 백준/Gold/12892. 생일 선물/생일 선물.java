import java.io.*;
import java.util.*;

public class Main {

    static class Friend implements Comparable<Friend> {
        int p;
        int s;

        Friend(int p, int s){
            this.p = p;
            this.s = s;
        }

        @Override
        public int compareTo(Friend o) {
            return this.p - o.p;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int D = Integer.parseInt(input[1]);

        Friend[] friends = new Friend[N];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");

            int p = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);

            friends[i] = new Friend(p, s);
        }

        Arrays.sort(friends);

        int startIndex = 0;
        int endIndex = startIndex;

        long res = friends[0].s;
        long temp = res;

        for(int i=1; i<N; i++){
            endIndex = i;
            temp += friends[endIndex].s;

            while(friends[endIndex].p - friends[startIndex].p >= D){
                temp -= friends[startIndex++].s;
            }

            res = Math.max(res, temp);
        }

        bw.write(res + "");
        bw.flush();
    }

}