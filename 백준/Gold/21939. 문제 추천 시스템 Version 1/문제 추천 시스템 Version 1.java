
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        TreeSet<Integer>[] algo = new TreeSet[101];
        Map<Integer, Integer> problems = new HashMap<>();

        for(int i=1; i<=100; i++){
            algo[i] = new TreeSet<>();
        }

        String[] input;

        TreeSet<Integer> level = new TreeSet<>();

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            int P = Integer.parseInt(input[0]);
            int L = Integer.parseInt(input[1]);

            algo[L].add(P);
            problems.put(P, L);
            level.add(L);
        }

        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){

            input = br.readLine().split(" ");

            String command = input[0];

            if(command.equals("add")){
                int P = Integer.parseInt(input[1]);
                int L = Integer.parseInt(input[2]);

                if(problems.containsKey(P)){
                    int LL = problems.get(P);

                    algo[LL].remove(P);
                    algo[L].add(P);

                    problems.put(P, L);

                    if(algo[LL].size()==0){
                        level.remove(LL);
                    }
                    continue;
                }

                algo[L].add(P);
                problems.put(P, L);
                level.add(L);
                continue;
            }

            if(command.equals("recommend")){
                int x = Integer.parseInt(input[1]);

                if(x==1){
                    int l = level.last();
                    bw.write(algo[l].last()+"\n");
                }else{
                    int l = level.first();
                    bw.write(algo[l].first()+"\n");
                }
                continue;
            }

            if(command.equals("solved")){
                int P = Integer.parseInt(input[1]);

                int LL = problems.get(P);

                algo[LL].remove(P);

                if(algo[LL].size()==0){
                    level.remove(LL);
                }

                problems.remove(P);
            }

        }

        bw.flush();

    }

}
