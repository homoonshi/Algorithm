
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] building;
    static Set<Integer>[] buildBefore;
    static int[] buildTime;
    static int[] completeTime;
    static int[] startTime;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs;

        N = Integer.parseInt(br.readLine());
        building = new ArrayList[N+1];
        buildTime = new int[N+1];
        completeTime = new int[N+1];
        buildBefore = new Set[N+1];
        startTime = new int[N+1];
        Arrays.fill(startTime,1);

        for(int i=1; i<=N; i++){
            building[i] = new ArrayList<>();
            buildBefore[i] = new HashSet<>();
        }

        for(int i=1; i<=N; i++){

            inputs = br.readLine().split(" ");

            buildTime[i] = Integer.parseInt(inputs[0]);

            for(int j=1; j<inputs.length-1; j++){

                int complete = Integer.parseInt(inputs[j]);
                building[complete].add(i);
                buildBefore[i].add(complete);

            }

        }

        build();

        for(int i=1; i<=N; i++){
            bw.write(completeTime[i]+"\n");
        }

        bw.flush();

    }

    public static void build(){

        Deque<Integer> start = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            if(buildBefore[i].size()==0){
                start.add(i);
                startTime[i] = 0;
            }
        }

        while(!start.isEmpty()){

            int num = start.pollFirst();

            completeTime[num] = startTime[num] + buildTime[num];

            for(int i=0; i<building[num].size(); i++){
                int index = building[num].get(i);
                buildBefore[index].remove(num);
                startTime[index]=Math.max(startTime[index], completeTime[num]);
                if(buildBefore[index].size()==0){
                    start.addLast(index);
                }
            }

        }

    }

}
