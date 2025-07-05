import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long X = Long.parseLong(br.readLine());

        Set<Long> visit = new HashSet<>();
        Deque<long[]> deque = new ArrayDeque<>();
        
        if(X==1){
            bw.write("0");
            bw.flush();
            return;
        }

        deque.addFirst(new long[]{X, 0});
        visit.add(X);

        while(!deque.isEmpty()){

            long[] t = deque.pollFirst();

            long num = t[0];
            long count = t[1];

            if(num%3==0) {
                if (num / 3 == 1) {
                    bw.write(count + 1 + "");
                    bw.flush();
                    return;
                }
                if (!visit.contains(num / 3)) {
                    deque.addLast(new long[]{num/3, count+1});
                    visit.add(num/3);
                }
            }

            if(num%2==0){
                if (num / 2 == 1) {
                    bw.write(count + 1 + "");
                    bw.flush();
                    return;
                }
                if (!visit.contains(num / 2)) {
                    deque.addLast(new long[]{num/2, count+1});
                    visit.add(num/2);
                }
            }

            if(num-1 > 0){
                if(num-1 == 1){
                    bw.write(count + 1 + "");
                    bw.flush();
                    return;
                }
                if(!visit.contains(num-1)){
                    deque.addLast(new long[]{num-1, count+1});
                    visit.add(num-1);
                }
            }

        }

    }
}