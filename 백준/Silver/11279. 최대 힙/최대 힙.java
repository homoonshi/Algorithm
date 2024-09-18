
import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    PriorityQueue<Integer> pq = new PriorityQueue<>((x1, x2) -> x2-x1);

    int N = Integer.parseInt(br.readLine());

    for(int i=0; i<N; i++){

      int num = Integer.parseInt(br.readLine());

      if(num==0){
        if(pq.isEmpty()){
          bw.write("0\n");
          continue;
        }
        bw.write(pq.poll()+"\n");
        continue;
      }

      pq.add(num);

    }

    bw.flush();

  }
}