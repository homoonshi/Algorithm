
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case<T; test_case++){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> clothIndex = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            int currentIndex = 0;
            for(int i=0; i<n; i++){
                String[] input = br.readLine().split(" ");
                String name = input[1];
                if(clothIndex.containsKey(name)){
                    int index = clothIndex.get(name);
                    list.set(index, list.get(index)+1);
                    continue;
                }
                clothIndex.put(name, currentIndex++);
                list.add(1);
            }
            int result = 1;
            for (Integer i : list) {
                result *= (i+1);
            }
            result-=1;
            bw.write(result+"\n");
        }
        bw.flush();
    }
}