
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        long C = Integer.parseInt(input[1]);
        long W = Integer.parseInt(input[2]);

        int[] tree = new int[N];
        int end = 0;

        for(int i=0; i<N; i++){
            tree[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, tree[i]);
        }

        long res = 0;

        for(int i=1; i<=end; i++){

            long count = 0;
            long c = 0;

            for(int j=0; j<N; j++){
                if(tree[j]>=i) {
                    count += tree[j] / i;
                    if (tree[j] != i) {
                        long cc = 0;
                        if (tree[j] % i == 0) {
                            cc = ((tree[j] / i) - 1);
                        } else {
                            cc = (tree[j] / i);
                        }
                        if(C*cc > W*(tree[j]/i)*i){
                            count -= tree[j]/i;
                            continue;
                        }
                        c += cc;
                    }
                }
            }

            res = Math.max(res, (count*W*i - C*c));
        }

        bw.write(res+"");
        bw.flush();

    }

}