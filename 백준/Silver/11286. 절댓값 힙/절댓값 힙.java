
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> poPq = new PriorityQueue<>();
    PriorityQueue<Integer> nePq = new PriorityQueue<>();

    int ne, po;

    for(int i=0; i<N; i++){

      int num = Integer.parseInt(br.readLine());

      if(num!=0){
        if(num<0){
          nePq.add(Math.abs(num));
          continue;
        }
        poPq.add(num);
        continue;
      }

      if(poPq.isEmpty()&&nePq.isEmpty()){
        bw.write("0\n");
        continue;
      }


      if(!nePq.isEmpty()) {
        ne = nePq.poll();
      }else{
        po = poPq.poll();
        bw.write(po+"\n");
        continue;
      }

      if(!poPq.isEmpty()) {
        po = poPq.poll();
      }else{
        bw.write("-"+ne+"\n");
        continue;
      }

      if(ne<=po){
        bw.write("-"+ne+"\n");
        poPq.add(po);
        continue;
      }

      bw.write(po+"\n");
      nePq.add(ne);

    }

    bw.flush();

  }
}