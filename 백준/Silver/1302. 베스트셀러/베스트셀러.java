
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> directory = new HashMap<>();

        int maxBook = 1;
        String maxBookName = br.readLine();
        directory.put(maxBookName,1);

        for(int i=1; i<N; i++){

            String book = br.readLine();

            if(!directory.containsKey(book)){
                directory.put(book, 1);
                if(maxBook==1){
                    if(maxBookName.compareTo(book)>0){
                        maxBookName=book;
                    }
                }
                continue;
            }

            int num = directory.get(book) + 1;
            directory.put(book, num);

            if(maxBook<num){
                maxBookName = book;
                maxBook = num;
                continue;
            }

            if(maxBook==num){
                if(maxBookName.compareTo(book)>0) {
                    maxBookName = book;
                }
            }

        }

        bw.write(maxBookName);
        bw.flush();

    }

}
