
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        Deque<Integer> buffer = new ArrayDeque<>();

        int result = 0;
        int recentCut = -1;

        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            if (c == ')'){
                if(!buffer.isEmpty() && buffer.peekLast()==(i-1)){
                    buffer.pollLast();
                    result += buffer.size();
                    recentCut = i;
                    continue;
                }
                int index = buffer.pollLast();
                if(index<recentCut){
                    result++;
                }
                continue;
            }

            buffer.addLast(i);
        }

        bw.write(result+"");
        bw.flush();

    }
}