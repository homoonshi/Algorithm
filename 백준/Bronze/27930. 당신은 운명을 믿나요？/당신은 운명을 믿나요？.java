
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int korea = 0;
        int yonsei = 0;

        String e1 = "KOREA";
        String e2 = "YONSEI";

        for(int i=0; i<str.length(); i++){

            char c = str.charAt(i);

            if(e1.charAt(korea)==c){
                korea++;
            }
            
            if(e2.charAt(yonsei)==c){
                yonsei++;
            }

            if(korea==5){
                bw.write("KOREA");
                break;
            }else if(yonsei==6){
                bw.write("YONSEI");
                break;
            }

        }

        bw.flush();

    }

}
