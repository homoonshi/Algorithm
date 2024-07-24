
import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] word;
    static Set<Character> words = new HashSet<>();
    static Deque<Character> wordList;
    static String[] w;
    static int number;
    static int res, count;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);

        word = new int[27];
        int know = southLanguage();

        if ( K < know ){
            bw.write("0");
            bw.flush();
            return;
        }

        w = new String[N];
        number = 0;
        res = 0;

        for(int i=0; i<N; i++){

            String str = br.readLine();

            str = str.replace("a","");
            str = str.replace("n","");
            str = str.replace("i","");
            str = str.replace("t","");
            str = str.replace("c","");

            str = str.toUpperCase();

            if(str.equals("")){
                count++;
                continue;
            }

            int length = str.length();
            for(int j=0; j<length; j++){
                if(!words.contains(str.charAt(j))){
                    words.add(str.charAt(j));
                }
            }

            w[number++] = str;

        }

        res = count;

        wordList = new ArrayDeque<>(words);
        combination(know);

        bw.write(res+"\n");
        bw.flush();

    }

    public static void combination(int k){

        if(k==K|| wordList.isEmpty()){

            int c = count;

            for(int i=0; i<number; i++){

                String s = w[i];
                int size = 0;

                for(int j=0; j<s.length(); j++){

                    if(word[s.charAt(j)-65]==1){
                        size++;
                    }

                }

                if(size==s.length()){
                    c++;
                }

            }

            res = Math.max(res, c);

            return;
        }

        if(!wordList.isEmpty()) {

            char c = wordList.pollFirst();

            word[c - 65] = 1;

            combination(k + 1);

            word[c - 65] = 0;

            combination(k);

            wordList.addLast(c);

        }

    }

    public static int southLanguage(){
        // anta tica
        word['A'-65] = 1;
        word['N'-65] = 1;
        word['T'-65] = 1;
        word['I'-65] = 1;
        word['C'-65] = 1;

        return 5;
    }

}