
import java.io.*;
import java.util.*;

public class Main {

    static int[] book;
    static boolean[] visit;
    static List<Integer>[] person;
    static int N, M;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case<T; test_case++){

            String[] input = br.readLine().split(" ");

            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);

            book = new int[N+1];
            person = new List[M];
            visit = new boolean[N+1];

            Arrays.fill(book, -1);

            for(int i=0; i<M; i++){
                person[i] = new ArrayList<>();
                input = br.readLine().split(" ");
                for(int j=0; j<input.length; j++){
                    person[i].add(Integer.parseInt(input[j]));
                }
            }

            int res = 0;

            for(int i=0; i<M; i++) {
                Arrays.fill(visit, false);
                if(DFS(i)){
                    res++;
                }
            }

            bw.write(res+"\n");

        }

        bw.flush();

    }

    public static boolean DFS(int personIndex){

        int min = person[personIndex].get(0);
        int max = person[personIndex].get(1);

        for(int i=min; i<=max; i++) {

            if (visit[i]) continue;
            visit[i] = true;

            if(book[i] == -1 || DFS(book[i])){
                book[i] = personIndex;
                return true;
            }

        }

        return false;
    }

}