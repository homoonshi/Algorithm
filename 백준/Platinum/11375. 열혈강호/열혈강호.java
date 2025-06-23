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


        String[] input = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        book = new int[N+1];
        person = new List[M];
        visit = new boolean[N+1];

        Arrays.fill(book, -1);

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
            if(DFS(i)){
                res++;
            }
        }

        bw.write(res+"\n");


        bw.flush();

    }

    public static boolean DFS(int personIndex){

        int next = -1;

        for(int i=0; i<person[personIndex].size(); i++) {

            next = person[personIndex].get(i);
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