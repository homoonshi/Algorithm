
import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        List<int[]> flower = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        int result = 0;

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            boolean crush = false;
            for(int j=0; j<3; j++){
                int num = Integer.parseInt(input[j]);
                if(set.contains(num)){
                    crush = true;
                }else{
                    set.add(num);
                }
            }
            if(!crush){
                result++;
            }
        }

        bw.write(result+"");
        bw.flush();

    }

}
