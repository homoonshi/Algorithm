import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);

        long[][] map = new long[N][2];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");

            map[i][0] = Integer.parseInt(input[0]);
            map[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(map, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Math.toIntExact(o1[0] - o2[0]);
            }
        });

        long posi = 0;
        int count = 0;

        for(int i=0; i<N; i++){
            if(map[i][0]<=posi){
                if(map[i][1]>posi){
                    if((map[i][1]-posi)%L==0){
                        count += (int) ((map[i][1]-posi)/L);
                        posi = posi + ((map[i][1]-posi)/L)*L;
                    }else{
                        count += (int) ((map[i][1]-posi)/L) + 1;
                        posi = posi + ((map[i][1]-posi)/L+1)*L;
                    }
                }
            }else{
                if((map[i][1]-map[i][0])%L==0){
                    count += (int) ((map[i][1]-map[i][0])/L);
                    posi = map[i][0] + ((map[i][1]-map[i][0])/L)*L;
                }else{
                    count += (int) ((map[i][1]-map[i][0])/L) + 1;
                    posi = map[i][0] + ((map[i][1]-map[i][0])/L+1)*L;
                }
            }
        }

        bw.write(count+"");
        bw.flush();

    }

}