
import java.io.*;
import java.util.*;

public class Main {

    static class Friend implements Comparable<Friend> {
        int index;
        int cost;

        public Friend(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Friend o) {
            if(this.cost == o.cost){
                return o.index - this.index;
            }
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] input;

        for(int test_case = 0; test_case < T; test_case++){

            input = br.readLine().split(" ");

            int p = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);

            Friend[] friends = new Friend[n];
            int[] result = new int[n];

            input = br.readLine().split(" ");

            for(int i=0; i<n; i++){
                friends[i] = new Friend(i, Integer.parseInt(input[i]));
            }

            Arrays.sort(friends);

            for(int i=0; i<n; i++){
                int a = p/(n-i);

                if(a<=friends[i].cost){
                    if(p >= a) {
                        p -= a;
                        result[friends[i].index] = a;
                    }else{
                        result[friends[i].index] = p;
                        p = 0;
                    }
                }else{
                    if(p >= friends[i].cost) {
                        p -= friends[i].cost;
                        result[friends[i].index] = friends[i].cost;
                    }else{
                        result[friends[i].index] = p;
                        p = 0;
                    }
                }
            }

            if(p<=0) {
                for (int i = 0; i < n; i++) {
                    bw.write(result[i] + " ");
                }
            }else{
                bw.write("IMPOSSIBLE");
            }

            bw.write("\n");

        }

        bw.flush();

    }

}
