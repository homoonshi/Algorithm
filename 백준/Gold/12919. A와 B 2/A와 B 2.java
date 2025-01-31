
import java.util.*;
import java.io.*;

public class Main {

    static String S;
    static String T;
    static Set<String>[] sets;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = br.readLine();
        T = br.readLine();

        sets = new Set[T.length()+1];

        for(int i=S.length(); i<=T.length(); i++){
            sets[i] = new HashSet<>();
        }

        sets[T.length()].add(T);

        boolean result = find();

        if(result){
            bw.write("1");
        }else{
            bw.write("0");
        }
        bw.flush();

    }

    public static boolean find(){

        StringBuilder temp;

        for(int i=T.length(); i>S.length(); i--){

            for (String s : sets[i]) {

                temp = new StringBuilder(s);

                if(temp.charAt(i-1)=='A') {
                    temp.deleteCharAt(i - 1);
                    sets[i-1].add(temp.toString());
                    if(i-1 == S.length() && S.equals(temp.toString())){
                        return true;
                    }
                }

                temp = new StringBuilder(s);

                if(temp.charAt(0)=='B'){
                    temp.deleteCharAt(0);
                    temp.reverse();
                    sets[i-1].add(temp.toString());
                    if(i-1 == S.length() && S.equals(temp.toString())){
                        return true;
                    }
                }

            }

        }

        return false;
    }

}
