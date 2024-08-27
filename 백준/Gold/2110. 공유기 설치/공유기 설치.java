
import java.io.*;
import java.util.*;

public class Main {

  static int N, C;
  static int[] x;

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");

    N = Integer.parseInt(input[0]);
    C = Integer.parseInt(input[1]);

    x = new int[N];

    for(int i=0; i<N; i++){
      x[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(x);

    bw.write(distance()+"");
    bw.flush();

  }

  public static int distance(){

    int l = 1;
    int h = x[N-1];
    int mid = (l+h)/2;

    while (l <= h){

      mid = (l + h) / 2;

      if(!install(mid)){
        h = mid - 1;
        continue;
      }

      l = mid + 1;
    }

    return l-1;
  }

  public static boolean install(int d){

    int count = C-1;
    int min = 0;

    for(int i=1; i<N; i++){

      if(count==0){
        return true;
      }

      if(x[i]-x[min]>=d){
        count--;
        min = i;
        continue;
      }

      if(i==N-1&&x[min]==1){
        return false;
      }

    }

    if(count==0){
      return true;
    }

    return false;
  }

}