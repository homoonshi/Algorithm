import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();

        int[] startIndex = new int[26];
        List<Character> hasAlphabet = new ArrayList<>();
        Set<Character> dict = new HashSet<>();

        int res = 0;
        int start = 0;

        for(int i=0; i<input.length(); i++){

            char current = input.charAt(i);

            if(!dict.contains(current)){
                if(hasAlphabet.size() == N){
                    int removeIndex = 0;
                    int minStart = i;
                    for(int j=0; j<hasAlphabet.size(); j++){
                        char currentChar = hasAlphabet.get(j);
                        if(minStart > startIndex[currentChar-97]){
                            minStart = startIndex[currentChar-97];
                            removeIndex = j;
                        }
                    }
                    dict.remove(hasAlphabet.get(removeIndex));
                    hasAlphabet.remove(removeIndex);
                    start = minStart + 1;
                }
                hasAlphabet.add(current);
                dict.add(current);
            }

            startIndex[current-97] = i;

            res = Math.max(res, i - start + 1);

        }

        bw.write(res+"");
        bw.flush();

    }
}