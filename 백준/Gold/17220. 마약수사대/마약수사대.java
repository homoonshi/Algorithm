
import java.io.*;
import java.util.*;

public class Main {

  static int N, M;
  static Set<Integer>[] send;
  static Set<Integer> life;

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");

    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);

    send = new Set[N];

    Set<Integer> boss = new HashSet<>();
    life = new HashSet<>();

    for(int i=0; i<N; i++){
      boss.add(i);
      life.add(i);
      send[i] = new HashSet<>();
    }

    for(int i=0; i<M; i++){

      input = br.readLine().split(" ");

      int s = input[0].charAt(0)-65;
      int r = input[1].charAt(0)-65;

      boss.remove(r);
      send[s].add(r);

    }

    Integer[] arr = boss.toArray(new Integer[0]);

    input = br.readLine().split(" ");

    int d = Integer.parseInt(input[0]);

    for(int i=1; i<=d; i++){

      int n = input[i].charAt(0)-65;
      life.remove(n);
    }

    int result = 0;
    for(int i=0; i<arr.length; i++) {
      if(life.contains(arr[i])) {
        result += receive(arr[i]);
      }
    }
    bw.write(result+"");
    bw.flush();

  }

  public static int receive(int root){

    int count = 0;

    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(root);
    int[] visited = new int[N];

    while(!deque.isEmpty()){

      int num = deque.pollFirst();
      int size = send[num].size();
      visited[num]=1;

      Iterator<Integer> iterator = send[num].iterator();

      for(int i=0; i<size; i++){

        int n = iterator.next();
        if(visited[n]==1||!life.contains(n)){
          continue;
        }

        deque.addLast(n);
        life.remove(n);
        count++;

      }

    }

    return count;
  }

}
