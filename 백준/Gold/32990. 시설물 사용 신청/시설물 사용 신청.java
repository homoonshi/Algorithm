
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static List<List<Integer>> ask;
    static long total;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        ask = new ArrayList<>();
        total = ((long)N * N) / 4;

        bw.write(total+"\n");

        if(total>1000000){
            bw.flush();
            return;
        }

        arrangeAsk();

        for (List<Integer> integers : ask) {
            int size = integers.size();
            bw.write(integers.get(size-1)+" ");
            for(int i=0; i<size-1; i++){
                bw.write(integers.get(i)+" ");
            }
            bw.write("\n");
        }

        bw.flush();

    }

    public static void arrangeAsk(){

        for(int i=1; i<N; i++){
            for(int j=1; j<=i; j++){
                int count = 0;
                int startTime = j;
                int endTime = j+i;
                List<Integer> temp = new ArrayList<>();
                while(endTime<=N){
                    count++;
                    temp.add(startTime);
                    temp.add(endTime);
                    endTime += i;
                    startTime += i;
                }
                if(count!=0){
                    temp.add(count);
                    ask.add(temp);
                }
            }
        }

    }

}
