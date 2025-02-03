import java.io.*;
import java.util.*;

public class Main {

    static Deque<Character> operator;
    static Deque<Integer> nums;

    static Map<String, Integer> words;
    static Map<Integer, String> math;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        operator = new ArrayDeque<>();
        nums = new ArrayDeque<>();

        boolean isOperator = true;
        StringBuilder sb = new StringBuilder();
        StringBuilder num = new StringBuilder();

        words = new HashMap<>();
        math = new HashMap<>();

        insertWord();

        for(int i=0; i<input.length(); i++){

            char c = input.charAt(i);

            boolean check = checkOperator(c);

            if(isOperator && check) {
                bw.write("Madness!");
                bw.flush();
                return;
            }

            isOperator = check;

            if(isOperator){
                if(sb.length() > 0 || num.length() == 0){
                    bw.write("Madness!");
                    bw.flush();
                    return;
                }
                nums.add(Integer.parseInt(num.toString()));
                num = new StringBuilder();
                continue;
            }

            sb.append(c);

            if(words.containsKey(sb.toString())){
                num.append(words.get(sb.toString()));
                sb = new StringBuilder();
            }

        }

        if(sb.length() > 0 || num.length() > 0 || nums.isEmpty() || nums.size() != operator.size()){
            bw.write("Madness!");
            bw.flush();
            return;
        }

        long res = nums.pollFirst();
        int count = 0;
        char operate = ' ';

        StringBuilder resStr = new StringBuilder(String.valueOf(res));

        while(!operator.isEmpty() || !nums.isEmpty()){
            if(!operator.isEmpty() && count%2==0){
                operate = operator.pollFirst();
                if(operate == '=') {
                    if (!operator.isEmpty()) {
                        bw.write("Madness!");
                        bw.flush();
                        return;
                    }
                }
                resStr.append(operate);
                count++;
            }else if(!nums.isEmpty() && count%2==1){
                long next = nums.pollFirst();
                resStr.append(next);
                if(operate=='+'){
                    res+=next;
                }else if(operate=='-'){
                    res-=next;
                }else if(operate=='x'){
                    res*=next;
                }else if(operate=='/'){
                    if(next==0){
                        bw.write("Madness!");
                        bw.flush();
                        return;
                    }
                    if(res < 0){
                        res = Math.abs(res);
                        res /= next;
                        res *= (-1);
                    }else {
                        res /= next;
                    }
                }else if(operate=='='){
                    bw.write("Madness!");
                    bw.flush();
                    return;
                }
                count++;
            }else{
                bw.write("Madness!");
                bw.flush();
                return;
            }
        }

        if(count%2==0 || operate != '='){
            bw.write("Madness!");
            bw.flush();
            return;
        }

        bw.write(resStr+"\n");

        resStr = new StringBuilder();

        if(res<0){
            resStr.append("-");
        }

        res = Math.abs(res);
        String str = String.valueOf(res);

        for(int i=0; i<str.length(); i++){
            int n = str.charAt(i) - '0';
            resStr.append(math.get(n));
        }

        bw.write(resStr.toString());
        bw.flush();

    }

    public static void insertWord() {
        words.put("ZERO", 0);
        words.put("ONE", 1);
        words.put("TWO", 2);
        words.put("THREE", 3);
        words.put("FOUR", 4);
        words.put("FIVE", 5);
        words.put("SIX", 6);
        words.put("SEVEN", 7);
        words.put("EIGHT", 8);
        words.put("NINE", 9);

        math.put(0, "ZERO");
        math.put(1, "ONE");
        math.put(2, "TWO");
        math.put(3, "THREE");
        math.put(4, "FOUR");
        math.put(5, "FIVE");
        math.put(6, "SIX");
        math.put(7, "SEVEN");
        math.put(8, "EIGHT");
        math.put(9, "NINE");
    }

    public static boolean checkOperator(char c){
        if(c=='+' || c=='-' || c=='x' || c=='/' || c=='='){
            operator.add(c);
            return true;
        }
        return false;
    }
}