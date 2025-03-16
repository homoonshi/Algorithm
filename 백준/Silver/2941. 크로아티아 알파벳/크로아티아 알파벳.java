
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<String> set = initData();

        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int result = 0;

        for(int i=0; i<str.length(); i++){

            sb.append(str.charAt(i));

            if(set.contains(sb.toString())){
                result++;
                sb = new StringBuilder();
            }

            if(sb.length()>=3){
                sb.deleteCharAt(0);
                result++;
            }

            if(set.contains(sb.toString())){
                result++;
                sb = new StringBuilder();
            }

        }

        if(sb.length()>0){
            result += sb.length();
        }

        bw.write(result+"");
        bw.flush();

    }

    private static HashSet<String> initData() {
        HashSet<String> set = new HashSet<>();
        set.add("c=");
        set.add("c-");
        set.add("dz=");
        set.add("d-");
        set.add("lj");
        set.add("nj");
        set.add("s=");
        set.add("z=");
        return set;
    }

}
