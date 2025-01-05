
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10001];

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
        }

        int count = 0;

        for(int i=1; i<10001; i++){
            for(int j=0; j<arr[i]; j++){
                bw.write(i+"\n");
                count++;
            }
            if(count==N){
                bw.flush();
                return;
            }
        }

    }

}
