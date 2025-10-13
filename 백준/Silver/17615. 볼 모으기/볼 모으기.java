import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] ball = new int[2];

        ball[0] = N+1;
        ball[1] = N+1;

        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                int t = 0;
                int index = j == 0 ? N : -1;
                boolean check = false;
                for(int k=0; k<N; k++){
                    index = j == 0 ? index-1 : index+1;
                    if(i==0){
                        if (str.charAt(index)=='R'){
                            if(check){
                                t++;
                            }
                        }else{
                            check = true;
                        }
                    }else {
                        if (str.charAt(index) == 'B') {
                            if(check){
                                t++;
                            }
                        }else{
                            check = true;
                        }
                    }
                }
                ball[i] = Math.min(ball[i], t);
            }
        }


        bw.write(Math.min(ball[0], ball[1])+"");
        bw.flush();

    }
}