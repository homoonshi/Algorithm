import java.io.*;
import java.util.*;

public class Main {

    static int[] task;
    static boolean[] visit;
    static List<Integer>[] person;
    static int N, M;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] input = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        task = new int[N+1];
        person = new List[M];
        visit = new boolean[N+1];

        Arrays.fill(task, -1);

        for(int i=0; i<M; i++){
            person[i] = new ArrayList<>();
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int index = 1;
            while(n-->0){
                person[i].add(Integer.parseInt(input[index]));
                index++;
            }
        }

        int res = 0;

        for(int i=0; i<M; i++) {
            Arrays.fill(visit, false);
            int get = DFS(i, -1);
            if(get==-1){
                continue;
            }
            res++;
            Arrays.fill(visit, false);
            if(DFS(i, get)!=-1){
                res++;
            }
        }

        bw.write(res+"\n");


        bw.flush();

    }

    public static int DFS(int personIndex, int num){

        int next = -1;

        for(int i=0; i<person[personIndex].size(); i++) {
            next = person[personIndex].get(i);
            if(next==num) continue;
            if (visit[next]) continue;
            visit[next] = true;

            if(task[next] == -1 || DFS(task[next], next) != -1){
                task[next] = personIndex;
                return next;
            }

        }

        return -1;
    }

}