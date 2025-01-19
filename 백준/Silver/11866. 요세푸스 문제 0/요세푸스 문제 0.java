
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            deque.add(i);
        }

        int count = 0;
        int remove = 0;
        bw.write("<");

        while(!deque.isEmpty()){

            count++;
            int num = deque.pollFirst();

            if(count==K){
                count = 0;
                remove++;
                if(remove==N){
                    bw.write(num+">");
                    break;
                }
                bw.write(num+", ");
                continue;
            }

            deque.addLast(num);

        }

        bw.flush();

    }

}
