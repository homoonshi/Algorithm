
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        String ad = br.readLine();

        int[] index = new int[L];

        for(int i=1; i<L; i++){
            char c = ad.charAt(i);
            int before = index[i-1];

            while(before > 0 && c != ad.charAt(before)){
                before = index[before - 1];
            }

            if(ad.charAt(before)==c){
                before++;
                index[i] = before;
            }
        }

        bw.write(L-index[L-1]+"");
        bw.flush();

    }
}