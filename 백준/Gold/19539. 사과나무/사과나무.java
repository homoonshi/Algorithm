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

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int one = 0;
        int two = 0;

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(input[i]);

            two += num/2;
            one += num%2;
        }

        int t = two - one;

        if(t<0){
            bw.write("NO");
            bw.flush();
            return;
        }

        boolean res = (t%3==0) ? true : false;

        bw.write(res ? "YES" : "NO");
        bw.flush();
    }

}