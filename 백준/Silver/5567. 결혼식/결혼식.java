
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Set<Integer> friends = new HashSet<>();
        Set<Integer>[] others = new Set[N+1];

        for(int i=1; i<=N; i++){
            others[i] = new HashSet<>();
        }

        for(int i=0; i<M; i++){
            String[] input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            if(a==1){
                friends.add(b);
                continue;
            }

            others[a].add(b);
            others[b].add(a);
        }

        Set<Integer> otherFriends = new HashSet<>();

        int result = 0;

        for (Integer friend : friends) {
            result++;
            for (Integer index : others[friend]) {
                if(!friends.contains(index) && !otherFriends.contains(index)){
                    otherFriends.add(index);
                    result++;
                }
            }
        }

        bw.write(result+"");
        bw.flush();

    }

}
