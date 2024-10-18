
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] person = new int[N];

        for(int i=0; i<N; i++){
            person[i] = Integer.parseInt(input[i]);
        }

        int[] result = new int[N];

        for(int i=0; i<N; i++){

            for(int j=0; j<N; j++){

                if(person[i]==0 && result[j]==0){
                    result[j]=i+1;
                    break;
                }

                if(result[j]==0){
                    person[i]--;
                }

            }

        }

        for(int i=0; i<N; i++){
            bw.write(result[i]+" ");
        }

        bw.flush();

    }

}
