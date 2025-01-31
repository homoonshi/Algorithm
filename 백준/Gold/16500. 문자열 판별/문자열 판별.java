
import java.io.*;
import java.util.*;

public class Main {

    static Set<String>[] words;
    static int[] dp;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        int N = Integer.parseInt(br.readLine());

        words = new Set[26];
        dp = new int[S.length()+1];

        Arrays.fill(dp, -1);

        for(int i=0; i<26; i++){
            words[i] = new HashSet<>();
        }

        for(int i=0; i<N; i++){
            String word = br.readLine();
            words[word.charAt(0)-97].add(word);
        }

        bw.write(find(new StringBuilder(S))+"");

        bw.flush();

    }

    public static int find(StringBuilder s){

        if(words[s.charAt(0)-97].isEmpty()){
            return 0;
        }

        if(dp[s.length()]!=-1){
            return dp[s.length()];
        }

        repeat : for (String word : words[s.charAt(0) - 97]) {

            if(word.length() > s.length()){
                continue;
            }

            for(int i=0; i<word.length(); i++){
                if(s.charAt(i) != word.charAt(i)){
                    continue repeat;
                }
            }

            StringBuilder str = new StringBuilder(s);
            str.delete(0, word.length());

            if(str.length()==0){
                return 1;
            }

            int res = find(str);

            if(res==1){
                dp[s.length()] = 1;
                return 1;
            }

        }

        dp[s.length()] = 0;
        return 0;
    }

}
