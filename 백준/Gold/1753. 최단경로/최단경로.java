import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int num;
        int d;

        Node(int num, int d) {
            this.num = num;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.d, o.d);
        }
    }

    static int V, K;
    static List<Node>[] map;
    static int[] distance;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        V = Integer.parseInt(input[0]); // 정점 개수
        int E = Integer.parseInt(input[1]); // 간선 개수

        K = Integer.parseInt(br.readLine()); // 시작 정점의 번호

        map = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            map[i] = new ArrayList<>();
        }

        visit = new boolean[V + 1];
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;

        int u, v, w;

        for (int i = 0; i < E; i++) {
            input = br.readLine().split(" ");
            u = Integer.parseInt(input[0]);
            v = Integer.parseInt(input[1]);
            w = Integer.parseInt(input[2]);
            map[u].add(new Node(v, w));
        }

        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(distance[i] + "\n");
            }
        }

        bw.flush();
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.num;

            if (visit[currentNode]) continue;
            visit[currentNode] = true;

            for (Node neighbor : map[currentNode]) {
                if (visit[neighbor.num]) continue;

                int newDist = distance[currentNode] + neighbor.d;
                if (newDist < distance[neighbor.num]) {
                    distance[neighbor.num] = newDist;
                    pq.offer(new Node(neighbor.num, newDist));
                }
            }
        }
    }
}
