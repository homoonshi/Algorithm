
import java.io.*;
import java.util.*;

public class Main {

  static class Computer {

    int num;
    Map<Integer, Integer> time;
    int inflectedTime = -1;

    public Computer (int num){
      this.num = num;
      this.time = new HashMap<>();
    }

    public void setTime(int time, int index){
      this.time.put(index,time);
    }

    public int getTime(int index){
      return this.time.get(index);
    }

    public void setInflectedTime(int inflectedTime){
      this.inflectedTime = inflectedTime;
    }

    public int getInflectedTime(){
      return this.inflectedTime;
    }

  }

  static Computer[] computers;
  static List<Computer>[] dependency;
  static int n, d, c;

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for(int testCase = 0; testCase < T; testCase++){

      String[] input = br.readLine().split(" ");

      n = Integer.parseInt(input[0]);
      d = Integer.parseInt(input[1]);
      c = Integer.parseInt(input[2]);

      computers = new Computer[n+1];
      dependency = new List[n+1];

      for(int i=1; i<=n; i++){

        computers[i] = new Computer(i);
        dependency[i] = new ArrayList<>();

      }

      for(int i=0; i<d; i++){

        input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int s = Integer.parseInt(input[2]);

        computers[a].setTime(s, b);
        dependency[b].add(computers[a]);

      }

      computers[c].setInflectedTime(0);

      int[] result = inflect();

      bw.write(result[0]+" "+result[1]+"\n");

    }

    bw.flush();
  }

  public static int[] inflect(){

    int[] result = new int[2]; // 감염된 컴퓨터 수, 감염되기까지 걸린 시간
    result[0] = 1;

    Deque<Computer> deque = new ArrayDeque<>();
    deque.add(computers[c]);

    while(!deque.isEmpty()){

      Computer temp = deque.pollFirst();

      for(Computer c : dependency[temp.num]){

        int time = c.getTime(temp.num) + temp.getInflectedTime();

        if(c.getInflectedTime()!=-1){
          if(c.getInflectedTime()>time){
            c.setInflectedTime(time);
            deque.add(computers[c.num]);
          }
        }else{
          c.setInflectedTime(time);
          result[0]++;
          deque.add(computers[c.num]);
        }

      }

    }

    for(int i=1; i<=n; i++){
      result[1] = Math.max(result[1], computers[i].getInflectedTime());
    }

    return result;
  }

}