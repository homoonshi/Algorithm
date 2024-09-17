
import java.io.*;
import java.util.*;

public class Main {

  static int[] space;

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    space = new int[100001];

    String[] input = br.readLine().split(" ");

    int N = Integer.parseInt(input[0]);
    int K = Integer.parseInt(input[1]);

    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(N);

    int result = 0;

    if(N==K){
      bw.write("0");
      bw.flush();
      return;
    }

    while(!deque.isEmpty()){

      int current = deque.pollFirst();

      int front = current+1;
      int back = current-1;
      int tellport = current*2;

      if(front==K||back==K||tellport==K){
        result = space[current]+1;
        break;
      }

      if(isIn(front)&&space[front]==0){
        space[front] = space[current]+1;
        deque.add(front);
      }

      if(isIn(back)&&space[back]==0){
        space[back] = space[current]+1;
        deque.add(back);
      }

      if(isIn(tellport)&&space[tellport]==0){
        space[tellport] = space[current]+1;
        deque.add(tellport);
      }

    }

    bw.write(result+"");
    bw.flush();

  }

  public static boolean isIn(int n){
    if(n>=0&&n<=100000){
      return true;
    }
    return false;
  }

}