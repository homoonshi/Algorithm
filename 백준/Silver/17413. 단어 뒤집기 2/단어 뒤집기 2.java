
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        StringBuffer res = new StringBuffer();
        Deque<Character> deque = new ArrayDeque<>();

        boolean tag = false;

        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            if(c=='<' || c==' ' || c=='>'){
                while(!deque.isEmpty()){
                    res.append(deque.pollLast());
                }
                res.append(c);
                if(c=='<'){
                    tag = true;
                }else if(c=='>'){
                    tag = false;
                }
                continue;
            }

            if(tag){
                res.append(c);
                continue;
            }

            deque.addLast(c);
        }

        while(!deque.isEmpty()){
            res.append(deque.pollLast());
        }

        bw.write(res.toString());
        bw.flush();

    }

}
