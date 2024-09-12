
import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static int[] num;

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    num = new int[n];

    String[] input = br.readLine().split(" ");

    for(int i=0; i<n; i++){
      num[i] = Integer.parseInt(input[i]);
    }

    int max = Integer.MIN_VALUE;
    int temp = 0;

    for(int i=0; i<n; i++){
      temp += num[i];
      max = Math.max(max, temp);
      if(temp<0){
        temp=0;
      }
    }

    bw.write(max+"");
    bw.flush();

  }
}