
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[][] score = new int[n+1][3];

    score[1][1] = Integer.parseInt(br.readLine());

    for(int i=2; i<=n; i++){

      int num = Integer.parseInt(br.readLine());

      score[i][0] = Math.max(score[i-1][1], score[i-1][2]);
      score[i][1] = score[i-1][0] + num;
      score[i][2] = score[i-1][1] + num;

    }

    int result = Math.max(score[n][1],score[n][2]);

    bw.write(result+"");
    bw.flush();

  }
}