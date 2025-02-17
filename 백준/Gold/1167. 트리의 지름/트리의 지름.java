
import java.util.*;
import java.io.*;

public class Main {

    static class Tree implements Comparable<Tree> {

        int index;
        int distance;
        int depth;
        int direction;

        public Tree(int index, int distance, int depth, int direction) {
            this.index = index;
            this.distance = distance;
            this.depth = depth;
            this.direction = direction;
        }

        @Override
        public int compareTo(Tree o) {
            return o.distance - this.distance;
        }
    }

    static Tree[] trees;
    static int[] depth;
    static int[] conParent;
    static int[] parent;
    static int[] dist;
    static int V;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        V = Integer.parseInt(br.readLine());

        List<int[]>[] map = new List[V+1];

        for(int i=1; i<=V; i++){
            map[i] = new ArrayList<>();
        }

        depth = new int[V+1];
        conParent = new int[V+1];
        parent = new int[V+1];
        dist = new int[V+1];
        trees = new Tree[V];

        for(int i=0; i<V; i++){
            String[] input = br.readLine().split(" ");
            int index = Integer.parseInt(input[0]);
            for(int j=1; j<input.length-1; j+=2){
                int friendIndex = Integer.parseInt(input[j]);
                int friendDistance = Integer.parseInt(input[j+1]);
                map[index].add(new int[]{friendIndex, friendDistance});
            }
        }

        setTree(map);
        Arrays.sort(trees);
        Arrays.fill(conParent, -1);

        bw.write(searchDist()+"");
        bw.flush();

    }

    public static int searchDist(){

        Deque<Integer> parentList;
        int result = trees[0].distance;

        int standIndex = trees[0].index;

        for(int i=1; i<trees.length; i++){

            if(trees[0].direction != trees[i].direction){
                conParent[i] = 1;
            }

            if(conParent[i]!=-1){
                int p = conParent[i];
                result = Math.max(result, trees[i].distance + trees[0].distance - 2 * dist[p]);
                continue;
            }

            int versusIndex = trees[i].index;

            int aParent = standIndex;
            int bParent = versusIndex;

            if(aParent==bParent){
                conParent[i] = bParent;
                result = Math.max(result, trees[i].distance + trees[0].distance - 2 * dist[bParent]);
                continue;
            }

            int aDepth = depth[standIndex];
            int bDepth = depth[versusIndex];

            parentList = new ArrayDeque<>();
            parentList.add(bParent);

            while(aDepth < bDepth){
                bParent = parent[bParent];
                parentList.add(bParent);
                bDepth--;
            }

            while(aDepth > bDepth){
                aParent = parent[aParent];
                aDepth--;
            }

            while(aParent != bParent){
                aParent = parent[aParent];
                bParent = parent[bParent];
                parentList.add(bParent);
            }

            while(!parentList.isEmpty()){
                int index = parentList.pollFirst();
                conParent[index] = bParent;
            }

            result = Math.max(result, trees[i].distance + trees[0].distance - 2 * dist[bParent]);
        }

        return result;
    }

    public static void setTree(List<int[]>[] map){

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);

        boolean[] visited = new boolean[V+1];
        visited[1] = true;
        int direction = 0;

        Tree tree = new Tree(1, 0, 0, 0);
        trees[0] = tree;

        while(!deque.isEmpty()){

            int index = deque.pollFirst();

            for(int i=0; i<map[index].size(); i++){

                int[] temp = map[index].get(i);

                int nIndex = temp[0];
                int nDist = temp[1];

                if(visited[nIndex]){
                    continue;
                }

                if(index==1){
                    direction++;
                }else{
                    direction = trees[index-1].direction;
                }

                depth[nIndex] = depth[index]+1;
                parent[nIndex] = index;
                dist[nIndex] = dist[index]+nDist;

                Tree t = new Tree(nIndex, dist[nIndex], depth[nIndex], direction);
                trees[nIndex-1] = t;
                visited[nIndex] = true;

                deque.addLast(nIndex);

            }

        }

    }

}
