
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int T = Integer.parseInt(input[1]);

        List<Integer> bus = new ArrayList<>();

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");

            int S = Integer.parseInt(input[0]);
            int I = Integer.parseInt(input[1]);
            int C = Integer.parseInt(input[2]);

            for(int j=0; j<C; j++){
                bus.add(S+(I*j));
            }
        }

        Collections.sort(bus);
        int result = -1;

        for(Integer time : bus){
            if(T < time){
                result = time - T;
                break;
            }else if(T==time){
                result = 0;
                break;
            }
        }

        bw.write(result+"");
        bw.flush();

    }

}
