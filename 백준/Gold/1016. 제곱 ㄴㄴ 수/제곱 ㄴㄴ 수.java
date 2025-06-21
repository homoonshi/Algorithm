
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        long min = Long.parseLong(input[0]);
        long max = Long.parseLong(input[1]);

        long entire = max - (min - 1);

        long start = 2;
        long end = -1;

        for(long i = max; i >= 2; i--){
            if(i > 1 && Math.sqrt(i) % 1 == 0){
                end = (long) Math.sqrt(i);
                break;
            }
        }

        Set<Long> visit = new HashSet<>();

        for(long i = start; i <= end; i++){
            long num = (long) Math.pow(i, 2);
            long index = min / num - 1;

            if(index==0){
                index = 1;
            }

            long s = num * index;
            while(s <= max){
                if(min <= s && !visit.contains(s)) {
                    entire--;
                    visit.add(s);
                }
                s = num * ++index;
            }
        }

        bw.write(entire+"");
        bw.flush();

    }
}