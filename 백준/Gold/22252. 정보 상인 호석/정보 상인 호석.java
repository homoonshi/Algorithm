import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<String, PriorityQueue<Integer>> info = new HashMap<>();
        long res = 0;

        for(int i=0; i<N; i++){
            String[] command = br.readLine().split(" ");
            String gorilla = command[1];
            int cnt = Integer.parseInt(command[2]);
            PriorityQueue<Integer> pq;
            switch (command[0]){
                case "1":
                    pq = info.containsKey(gorilla) ?
                            info.get(gorilla) : new PriorityQueue<>(Comparator.reverseOrder());
                    for(int j=3; j<3+cnt; j++){
                        int value = Integer.parseInt(command[j]);
                        pq.add(value);
                    }
                    info.put(gorilla, pq);
                    break;
                case "2":
                    pq = info.getOrDefault(gorilla, null);
                    if(pq == null) break;
                    for(int j=0; j<cnt; j++){
                        if(pq.isEmpty()) break;
                        res += pq.poll();
                    }
                    info.put(gorilla, pq);
                    break;
            }
        }

        bw.write(res+"");
        bw.flush();

    }
}