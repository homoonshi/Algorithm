import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Integer[] elec = new Integer[N];
        input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            elec[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(elec, Collections.reverseOrder());
        int currentIndex = 0;
        int currentTime = 0;

        PriorityQueue<Integer> charge = new PriorityQueue<>();

        for(int i=0; i<M; i++) {
            if(currentIndex >= N) break;
            charge.add(currentTime + elec[currentIndex++]);
        }

        while(!charge.isEmpty()){
            currentTime = charge.poll();
            while(!charge.isEmpty() && currentTime == charge.peek()){
                charge.poll();
            }
            int size = charge.size();
            for(int i=size; i<M; i++){
                if(currentIndex >= N) break;
                charge.add(currentTime + elec[currentIndex++]);
            }
        }

        bw.write(currentTime+"");
        bw.flush();
    }
}