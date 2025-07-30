import java.io.*;
import java.util.*;

public class Main {

    static class Subject implements Comparable<Subject>{
        int index, parent;

        public Subject(int index, int parent) {
            this.index = index;
            this.parent = parent;
        }

        @Override
        public int compareTo(Subject o) {
            if (this.parent == o.parent) {
                return this.index - o.index;
            }
            return this.parent - o.parent;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        TreeSet<Subject> treeSet = new TreeSet<>();
        Subject[] subjects = new Subject[N+1];
        List<Integer>[] child = new List[N+1];

        for(int i=1; i<=N; i++){
            child[i] = new ArrayList<>();
            subjects[i] = new Subject(i, 0);
            treeSet.add(subjects[i]);
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");

            int p = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);

            child[p].add(c);
            treeSet.remove(subjects[c]);
            subjects[c].parent++;
            treeSet.add(subjects[c]);
        }

        int[] res = new int[N+1];
        int time = 0;

        while(!treeSet.isEmpty()){

            time++;
            Deque<Integer> deque = new ArrayDeque<>();

            while(!treeSet.isEmpty()){

                Subject s = treeSet.pollFirst();

                if(s.parent!=0){
                    treeSet.add(s);
                    break;
                }

                for (Integer c : child[s.index]) {
                    deque.add(c);
                }

                res[s.index] = time;

            }

            while(!deque.isEmpty()){
                Integer index = deque.pollFirst();
                treeSet.remove(subjects[index]);
                subjects[index].parent--;
                treeSet.add(subjects[index]);
            }

        }

        for(int i=1; i<=N; i++){
            bw.write(res[i]+" ");
        }

        bw.flush();

    }
}