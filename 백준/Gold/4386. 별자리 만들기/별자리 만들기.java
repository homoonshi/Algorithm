
import java.util.*;
import java.io.*;

public class Main {

  static class StarDistance implements Comparable<StarDistance> {

    double distance;

    int i;
    int j;

    StarDistance(int i, int j, double distance){
      this.i = i;
      this.j = j;
      this.distance = distance;
    }

    @Override
    public int compareTo(StarDistance o) {
      return (int) (this.distance-o.distance);
    }
  }

  static int n;
  static double[][] star;
  static PriorityQueue<StarDistance> pq;
  static int[] completed;

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    star = new double[n][2];

    for(int i=0; i<n; i++){
      String[] input = br.readLine().split(" ");

      star[i][0] = Double.parseDouble(input[0]);
      star[i][1] = Double.parseDouble(input[1]);

    }

    completed = new int[n];

    for(int i=0; i<n; i++){
      completed[i] = i;
    }

    getDistance();
    double res = getMinCost();

    bw.write(res+"");
    bw.flush();

  }

  public static boolean setRepresent(int a, int b){

    int aIndex = getRepresent(a);
    int bIndex = getRepresent(b);

    if(aIndex==bIndex){
      return false;
    }

    if(aIndex<bIndex){
      completed[bIndex] = aIndex;
    }else{
      completed[aIndex] = bIndex;
    }

    return true;
  }

  public static int getRepresent(int index){

    int represent = 101;
    int r = completed[index];

    while ( represent != r ){

      represent = r;
      r = completed[represent];

    }

    return represent;
  }

  public static double getMinCost(){

    double result = 0;

    while(!pq.isEmpty()){

      StarDistance star = pq.poll();

      if(setRepresent(star.i, star.j)){
        result += star.distance;
      }

    }

    return result;
  }

  public static void getDistance(){

    pq = new PriorityQueue<>();

    for(int i=0; i<n; i++){
      for(int j=i; j<n; j++){

        double d = Math.pow(star[i][0]-star[j][0],2) + Math.pow(star[i][1]-star[j][1],2);
        double cost = Math.sqrt(d);

        pq.offer(new StarDistance(i,j,cost));

      }
    }

  }

}