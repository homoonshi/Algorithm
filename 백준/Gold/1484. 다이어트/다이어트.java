
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int G = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList<>();

        double after = 2;
        int before = 1;

        while(after>=before){

            after = Math.sqrt(G + Math.pow(before, 2));

            if(after == (int)after){
                result.add((int)after);
            }

            before++;

        }

        for (Integer res : result) {
            bw.write(res+"\n");
        }

        if(result.size()==0){
            bw.write("-1");
        }

        bw.flush();

    }

}
