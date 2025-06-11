
import java.io.*;
import java.util.*;

public class Main {

    static String st, boom;
    static Deque<Character> s;
    static Deque<Character> end;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = br.readLine();

        s = new ArrayDeque<>();

        for(int i=0; i<st.length(); i++) {
            s.add(st.charAt(i));
        }

        boom = br.readLine();
        end = new ArrayDeque<>();

        confirm();

        if(end.isEmpty()){
            bw.write("FRULA");
        }else {
            while(!end.isEmpty()){
                bw.write(end.pollFirst()+"");
            }
        }
        bw.flush();

    }

    public static void confirm() {

        Deque<Character> temp = new ArrayDeque<>();
        int index = 0;

        while(!s.isEmpty()){

            Character c = s.pollFirst();

            if(c==boom.charAt(index)){
                temp.add(c);
                index++;
                if(boom.length() == index){
                    temp.clear();
                    index = 0;
                    for(int i=0; i<boom.length()-1; i++){
                        if(end.isEmpty()){
                            break;
                        }
                        Character t = end.pollLast();
                        if(t==boom.charAt(0)){
                            temp.add(t);
                            index = 1;
                            break;
                        }else{
                            s.addFirst(t);
                        }
                    }
                }
            }else {
                index = 0;
                while(!temp.isEmpty()){
                    end.add(temp.pollFirst());
                }
                if(c!=boom.charAt(index)) {
                    end.add(c);
                }else{
                    temp.add(c);
                    index++;
                }
            }

        }

        while(!temp.isEmpty()){
            end.add(temp.pollFirst());
        }

    }

}