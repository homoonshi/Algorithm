
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int myW = Integer.parseInt(input[0]);
        int myH = Integer.parseInt(input[1]);

        int stW = Integer.parseInt(input[2]);
        int stH = Integer.parseInt(input[3]);

        myW -= 2;
        myH -= 2;

        if(myW >= stW && myH >= stH){
            bw.write("1");
        }else {
            bw.write("0");
        }

        bw.flush();

    }

}
