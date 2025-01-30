
import java.io.*;
import java.util.*;

public class Main {

    static String S;
    static String T;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = br.readLine();
        T = br.readLine();

        boolean result = find();

        if(result){
            bw.write("1");
        }else{
            bw.write("0");
        }

        bw.flush();

    }

    public static boolean find(){

        StringBuilder sb = new StringBuilder(T);

        for(int i=T.length()-1; i>=S.length(); i--){
            char lastStr = sb.charAt(i);
            if(lastStr=='A'){
                sb = sb.deleteCharAt(i);
            }else{
                sb = sb.deleteCharAt(i);
                sb.reverse();
            }
        }

        return S.equals(sb.toString());
    }

}
