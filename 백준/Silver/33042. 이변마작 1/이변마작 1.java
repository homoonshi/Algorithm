
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++){

            if(map.containsKey(input[i])){
                int num = map.get(input[i]);
                if(num==4){
                    bw.write(i+1+"");
                    bw.flush();
                    return;
                }
                map.put(input[i], num+1);
            }else{
                map.put(input[i],1);
            }

        }

        bw.write("0");
        bw.flush();

    }

}
