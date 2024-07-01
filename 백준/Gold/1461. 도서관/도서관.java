
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<Integer> booksPosi;
    static List<Integer> booksNega;
    static int numPosi;
    static int numNega;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        booksPosi = new ArrayList<>();
        booksNega = new ArrayList<>();
        numPosi = 0;
        numNega = 0;

        input = br.readLine().split(" ");

        for(int i=0; i<N; i++){

            int num = Integer.parseInt(input[i]);

            if(num<0){
                booksNega.add(numNega++,num);
            }else{
                booksPosi.add(numPosi++,num);
            }

        }

        Collections.sort(booksNega,Collections.reverseOrder());
        Collections.sort(booksPosi);

        int result = order();

        bw.write(result+"");

        bw.flush();

    }

    public static int order(){

        int res = 0;

        int maxNega = booksNega.size();
        int maxPosi = booksPosi.size();

        int numBook = 0;
        int numNega = 0;
        int numPosi = 0;

        int disNega = Integer.MAX_VALUE;
        int disPosi = Integer.MAX_VALUE;

        int current = 0;
        int currentNega = 0;
        int currentPosi = 0;

        while(numBook<maxNega+maxPosi) {

            res += current;

            disNega = Integer.MAX_VALUE;
            disPosi = Integer.MAX_VALUE;

            if(maxNega!=numNega&&numNega==0){
                if(maxNega%M==0){
                    disNega = Math.abs(booksNega.get(M-1));
                    currentNega = M;
                }else{
                    disNega = Math.abs(booksNega.get(maxNega%M-1));
                    currentNega = maxNega%M;
                }
            }else if(maxNega!=numNega){
                disNega = Math.abs(booksNega.get(numNega+M-1));
                currentNega = M;
            }

            if(maxPosi!=numPosi&&numPosi==0){
                if(maxPosi%M==0){
                    disPosi = Math.abs(booksPosi.get(M-1));
                    currentPosi = M;
                }else{
                    disPosi = Math.abs(booksPosi.get(maxPosi%M-1));
                    currentPosi = maxPosi%M;
                }
            }else if(maxPosi!=numPosi){
                disPosi = Math.abs(booksPosi.get(numPosi+M-1));
                currentPosi = M;
            }

            if(disPosi<disNega){
                res += disPosi;
                current = disPosi;
                numPosi += currentPosi;
                numBook += currentPosi;
            }else{
                res += disNega;
                current = disNega;
                numNega += currentNega;
                numBook += currentNega;
            }

        }

        return res;
    }

}
