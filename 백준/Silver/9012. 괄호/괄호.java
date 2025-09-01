import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        loof : for(int i=0; i<n; i++){

            String input = br.readLine();
            int left = 0;

            for(int j=0; j<input.length(); j++){

                char c = input.charAt(j);

                if(c=='('){
                    left++;
                }else{
                    if(left==0){
                        bw.write("NO\n");
                        continue loof;
                    }
                    left--;
                }

            }

            if(left==0) {
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }

        }

        bw.flush();

    }
}