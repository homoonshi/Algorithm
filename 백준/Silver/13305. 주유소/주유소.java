
import java.io.*;
public class Main {

    static int N;
    static long[] distance;
    static long[] oil;
    static long result;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        distance = new long[N-1];
        oil = new long[N];

        String[] input = br.readLine().split(" ");

        for(int i=0; i<N-1; i++){
            distance[i] = Long.parseLong(input[i]);
        }

        input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            oil[i] = Long.parseLong(input[i]);
        }

        result = 0;

        outer :
        for(int i=0; i<N-1; i++){
            result += oil[i] * distance[i];
            for(int j=i+1; j<N-1; j++){
                if(oil[i] > oil[j]){
                    i = j-1;
                    continue outer;
                }
                result += oil[i] * distance[j];
            }
            i=N-1;
        }

        bw.write(result+"");
        bw.flush();

    }

}
