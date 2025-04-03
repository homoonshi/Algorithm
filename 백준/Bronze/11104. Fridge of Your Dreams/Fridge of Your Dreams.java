
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case<n; test_case++){

            String num = br.readLine();
            long res = 0;

            for(int i=0; i<num.length(); i++){

                if(num.charAt(i)=='0'){
                    res = (res << 1);
                }else{
                    res = (res << 1) + 1;
                }

            }

            bw.write(res+"\n");

        }

        bw.flush();

    }
}