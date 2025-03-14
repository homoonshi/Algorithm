
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case=0; test_case<T; test_case++){

            String input = br.readLine();

            int n = input.length();
            int sLen = n/3;

            if(n%3>0){
                sLen++;
            }

            StringBuilder s = new StringBuilder();

            for(int i=0; i<sLen; i++){
                s.append(input.charAt(i));
            }

            String sDot = s.toString();
            String rev = s.reverse().toString();
            String tailRev = rev.substring(1);
            String tailS = sDot.substring(1);

            StringBuilder case1 = new StringBuilder(sDot);
            case1.append(rev);
            case1.append(sDot);

            StringBuilder case2 = new StringBuilder(sDot);
            case2.append(rev);
            case2.append(tailS);

            StringBuilder case3 = new StringBuilder(sDot);
            case3.append(tailRev);
            case3.append(sDot);

            StringBuilder case4 = new StringBuilder(sDot);
            case4.append(tailRev);
            case4.append(tailS);

            boolean find = false;

            if(input.equals(case1.toString())){
                find=true;
            }else if(input.equals(case2.toString())){
                find=true;
            }else if(input.equals(case3.toString())){
                find=true;
            }else if(input.equals(case4.toString())){
                find=true;
            }

            if(find){
                bw.write("1\n");
            }else{
                bw.write("0\n");
            }

        }

        bw.flush();

    }

}
