import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[][] friend;
    static int[][] startIndex;
    static List<Integer>[] map;
    static int[] completed;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        friend = new boolean[N+1][N+1];
        startIndex = new int[N+1][N+1];
        map = new List[N+1];
        completed = new int[N+1];
        int completedPerson = 0;

        List<Integer> dayRequestCount = new ArrayList<>();
        int day = 0;

        for(int i=1; i<=N; i++){
            map[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            completedPerson = friendProcess(a, b, completedPerson);
        }

        while(completedPerson!=N){

            Deque<int[]> batch = new ArrayDeque<>();

            for(int i=1; i<=N; i++){
                if(completed[i]==N) continue;

                for(int j=0; j<map[i].size(); j++){
                    int f = map[i].get(j);

                    for(int k=startIndex[i][f]; k<map[f].size(); k++){
                        int ff = map[f].get(k);
                        if(i==ff) continue;
                        if(friend[i][ff]) continue;
                        batch.add(new int[]{i, ff});
                    }

                    startIndex[i][f] = map[f].size();
                }

            }

            int c = 0;

            while(!batch.isEmpty()){
                int[] temp = batch.pollFirst();
                int a = temp[0];
                int b = temp[1];
                if(friend[a][b]) continue;
                c++;
                completedPerson = friendProcess(a, b, completedPerson);
            }

            dayRequestCount.add(c);
            day++;

        }

        bw.write(day+"\n");
        for (Integer i : dayRequestCount) {
            bw.write(i+"\n");
        }

        bw.flush();

    }

    private static int friendProcess(int a, int b, int completedPerson) {
        friend[a][b] = true;
        friend[b][a] = true;
        map[a].add(b);
        map[b].add(a);
        completed[a]++;
        completed[b]++;
        if(completed[a]==N-1){
            completedPerson++;
            completed[a]++;
        }
        if(completed[b]==N-1){
            completedPerson++;
            completed[b]++;
        }
        return completedPerson;
    }
}