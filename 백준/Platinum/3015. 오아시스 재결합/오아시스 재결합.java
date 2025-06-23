
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Long> deque = new ArrayDeque<>();

        long res = 0;

        for(int i=0; i<N; i++) {
            long h = Long.parseLong(br.readLine());
            long equal = 0;
            int equalCount = 0;
            while(!deque.isEmpty() && deque.peekLast() < h){
                long num = deque.pollLast();
                if(equal != num){
                    res += equalCount* 2L;
                    for(int j=1; j<equalCount; j++){
                        res += j;
                    }
                    equalCount = 1;
                    equal = num;
                }else{
                    equalCount++;
                }
            }
            if(!deque.isEmpty()) {
                res += equalCount * 2L;
            }else{
                res += equalCount;
            }
            for(int j=1; j<equalCount; j++){
                res += j;
            }
            deque.addLast(h);
        }

        long equal = 0;
        int equalCount = 0;
        
        while(!deque.isEmpty()) {
            long num = deque.pollLast();
            if(equal != num){
                res += equalCount;
                for(int j=1; j<equalCount; j++){
                    res += j;
                }
                equalCount = 1;
                equal = num;
            }else{
                equalCount++;
            }
        }
        for(int j=1; j<equalCount; j++){
            res += j;
        }
        
        bw.write(res+"");
        bw.flush();

    }
}