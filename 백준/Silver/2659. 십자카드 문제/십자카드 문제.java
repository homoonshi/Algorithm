
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");

    int[] num = new int[4];

    for (int i = 0; i < 4; i++) {
      num[i] = Integer.parseInt(input[i]);
    }

    int[] timeNum = new int[4];

    int min = findMinNum(num);

    for(int i = 0; i < 4; i++){
      timeNum[i] = min / (int) Math.pow(10, 3 - i);
      min %= (int) Math.pow(10, 3 - i);
    }

    min = findMinNum(num);

    int result = 0;
    Set<Integer> set = new HashSet<>();

    for(int i=1111; i<=9999; i++){

      int temp = i;
      int[] tempNum = new int[4];

      for(int j=0; j<4; j++){
        tempNum[j] = temp / (int) Math.pow(10, 3-j);
        temp %= (int) Math.pow(10, 3-j);
      }

      if(tempNum[0]==0||tempNum[1]==0||tempNum[2]==0||tempNum[3]==0){
        continue;
      }

      int tempMin = findMinNum(tempNum);

      if(!set.contains(tempMin)){
        set.add(tempMin);
        result++;
      }

      if(i==min){
        break;
      }

    }

    bw.write(result + "");
    bw.flush();

  }

  public static int findMinNum(int[] n){

    int min = 10000;
    int temp;

    for(int i=0; i<4; i++){

      int next = i;
      temp = 0;

      for(int j=0; j<4; j++){
        temp += n[next] * (int) Math.pow(10, 3-j);
        if(next==3){
          next=0;
          continue;
        }
        next++;
      }

      min = Math.min(min, temp);

    }

    return min;
  }

}