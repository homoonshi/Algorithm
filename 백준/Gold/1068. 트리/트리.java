
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] parents = new int[N];
        boolean[] visit = new boolean[N];
        List<Integer>[] child = new List[N];

        for(int i=0; i<N; i++){
            child[i] = new ArrayList<>();
        }

        String[] input = br.readLine().split(" ");

        int rootNode = -1;

        for(int i=0; i<N; i++){
            int parent = Integer.parseInt(input[i]);

            if(parent==-1){
                rootNode=i;
                continue;
            }

            child[parent].add(i);
            parents[i] = parent;
        }

        input = br.readLine().split(" ");

        for(int i=0; i<input.length; i++) {

            int remove = Integer.parseInt(input[i]);

            visit[remove] = true;

            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(remove);

            while (!deque.isEmpty()) {
                int index = deque.pollFirst();
                for (int j = 0; j < child[index].size(); j++) {
                    int c = child[index].get(j);
                    if (visit[c]) {
                        continue;
                    }
                    deque.add(c);
                    visit[c] = true;
                }
            }

        }

        int result = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(rootNode);

        while(!deque.isEmpty()){
            int index = deque.pollFirst();
            if(visit[index]){
                continue;
            }
            int check = 0;
            for(int j=0; j<child[index].size(); j++){
                int c = child[index].get(j);
                if(visit[c]){
                    continue;
                }
                deque.add(c);
                check++;
            }
            if(child[index].size()==0||check==0) {
                result++;
            }
        }

        bw.write(result+"");
        bw.flush();

    }

}
