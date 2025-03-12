
import java.io.*;
import java.util.*;

public class Main {

    static Map<Integer, String> rom;
    static Map<Character, Integer> arab;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        rom = new HashMap<>();
        arab = new HashMap<>();

        init();

        String a = br.readLine();
        String b = br.readLine();

        int ai = changeToArab(a);
        int bi = changeToArab(b);

        bw.write(ai + bi+"\n");

        String res = changeToRom(ai+bi);
        bw.write(res);

        bw.flush();

    }

    public static String changeToRom(int arab){

        StringBuilder sb = new StringBuilder();
        int start = 1000;

        for(int i=0; i<4; i++){
            int num = arab/start;
            if(num>0) {
                String s = rom.get(num*start);
                sb.append(s);
                arab-=(num*start);
            }
            start/=10;
        }
        return sb.toString();
    }

    public static int changeToArab(String rom){

        int result = 0;

        for(int i=0; i<rom.length(); i++){

            char c = rom.charAt(i);
            int cNum = arab.get(c);

            // 뒷 숫자가 나보다 큰 지 확인
            if(i+1<rom.length()){

                char n = rom.charAt(i+1);
                int nNum = arab.get(n);

                // 크면 빼서 더하기
                if(cNum<nNum){
                    result += (nNum - cNum);
                    i+=1;
                    continue;
                }

            }

            result += cNum;

        }

        return result;
    }

    public static void init(){

        rom.put(900, "CM");
        rom.put(400, "CD");
        rom.put(90, "XC");
        rom.put(40, "XL");
        rom.put(9, "IX");
        rom.put(4, "IV");

        rom.put(1, "I");
        rom.put(5, "V");
        rom.put(10, "X");
        rom.put(50, "L");
        rom.put(100, "C");
        rom.put(500, "D");
        rom.put(1000, "M");

        arab.put('I', 1);
        arab.put('V', 5);
        arab.put('X', 10);
        arab.put('L', 50);
        arab.put('C', 100);
        arab.put('D', 500);
        arab.put('M', 1000);

        rom.put(3, "III");
        rom.put(30, "XXX");
        rom.put(300, "CCC");
        rom.put(3000, "MMM");

        rom.put(2, "II");
        rom.put(20, "XX");
        rom.put(200, "CC");
        rom.put(2000, "MM");

        rom.put(6, "VI");
        rom.put(60, "LX");
        rom.put(600, "DC");

        rom.put(7, "VII");
        rom.put(70, "LXX");
        rom.put(700, "DCC");

        rom.put(8, "VIII");
        rom.put(80, "LXXX");
        rom.put(800, "DCCC");

    }

}
