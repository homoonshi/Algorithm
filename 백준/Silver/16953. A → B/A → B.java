import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        long A = Integer.parseInt(input[0]);
        long B = Integer.parseInt(input[1]);

        Set<Long> set = new HashSet<>();
        Deque<long[]> deque = new ArrayDeque<>();

        deque.addLast(new long[]{A, 1});

        while(!deque.isEmpty()){

            long[] temp = deque.pollFirst();

            long a = temp[0]*2;
            long b = temp[0]*10 + 1;

            long count = temp[1];

            if(a==B || b==B){
                bw.write(count+1+"");
                bw.flush();
                return;
            }

            if(!set.contains(a) && a<B){
                deque.addLast(new long[]{a, count+1});
                set.add(a);
            }

            if(!set.contains(b) && b<B){
                deque.addLast(new long[]{b, count+1});
                set.add(b);
            }

        }

        bw.write("-1");
        bw.flush();

    }
}