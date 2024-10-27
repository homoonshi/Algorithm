
import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Integer>[] team = new List[3];
    static int[] student;
    static Deque<Integer>[] deque;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=1; i<=2; i++){
            team[i] = new ArrayList<>();
        }

        n = Integer.parseInt(br.readLine());

        student = new int[n+1];
        deque = new Deque[n+1];

        for(int i=1; i<=n; i++){

            deque[i] = new ArrayDeque<>();
            String[] input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);

            for(int j=1; j<=num; j++){
                deque[i].add(Integer.parseInt(input[j]));
            }

        }

        matchTeam();

        for(int i=1; i<=2; i++){

            bw.write(team[i].size()+"\n");
            Collections.sort(team[i]);

            for(Integer index : team[i]){
                bw.write(index+" ");
            }

            bw.write("\n");

        }

        bw.flush();

    }

    public static void matchTeam(){

        Deque<Integer> dfs = new ArrayDeque<>();

        for(int i=1; i<=n; i++) {

            if(student[i]==0){
                student[i]=1;
                dfs.add(i);
                team[1].add(i);
            }else{
                deque[i].clear();
                continue;
            }

            while (!dfs.isEmpty()) {

                int root = dfs.pollFirst();

                while (!deque[root].isEmpty()) {

                    int leaf = deque[root].pollFirst();

                    if (student[leaf] == 0) {
                        if (student[root] == 1) {
                            student[leaf] = 2;
                            team[2].add(leaf);
                        } else {
                            student[leaf] = 1;
                            team[1].add(leaf);
                        }
                        dfs.add(leaf);
                    }

                }

            }
        }


    }

}
