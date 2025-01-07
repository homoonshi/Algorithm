
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = N;

        for(int i=0; i<N; i++){

            String input = br.readLine();
            int size = input.length();
            Set<Character> set = new HashSet<>();

            for(int j=0; j<size; j++){

                char c = input.charAt(j);

                if(set.contains(c)){
                    result--;
                    break;
                }

                if(j==size-1){
                    break;
                }

                char n = input.charAt(j+1);

                if(n != c) {
                    set.add(c);
                }

            }

        }


        bw.write(result+"");
        bw.flush();

    }

}
