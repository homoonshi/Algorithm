
import java.io.*;
import java.util.*;

public class Main {

    static class Word implements Comparable<Word> {

        int count;

        public Word(int count) {
            this.count = count;
        }

        @Override
        public int compareTo(Word o) {
            return this.count - o.count;
        }

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Character, Word> count = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        List<Word> words = new ArrayList<>();

        int index = 0;

        for(int i=0; i<N; i++){
            String str = br.readLine();
            int num = 1;
            for(int j=str.length()-1; j>=0; j--){
                char c = str.charAt(j);
                if(!count.containsKey(c)){
                    Word w = new Word(num);
                    words.add(w);
                    count.put(c, w);
                }else{
                    Word temp = count.get(c);
                    temp.count += num;
                }
                num *= 10;
            }
        }

        Collections.sort(words);

        int res = 0;
        int num = 9;

        for(int i=words.size()-1; i>=0; i--){
            res += words.get(i).count * num;
            num--;
        }

        bw.write(res+"");
        bw.flush();

    }

}
