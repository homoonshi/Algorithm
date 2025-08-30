import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            int m = Integer.parseInt(br.readLine());

            if(m==0) break;

            int startIndex = 0;
            int currentIndex = 0;

            String str = br.readLine();
            Map<Character, Integer> dict = new HashMap<>();

            int count = 0;
            char c;

            int res = 0;
            int len = 0;

            for( ; currentIndex<str.length(); currentIndex++){

                if(count==m){
                    c = str.charAt(currentIndex);
                    if(dict.get(c)!=null && dict.get(c)>0){
                        dict.put(c, dict.get(c)+1);
                        len++;
                        res = Math.max(res, len);
                        continue;
                    }
                    for( ; startIndex<=currentIndex; startIndex++){
                        c = str.charAt(startIndex);
                        len--;
                        if(dict.get(c)==1){
                            dict.put(c, 0);
                            count--;
                            startIndex++;
                            break;
                        }
                        dict.put(c, dict.get(c)-1);
                    }
                }

                c = str.charAt(currentIndex);
                if(dict.get(c)==null){
                    dict.put(c, 1);
                    count++;
                }else{
                    dict.put(c, dict.get(c)+1);
                    if(dict.get(c)==1){
                        count++;
                    }
                }
                len++;
                res = Math.max(res, len);

            }

            bw.write(res+"\n");

        }

        bw.flush();

    }
}