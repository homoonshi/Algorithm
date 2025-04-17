
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        int C = Integer.parseInt(input[0]);
        int D = Integer.parseInt(input[1]);

        int[] nine = new int[H];
        int sum = 0;

        for(int i=0; i<H; i++){
            nine[i] = i;
            sum += i;
        }

        if(sum>D){
            bw.write("-1");
            bw.flush();
            return;
        }

        while(sum<D){
            for(int i=H-1; i>=0; i--){
                nine[i]++;
                if(nine[i]>W){
                    bw.write("-1");
                    bw.flush();
                    return;
                }
                sum++;
                if(sum>=D){
                    break;
                }
            }
        }

        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(nine[i]>0){
                    bw.write("9 ");
                    nine[i]--;
                }else{
                    bw.write("1 ");
                }
            }
            bw.write("\n");
        }

        bw.flush();

    }

}
