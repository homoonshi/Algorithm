
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        if(input.equals(".")){
            return;
        }

        TC : do {

            Deque<Character> left = new ArrayDeque<>();

            for(int i=0; i<input.length(); i++){

                char c = input.charAt(i);

                if(c=='(' || c=='['){
                    left.addLast(c);
                    continue;
                }

                if(c==')' || c==']'){
                    if(left.isEmpty()){
                        bw.write("no\n");
                        input = br.readLine();
                        continue TC;
                    }
                    char l = left.pollLast();
                    if(c==')' && l=='('){
                        continue;
                    }else if(c==']' && l=='['){
                        continue;
                    }
                    bw.write("no\n");
                    input = br.readLine();
                    continue TC;
                }

            }

            if(left.isEmpty()){
                bw.write("yes\n");
            }else{
                bw.write("no\n");
            }

            input = br.readLine();

        }while (!input.equals("."));

        bw.flush();

    }

}
