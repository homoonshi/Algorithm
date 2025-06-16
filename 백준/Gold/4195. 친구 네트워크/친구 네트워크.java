
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case=0; test_case<T; test_case++){

            int F = Integer.parseInt(br.readLine());
            Set<String>[] friends = new Set[F*2];
            HashMap<String, Integer> friendIndex = new HashMap<>();

            for(int i=0; i<F*2; i++){
                friends[i] = new HashSet<>();
            }

            for(int i=0; i<F; i++){

                String[] f = br.readLine().split(" ");

                int index1 = i;
                int index2 = i;

                if(friendIndex.containsKey(f[0])){
                    index1 = friendIndex.get(f[0]);
                }

                if(friendIndex.containsKey(f[1])){
                    index2 = friendIndex.get(f[1]);
                }

                if(index1==index2){
                    friendIndex.put(f[0], index1);
                    friendIndex.put(f[1], index1);
                    friends[index1].add(f[0]);
                    friends[index1].add(f[1]);
                    bw.write(friends[index1].size()+"\n");
                    continue;
                }

                if(index1<=index2){
                    friendIndex.put(f[1], index1);
                    friends[index1].add(f[1]);
                    for (String s : friends[index2]) {
                        friendIndex.put(s, index1);
                        friends[index1].add(s);
                    }
                    bw.write(friends[index1].size()+"\n");
                }else{
                    friendIndex.put(f[0], index2);
                    friends[index1].add(f[0]);
                    for (String s : friends[index1]) {
                        friendIndex.put(s, index2);
                        friends[index2].add(s);
                    }
                    bw.write(friends[index2].size()+"\n");
                }

            }


        }
        bw.flush();

    }
}