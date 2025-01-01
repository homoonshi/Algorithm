
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<String>[] words = new List[51];

        for(int i=1; i<=50; i++){
            words[i] = new ArrayList<>();
        }
        String input;

        Set<String> set = new HashSet<>();

        for(int i=0; i<N; i++){
            input = br.readLine();
            if(set.contains(input)){
                continue;
            }

            set.add(input);
            words[input.length()].add(input);
        }

        for(int i=1; i<=50; i++){

            if(words[i].size()==0){
                continue;
            }

            Collections.sort(words[i]);
            for (String word : words[i]) {
                bw.write(word+"\n");
            }
        }

        bw.flush();

    }

}
