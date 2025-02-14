
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int K = Integer.parseInt(br.readLine());
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i=0; i<K; i++){
            int n = Integer.parseInt(br.readLine());
            
            if(n==0){
                if(!deque.isEmpty()){
                    deque.pollLast();
                }
                continue;
            }
            
            deque.addLast(n);
        }
        
        int result = 0;

        for (Integer integer : deque) {
            result += integer;
        }
        
        bw.write(result+"");
        bw.flush();
        
    }
    
}
