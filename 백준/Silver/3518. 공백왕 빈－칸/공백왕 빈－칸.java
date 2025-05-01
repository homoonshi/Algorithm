
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        List<List<String>> lists = new ArrayList<>();
        int count = 0;

        while((line = br.readLine()) != null && !line.isEmpty()){

            StringTokenizer st = new StringTokenizer(line, " ");

            List<String> temp = new ArrayList<>();

            int c = 0;

            while(st.hasMoreTokens()) {
                temp.add(st.nextToken());
                c++;
            }

            lists.add(temp);
            count = Math.max(count, c);

        }

        StringBuffer[] sb = new StringBuffer[lists.size()];
        for(int i=0; i<lists.size(); i++){
            sb[i] = new StringBuffer("");
        }

        for(int i=0; i<count; i++) {
            int size = 0;
            for (int j = 0; j < lists.size(); j++) {
                if(lists.get(j).size()>i){
                    size = Math.max(size, lists.get(j).get(i).length());
                }
            }
            for (int j = 0; j < lists.size(); j++){
                if(lists.get(j).size()>i){
                    int len = lists.get(j).get(i).length();
                    sb[j].append(lists.get(j).get(i));
                    if(lists.get(j).size()-1 != i) {
                        if (len == size) {
                            sb[j].append(" ");
                        } else {
                            StringBuffer s = new StringBuffer(" ");
                            for (int k = 0; k < (size - len); k++) {
                                s.append(" ");
                            }
                            sb[j].append(s);
                        }
                    }
                }
            }
        }

        for(int i=0; i<lists.size(); i++){
            bw.write(sb[i].toString()+"\n");
        }

        bw.flush();

    }
}