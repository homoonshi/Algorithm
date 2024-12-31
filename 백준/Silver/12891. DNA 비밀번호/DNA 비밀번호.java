
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int S = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);

        String password = br.readLine();

        Map<Character, Integer> words = new HashMap<>();

        input = br.readLine().split(" ");

        words.put('A', Integer.parseInt(input[0]));
        words.put('C', Integer.parseInt(input[1]));
        words.put('G', Integer.parseInt(input[2]));
        words.put('T', Integer.parseInt(input[3]));

        int result = 0;
        int[] word = new int[4];

        for(int i=0; i<=P-1; i++){
            switch (password.charAt(i)) {
                case 'A':
                    word[0]++;
                    break;
                case 'C':
                    word[1]++;
                    break;
                case 'G':
                    word[2]++;
                    break;
                case 'T':
                    word[3]++;
                    break;
            }
        }

        if(word[0] >= words.get('A') && word[1] >= words.get('C')
                && word[2] >= words.get('G') && word[3] >= words.get('T')){
            result++;
        }

        for(int i=P; i<S; i++){

            switch (password.charAt(i-P)) {
                case 'A':
                    word[0]--;
                    break;
                case 'C':
                    word[1]--;
                    break;
                case 'G':
                    word[2]--;
                    break;
                case 'T':
                    word[3]--;
                    break;
            }

            switch (password.charAt(i)) {
                case 'A':
                    word[0]++;
                    break;
                case 'C':
                    word[1]++;
                    break;
                case 'G':
                    word[2]++;
                    break;
                case 'T':
                    word[3]++;
                    break;
            }

            if(word[0] >= words.get('A') && word[1] >= words.get('C')
                    && word[2] >= words.get('G') && word[3] >= words.get('T')){
                result++;
            }

        }

        bw.write(result+"");
        bw.flush();

    }

}
