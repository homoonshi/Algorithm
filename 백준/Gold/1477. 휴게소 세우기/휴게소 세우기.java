
import java.io.*;
import java.util.*;

public class Main {

  static int N, M, L;
  static int[] rest;
  static int[] interval;

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");

    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);
    L = Integer.parseInt(input[2]);

    rest = new int[N+2];
    input = br.readLine().split(" ");

    rest[0] = 0;
    for(int i=1; i<=N; i++){
      rest[i] = Integer.parseInt(input[i-1]);
    }
    rest[N+1] = L;

    Arrays.sort(rest);

    getInterval();

    bw.write(searchMinInterval()+"");
    bw.flush();

  }

  public static int searchMinInterval(){

    int low = 1;
    int high = L;

    int mid;

    while ( low < high ){

      mid = ( high + low ) / 2;

      int res = isInstallRest(mid);

      if(res==1){
        low = mid + 1;
      }else if(res==-1){
        high = mid;
      }

    }

    return low;
  }

  public static int isInstallRest(int width){

    int count = 0;

    for(int i=0; i<=N; i++){

      if(count>M){
        break;
      }

      if( interval[i] > width ){
        int d = interval[i] - width * (interval[i]/width);

        if(d==0){
          count += interval[i]/width - 1;
          continue;
        }

        if(d<=width){
          count += interval[i]/width;
          continue;
        }

        count += interval[i]/width + 1;
      }

    }

    if(count>M){
      return 1;
    }

    return -1;
  }


  public static void getInterval(){

    interval = new int[N+1];

    for(int i=1; i<=N+1; i++){

      interval[i-1] = rest[i] - rest[i-1];

    }

  }

}