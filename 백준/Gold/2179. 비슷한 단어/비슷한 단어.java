
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int maxPrefix;
    static Map<String, List<String>>[] words;
    static int length;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        String[] w = new String[N];
        length = 0;
        maxPrefix = 0;

        for(int i=0; i<N; i++){
            w[i] = br.readLine();
            length = Math.max(length, w[i].length());
        }

        words = new Map[length+1];

        for(int i=0; i<length+1; i++){
            words[i] = new LinkedHashMap<>();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<w[i].length(); j++){
                String pre = w[i].substring(0, j+1);
                save(pre, w[i], j+1);
            }
        }

        for (Map.Entry<String, List<String>> stringPriorityQueueEntry : words[maxPrefix].entrySet()) {
            List<String> list = stringPriorityQueueEntry.getValue();
            if(list.size()==1){
                continue;
            }
            bw.write(list.get(0)+"\n");
            bw.write(list.get(1)+"\n");
            break;
        }

        bw.flush();

    }

    public static void save(String prefix, String word, int len){

        if(!words[len].containsKey(prefix)){
            List<String> list = new ArrayList<>();

            list.add(word);

            words[len].put(prefix, list);
            return;
        }

        List<String> list = words[len].get(prefix);
        list.add(word);
        maxPrefix = Math.max(maxPrefix, len);

    }

}