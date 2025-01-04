
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case=0; test_case<T; test_case++){

            int N = Integer.parseInt(br.readLine());
            int[] card = new int[2];
            String[] input = br.readLine().split(" ");

            for(int i=0; i<N; i++){
                int num = Integer.parseInt(input[i]);
                card[num%2]++;
            }

            if(card[0]<card[1]){
                if(card[1]%2==0){
                    bw.write("heeda0528");
                }else{
                    bw.write("amsminn");
                }
            }else{
                if(card[0]==card[1]){
                    bw.write("heeda0528");
                }else if (card[0]%2==0){
                    bw.write("heeda0528");
                }else{
                    bw.write("amsminn");
                }
            }

            bw.write("\n");

        }

        bw.flush();

    }

}
