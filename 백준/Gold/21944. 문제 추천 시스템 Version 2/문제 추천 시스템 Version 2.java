
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, TreeSet<Integer>>[] problemG = new TreeMap[101];
        TreeSet<Integer>[] problem = new TreeSet[101];

        HashMap<Integer, Integer> level = new HashMap<>();
        HashMap<Integer, Integer> group = new HashMap<>();

        String[] input;

        for(int i=1; i<=100; i++){
            problemG[i] = new TreeMap<>();
            problem[i] = new TreeSet<>();
        }

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");

            int P = Integer.parseInt(input[0]);
            int L = Integer.parseInt(input[1]);
            int G = Integer.parseInt(input[2]);

            if(problemG[G].get(L)==null) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(P);
                problemG[G].put(L, set);
            }else{
                TreeSet<Integer> set = problemG[G].get(L);
                set.add(P);
                problemG[G].put(L, set);
            }
            problem[L].add(P);
            level.put(P, L);
            group.put(P, G);
        }

        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){

            input = br.readLine().split(" ");
            String command = input[0];

            if(command.equals("add")){

                int P = Integer.parseInt(input[1]);
                int L = Integer.parseInt(input[2]);
                int G = Integer.parseInt(input[3]);

                TreeSet<Integer> set;

                if(level.get(P)!=null) {
                    int LL = level.get(P);
                    int GG = group.get(P);

                    problem[LL].remove(P);
                    set = problemG[GG].get(LL);
                    set.remove(P);
                    problemG[GG].put(LL, set);
                }

                if(problemG[G].get(L)!=null){
                    set = problemG[G].get(L);
                }else{
                    set = new TreeSet<>();
                }

                set.add(P);
                problemG[G].put(L, set);
                problem[L].add(P);

                level.put(P, L);
                group.put(P, G);

                continue;
            }

            if(command.equals("solved")){
                int P = Integer.parseInt(input[1]);

                int L = level.get(P);
                int G = group.get(P);

                problem[L].remove(P);
                TreeSet<Integer> set = problemG[G].get(L);
                set.remove(P);

                if(set.size()!=0) {
                    problemG[G].put(L, set);
                }else{
                    problemG[G].remove(L);
                }

                level.remove(P);
                group.remove(P);

                continue;
            }

            if(command.equals("recommend")){
                int G = Integer.parseInt(input[1]);
                int X = Integer.parseInt(input[2]);

                int K = 0;
                int P = 0;

                if(X==1){
                    K = problemG[G].lastKey();
                    P = problemG[G].get(K).last();
                }else{
                    K = problemG[G].firstKey();
                    P = problemG[G].get(K).first();
                }

                bw.write(P+"\n");
                continue;
            }

            if(command.equals("recommend2")){
                int X = Integer.parseInt(input[1]);
                int P = 0;
                if(X==1){
                    for(int j=100; j>=1; j--){
                        if(problem[j].size()>0) {
                            P = problem[j].last();
                            break;
                        }
                    }
                }else{
                    for(int j=1; j<=100; j++){
                        if(problem[j].size()>0){
                            P = problem[j].first();
                            break;
                        }
                    }
                }
                bw.write(P+"\n");
                continue;
            }

            if(command.equals("recommend3")){
                int X = Integer.parseInt(input[1]);
                int L = Integer.parseInt(input[2]);
                int P = 0;
                if(X==1){
                    for(int j=L; j<=100; j++){
                        if(problem[j].size()>0){
                            P = problem[j].first();
                            break;
                        }
                    }
                }else{
                    for(int j=L-1; j>=1; j--){
                        if(problem[j].size()>0){
                            P = problem[j].last();
                            break;
                        }
                    }
                }

                if(P==0){
                    bw.write("-1\n");
                }else{
                    bw.write(P+"\n");
                }
            }

        }

        bw.flush();

    }

}
