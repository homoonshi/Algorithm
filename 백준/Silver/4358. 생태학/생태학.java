
import java.io.*;
import java.util.*;

public class Main {

    static class Dic implements Comparable<Dic> {

        String word;
        int nums;

        public Dic(String word, int nums) {
            this.word = word;
            this.nums = nums;
        }

        @Override
        public int compareTo(Dic o) {
            return this.word.compareTo(o.word);
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Dic> dics = new ArrayList<>();
        Map<String, Integer> words = new HashMap<>();

        String input = br.readLine();
        float size = 0;

        while (input != null && !input.isEmpty()){

            if (!words.containsKey(input)) {
                Dic dic = new Dic(input, 1);
                dics.add(dic);
                words.put(input, dics.size() - 1);
            } else {
                int index = words.get(input);
                Dic temp = dics.get(index);
                temp.nums++;
            }

            size++;
            input = br.readLine();

        }

        Collections.sort(dics);

        for (Dic dic : dics) {

            float per = (float) (dic.nums/size) * 100;
            bw.write(dic.word +" "+ String.format("%.4f", per)+"\n");

        }

        bw.flush();

    }

}
