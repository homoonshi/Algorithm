import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int FF = Integer.parseInt(input[0]);
        int FS = Integer.parseInt(input[1]);
        int SF = Integer.parseInt(input[2]);
        int SS = Integer.parseInt(input[3]);

        int res = 0;

        if(FS == 0 && FF == 0){
            res = SS;
            res += SF > 0 ? 1 : 0;
        }else{
            res = FF;
            if(FS != 0) {
                res += SS;
                res += FS > SF ? SF*2 + 1 : FS*2;
            }
        }

        bw.write(res+"");
        bw.flush();
    }
}