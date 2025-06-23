import java.io.*;
import java.util.*;

public class Main {

    static int[] book;
    static boolean[] visit;
    static List<Integer>[] notebook;
    static int N, M;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        book = new int[N+1];
        notebook = new List[N+1];
        visit = new boolean[N+1];

        Arrays.fill(book, -1);

        for(int i=1; i<=N; i++) {
            notebook[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int index = Integer.parseInt(input[0]);
            int note = Integer.parseInt(input[1]);
            notebook[index].add(note);
        }

        int res = 0;

        for(int i=1; i<=N; i++) {
            Arrays.fill(visit, false);
            if(DFS(i)){
                res++;
            }
        }

        bw.write(res+"\n");


        bw.flush();

    }

    public static boolean DFS(int personIndex){

        int next = -1;

        for(int i=0; i<notebook[personIndex].size(); i++) {
            next = notebook[personIndex].get(i);
            if (visit[next]) continue;
            visit[next] = true;

            if(book[next] == -1 || DFS(book[next])){
                book[next] = personIndex;
                return true;
            }

        }

        return false;
    }

}