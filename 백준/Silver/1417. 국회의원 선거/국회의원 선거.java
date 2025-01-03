
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Integer[] assemblyman = new Integer[N-1];
        int dasom = Integer.parseInt(br.readLine());

        if(N==1){
            bw.write("0");
            bw.flush();
            return;
        }

        for(int i=0; i<N-1; i++){
            assemblyman[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;

        while(true){

            Arrays.sort(assemblyman, Collections.reverseOrder());

            if(assemblyman[0]<dasom){
                break;
            }

            dasom++;
            assemblyman[0]--;
            result++;

        }

        bw.write(result+"");
        bw.flush();

    }

}
