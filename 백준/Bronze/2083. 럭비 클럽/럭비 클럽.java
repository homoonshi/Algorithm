import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> lists = new ArrayList<>();

        while(true){

            String[] input = br.readLine().split(" ");

            if(input[0].charAt(0)=='#'){
                break;
            }

            int age = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            if(age>17 || weight>=80){
                lists.add(new String(input[0]+" "+"Senior\n"));
            }else{
                lists.add(new String(input[0]+" "+"Junior\n"));
            }

        }

        for (String s : lists) {
            bw.write(s);
        }

        bw.flush();

    }
}