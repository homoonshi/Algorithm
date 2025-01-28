
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        String binary = Integer.toBinaryString(num);
        String res = inversionBinary(binary);

        bw.write(Integer.parseInt(res,2)+"");
        bw.flush();

    }

    public static String inversionBinary(String binary){

        int len = binary.length();
        StringBuilder sb = new StringBuilder("");

        for(int i=len-1; i>=0; i--){
            char c = binary.charAt(i);
            sb.append(c);
        }

        return sb.toString();
    }

}
