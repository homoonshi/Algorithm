
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static class Alphabet implements Comparable<Alphabet> {
        BigInteger count;
        char c;

        public Alphabet(BigInteger count, char c) {
            this.count = count;
            this.c = c;
        }

        @Override
        public int compareTo(Alphabet o) {
            int res = this.count.compareTo(o.count);
            return res;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int alphabetCount = 10;
        int N = Integer.parseInt(br.readLine());

        Map<Character, Alphabet> map = new HashMap<>();
        List<Alphabet> alphabets = new ArrayList<>();
        Set<Character> isNotZero = new HashSet<>();

        for(int i=0; i<N; i++){
            String input = br.readLine();
            BigInteger posi = BigInteger.ONE;
            for(int j=input.length()-1; j>=0; j--){
                char c = input.charAt(j);

                if(j==0){
                    isNotZero.add(c);
                }

                if(!map.containsKey(c)){
                    Alphabet temp = new Alphabet(posi, c);
                    alphabets.add(temp);
                    map.put(c, temp);
                    alphabetCount--;
                }else {
                    Alphabet temp = map.get(c);
                    temp.count = temp.count.add(posi);
                }

                posi = posi.multiply(BigInteger.valueOf(10));
            }
        }

        Collections.sort(alphabets);

        BigInteger result = BigInteger.ZERO;

        if(alphabetCount==0){
            for(int i=0; i<alphabets.size(); i++){
                Alphabet temp = alphabets.get(i);
                if(isNotZero.isEmpty() || !isNotZero.contains(temp.c)){
                    alphabets.remove(i);
                    alphabetCount++;
                    break;
                }
            }
        }

        for(int i=0; i<alphabets.size(); i++){
            Alphabet temp = alphabets.get(i);
            result = result.add(temp.count.multiply(BigInteger.valueOf(alphabetCount)));
            alphabetCount++;
        }

        bw.write(result+"");
        bw.flush();

    }

}
