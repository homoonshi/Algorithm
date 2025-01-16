
import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int button = 0;
        sb = new StringBuilder("ABCDE");

        while(button != 4){

            button = Integer.parseInt(br.readLine());
            int num = Integer.parseInt(br.readLine());

            for(int i=0; i<num; i++) {
                clickButton(button);
            }

        }

        for(int i=0; i<5; i++){
            bw.write(sb.substring(i, i+1)+" ");
        }
        bw.flush();

    }

    private static void clickButton(int button) {
        switch (button){
            case 1:
                sb.append(sb.substring(0,1));
                sb.delete(0,1);
                break;
            case 2:
                sb.insert(0,sb.substring(4,5));
                sb.delete(5,6);
                break;
            case 3:
                sb.insert(2,sb.substring(0,1));
                sb.delete(0,1);
                break;
        }
    }

}
