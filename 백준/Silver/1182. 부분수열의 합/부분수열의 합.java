
import java.io.*;
import java.util.*;

public class Main {

  static int N, S;
  static int[] nums;
  static int result;
  static Set<Integer> visited;

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");

    N = Integer.parseInt(input[0]);
    S = Integer.parseInt(input[1]);

    nums = new int[N];
    input = br.readLine().split(" ");

    for(int i=0; i<N; i++){
      nums[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(nums);
    result = 0;
    visited = new HashSet<>();

    DFS(0,0,0);

    bw.write(result+"");
    bw.flush();

  }

  public static void DFS(int n, int index, int visit){

    if(n==S&&!visited.contains(visit)&&visit!=0){
      result++;
      visited.add(visit);
    }

    if(index==N){
      return;
    }
    
    DFS(n,index+1,visit);
    DFS(n+nums[index],index+1,visit|=(1<<index));

  }

}