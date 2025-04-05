
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int[] water = new int[3];

        for(int i=0; i<3; i++){
            water[i] = Integer.parseInt(input[i]);
        }

        Set<Integer> sets = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0,0,water[2]});

        boolean[][][] isVisitied = new boolean[water[0]+1][water[1]+1][water[2]+1];

        while(!deque.isEmpty()){

            int[] temp = deque.pollFirst();

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i==j){
                        continue;
                    }
                    int[] t = Arrays.copyOf(temp, 3);
                    if(t[i]>water[j]){
                        t[i] -= (water[j] - t[j]);
                        t[j] = water[j];
                    }else{
                        if(water[j] >= t[i]+t[j]){
                            t[i] = 0;
                            t[j] += temp[i];
                        }else{
                            t[i] -= (water[j] - t[j]);
                            t[j] = water[j];
                        }
                    }

                    if(isVisitied[t[0]][t[1]][t[2]]){
                        continue;
                    }

                    isVisitied[t[0]][t[1]][t[2]] = true;
                    deque.add(new int[]{t[0],t[1],t[2]});

                    if(t[0]==0 && !sets.contains(t[2])){
                        sets.add(t[2]);
                        result.add(t[2]);
                    }

                }
            }

        }

        Collections.sort(result);

        for (Integer res : result) {
            bw.write(res+" ");
        }

        bw.flush();

    }

}
