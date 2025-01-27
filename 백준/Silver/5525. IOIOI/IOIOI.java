
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static StringBuilder sb;
    static String S;
    static int PM;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder("IOI");

        for(int i=2; i<=N; i++){
            sb.append("OI");
        }

        PM = sb.length();
        int M = Integer.parseInt(br.readLine());

        S = br.readLine();

        int result = 0;
        int lastStart = Integer.MAX_VALUE;

        int flag = 0;

        if(S.charAt(0)=='I') {
            flag = 1; // O = 0 I = 1
            lastStart = 0;
        }else{
            flag = 0;
        }

        for(int i=1; i<M; i++){

            char c = S.charAt(i);

            if(c=='I' && flag==1){
                lastStart = i;
                continue;
            }

            if(c=='O' && flag==0){
                lastStart = Integer.MAX_VALUE;
                continue;
            }

            if(c=='I' && flag==0){
                flag = 1;
                if(lastStart==Integer.MAX_VALUE){
                    lastStart = i;
                }
            }

            if(c=='O' && flag==1){
                flag = 0;
            }

            if(i-lastStart==PM-1 && flag==1){
                lastStart+=2;
                result++;
            }

        }

        bw.write(result+"");
        bw.flush();

    }

}
