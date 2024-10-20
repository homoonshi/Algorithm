
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input;

    int N = Integer.parseInt(br.readLine());
    int[] crain = new int[N];

    input = br.readLine().split(" ");

    for(int i=0; i<N; i++){
      crain[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(crain);

    int M = Integer.parseInt(br.readLine());
    int[] box = new int[M];

    input = br.readLine().split(" ");

    for(int i=0; i<M; i++){
      box[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(box);

    int time = 0;
    int completeNum = 0;

    int[] completed = new int[M];

    while ( completeNum != M ){

      int beforeCompleteNum = completeNum;

      for(int i=N-1; i>=0; i--){

        int start = 0;
        int end = M-1;

        while( start <= end ){
          int mid = ( start + end ) / 2;
          if(box[mid] <= crain[i]){
            start = mid + 1;
          }else {
            end = mid - 1;
          }
        }

        for(int j = start-1; j>=0; j--){
          if(completed[j] == 0){
            completed[j] = 1;
            completeNum++;
            break;
          }
        }

      }

      if( beforeCompleteNum == completeNum ){
        bw.write("-1");
        bw.flush();
        return;
      }

      time++;

    }

    bw.write(time+"");
    bw.flush();

  }
}