
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int num = 1;

    Deque<Integer> deque = new ArrayDeque<>();

    StringBuilder sb = new StringBuilder();

    for(int i=0; i<n; i++){
      int c = Integer.parseInt(br.readLine());

      if(c<num){
        if(deque.isEmpty()|| (!deque.isEmpty()&&deque.peekLast()<c)) {
          sb = new StringBuilder("NO");
          break;
        }
      }

      for(int j=num; j<=c; j++){
        sb.append("+\n");
        deque.addLast(num++);
      }

      if(!deque.isEmpty()){
        for(int j=deque.peekLast(); j>=c; j--){
          sb.append("-\n");
          deque.pollLast();
        }
      }

    }

    bw.write(sb.toString());
    bw.flush();

  }
}