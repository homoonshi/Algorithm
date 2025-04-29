
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        int[] X = new int[N];
        int[] compress = new int[N];

        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            X[i] = Integer.parseInt(input[i]);
            compress[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(compress);

        map.put(compress[0], 0);
        int count = 1;
        for(int i=1; i<N; i++){
            if(compress[i] == compress[i-1]){
                continue;
            }
            map.put(compress[i], count);
            count++;
        }

        for(int i=0; i<N; i++){
            int res = map.get(X[i]);
            bw.write(res+" ");
        }

        bw.flush();

    }
}