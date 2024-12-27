
import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int[] p = new int[N];

        for(int i=0; i<N; i++){
            p[i] = Integer.parseInt(input[i]);
        }

        List<Integer> list = new ArrayList<>();

        int up = 1;

        list.add(p[N-1]);

        for(int i=N-2; i>=0; i--){
            if(p[i]>p[i+1]){
                list.add(p[i]);
                up++;
                continue;
            }
            Collections.sort(list);
            int temp = p[i];
            for(int j=0; j<list.size(); j++){
                if(temp<list.get(j)){
                    p[i] = list.get(j);
                    list.remove(j);
                    list.add(j, temp);
                    break;
                }
            }
            int index = 0;
            for(int j=i+1; j<N; j++){
                p[j] = list.get(index++);
            }
            break;
        }

        if(up==N) {
            bw.write("-1");
        }else{
            for(int i=0; i<N; i++){
                bw.write(p[i]+" ");
            }
        }

        bw.flush();

    }

}
