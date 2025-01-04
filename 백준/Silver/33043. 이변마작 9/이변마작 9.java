
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Deque<Integer>> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int result = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){

            if(map.containsKey(input[i])){
                Deque<Integer> deque = map.get(input[i]);
                if(deque.size()==4){
                    int start = deque.pollFirst();
                    result = Math.min(result, i - start + 2);
                }
                deque.addLast(i+1);
                map.put(input[i], deque);
            }else{
                Deque<Integer> deque = new ArrayDeque<>();
                deque.add(i+1);
                map.put(input[i], deque);
            }

        }

        if(result==Integer.MAX_VALUE){
            bw.write("-1");
        }else{
            bw.write(result+"");
        }

        bw.flush();

    }

}
