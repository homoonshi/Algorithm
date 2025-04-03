
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        List<Integer> list = new ArrayList<>();
        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(input[i]);
            boolean find = false;

            for (int j = 0; j < list.size(); j++) {
                if(list.get(j)<=arr[i]){
                    list.set(j, arr[i]);
                    find = true;
                    break;
                }
            }

            if(!find){
                list.add(arr[i]);
            }

        }

        bw.write(list.size()+"");
        bw.flush();

    }
}