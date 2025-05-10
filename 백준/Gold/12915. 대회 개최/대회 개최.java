
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int E = Integer.parseInt(input[0]);
        int EM = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);
        int MH = Integer.parseInt(input[3]);
        int H = Integer.parseInt(input[4]);

        int res = 0;

        while(true){

            if(E>0){
                E--;
            }else {
                if(EM>0){
                    EM--;
                }else{
                    break;
                }
            }

            if(M>0){
                M--;
            }else {
                if(EM>0 || MH>0){
                    if(EM>=MH) {
                        EM--;
                    }else{
                        MH--;
                    }
                }else{
                    break;
                }
            }

            if(H>0){
                H--;
            }else{
                if(MH>0){
                    MH--;
                }else{
                    break;
                }
            }

            res++;

        }

        bw.write(res+"");
        bw.flush();

    }
}