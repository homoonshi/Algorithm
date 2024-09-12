
import java.io.*;
import java.util.*;

public class Main {

  static List<Integer>[] map;
  static int[] visited;
  static int N, M;

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");

    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);

    visited = new int[N+1];
    map = new List[N+1];

    for(int i=1; i<=N; i++){
      map[i] = new ArrayList<>();
    }

    for(int i=0; i<M; i++){

      input = br.readLine().split(" ");

      int u = Integer.parseInt(input[0]);
      int v = Integer.parseInt(input[1]);

      map[u].add(v);
      map[v].add(u);

    }

    Deque<Integer> deque = new ArrayDeque<>();
    int result = 0;

    for(int i=1; i<=N; i++){

      if(visited[i]==1){
        continue;
      }

      result++;
      deque.add(i);

      while(!deque.isEmpty()){

        int n = deque.poll();

        for(Integer num : map[n]){
          if(visited[num]==0) {
            deque.add(num);
            visited[num] = 1;
          }
        }

      }

    }

    bw.write(result+"");
    bw.flush();

  }

}