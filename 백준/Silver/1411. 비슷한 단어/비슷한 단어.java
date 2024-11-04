
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder[] sbs = new StringBuilder[N];

        for(int i=0; i<N; i++){

            String input = br.readLine();
            int[] alphabet = new int[26];
            int num = 1;

            sbs[i] = new StringBuilder("");

            for(int j=0; j<input.length(); j++){
                if(alphabet[input.charAt(j)-97]==0){
                    alphabet[input.charAt(j)-97] = num;
                    sbs[i].append(num);
                    num++;
                }else{
                    sbs[i].append(alphabet[input.charAt(j)-97]);
                }
            }

        }

        int result = 0;

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(sbs[i].toString().equals(sbs[j].toString())){
                    result++;
                }
            }
        }

        bw.write(result+"");
        bw.flush();
    }
}
