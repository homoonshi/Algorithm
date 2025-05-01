
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Set<String> dance = new HashSet<>();
        dance.add("ChongChong");

        for(int i=0; i<N; i++){

            String[] input = br.readLine().split(" ");

            String A = input[0];
            String B = input[1];

            if(dance.contains(A) || dance.contains(B)){
                dance.add(A);
                dance.add(B);
            }

        }

        bw.write(dance.size()+"");
        bw.flush();

    }
}