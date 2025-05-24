
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        while((str = br.readLine())!=null){

            for(int i=0; i<str.length(); i++){

                Character c = str.charAt(i);

                if(c==' '){
                    continue;
                }

                int len;

                if(!map.containsKey(c)){
                    len = 0;
                }else {
                    len = map.get(c);
                }

                map.put(c, len+1);
                max = Math.max(max, len+1);

            }
        }

        StringBuilder res = new StringBuilder("");

        for(int i=0; i<26; i++){

            Character c = (char) ('a' + i);

            if(!map.containsKey(c)){
                continue;
            }

            int len = map.get(c);

            if(len==max){
                res.append(c);
            }

        }

        bw.write(res.toString());
        bw.flush();

    }
}