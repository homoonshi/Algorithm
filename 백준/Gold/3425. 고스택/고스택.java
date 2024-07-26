import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static Deque<Long> deque = new ArrayDeque<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input;

    while(true){

      Deque<String> command = new ArrayDeque<>();

      while(true){

        input = br.readLine();

        if(input.equals("")){
          continue;
        }

        if(input.equals("QUIT")){
          bw.flush();
          return;
        }

        if(input.equals("END")){
          break;
        }

        command.addLast(input);

      }

      N = Integer.parseInt(br.readLine());

      for(int i=0; i<N; i++){

        deque.clear();
        long num = Long.parseLong(br.readLine());
        deque.addLast(num);
        int size = command.size();

        if(command.isEmpty()){
          bw.write(deque.pollFirst()+"\n");
          continue;
        }

        for(int j=0; j<size; j++){

          String c = command.pollFirst();

          if(c.equals("POP")){
            if(!pop()){
              bw.write("ERROR\n");
              command.addLast(c);
              for(int m=j; m<size-1; m++){
                c = command.pollFirst();
                command.addLast(c);
              }
              break;
            }
          }else if(c.equals("INV")){
            if(!inversion()){
              bw.write("ERROR\n");
              command.addLast(c);
              for(int m=j; m<size-1; m++){
                c = command.pollFirst();
                command.addLast(c);
              }
              break;
            }
          }else if(c.equals("DUP")){
            if(!duplicate()){
              bw.write("ERROR\n");
              command.addLast(c);
              for(int m=j; m<size-1; m++){
                c = command.pollFirst();
                command.addLast(c);
              }
              break;
            }
          }else if(c.equals("SWP")){
            if(!swap()){
              bw.write("ERROR\n");
              command.addLast(c);
              for(int m=j; m<size-1; m++){
                c = command.pollFirst();
                command.addLast(c);
              }
              break;
            }
          }else if(c.equals("ADD")){
            if(!add()){
              bw.write("ERROR\n");
              command.addLast(c);
              for(int m=j; m<size-1; m++){
                c = command.pollFirst();
                command.addLast(c);
              }
              break;
            }
          }else if(c.equals("SUB")){
            if(!sub()){
              bw.write("ERROR\n");
              command.addLast(c);
              for(int m=j; m<size-1; m++){
                c = command.pollFirst();
                command.addLast(c);
              }
              break;
            }
          }else if(c.equals("MUL")){
            if(!mul()){
              bw.write("ERROR\n");
              command.addLast(c);
              for(int m=j; m<size-1; m++){
                c = command.pollFirst();
                command.addLast(c);
              }
              break;
            }
          }else if(c.equals("DIV")){
            if(!div()){
              bw.write("ERROR\n");
              command.addLast(c);
              for(int m=j; m<size-1; m++){
                c = command.pollFirst();
                command.addLast(c);
              }
              break;
            }
          }else if(c.equals("MOD")){
            if(!mod()){
              bw.write("ERROR\n");
              command.addLast(c);
              for(int m=j; m<size-1; m++){
                c = command.pollFirst();
                command.addLast(c);
              }
              break;
            }
          }else{
            String[] inputs = c.split(" ");
            save(Integer.parseInt(inputs[1]));
          }

          command.addLast(c);

          if(j==(size-1)){
            if(deque.size()==1) {
              bw.write(deque.pollFirst() + "\n");
            }else{
              bw.write("ERROR\n");
            }
          }

        }

      }

      bw.write("\n");

    }

  }

  public static void save(long x){
    deque.addLast(x);
  }

  public static boolean pop(){
    if(deque.isEmpty()){
      return false;
    }
    deque.pollLast();
    return true;
  }

  public static boolean inversion(){
    if(deque.isEmpty()){
      return false;
    }
    long x = deque.pollLast();
    x *= -1;
    deque.addLast(x);
    return true;
  }

  public static boolean duplicate(){
    if(deque.isEmpty()){
      return false;
    }
    long x = deque.peekLast();
    deque.addLast(x);
    return true;
  }

  public static boolean swap(){
    if(deque.isEmpty()||deque.size()==1){
      return false;
    }
    long x1 = deque.pollLast();
    long x2 = deque.pollLast();
    deque.addLast(x1);
    deque.addLast(x2);
    return true;
  }

  public static boolean add(){
    if(deque.isEmpty()||deque.size()==1){
      return false;
    }

    long x1 = deque.pollLast();
    long x2 = deque.pollLast();

    long result = x1+x2;

    if(Math.abs(result)>1000000000){
      return false;
    }

    deque.addLast(result);
    return true;
  }

  public static boolean sub(){
    if(deque.isEmpty()||deque.size()==1){
      return false;
    }
    long x1 = deque.pollLast();
    long x2 = deque.pollLast();

    long result = x2-x1;

    if(Math.abs(result)>1000000000){
      return false;
    }

    deque.addLast(result);
    return true;
  }

  public static boolean mul(){
    if(deque.isEmpty()||deque.size()==1){
      return false;
    }

    long x1 = deque.pollLast();
    long x2 = deque.pollLast();

    long result = x1*x2;

    if(Math.abs(result)>1000000000){
      return false;
    }

    deque.addLast((long)result);
    return true;
  }

  public static boolean div(){
    if(deque.isEmpty()||deque.size()==1){
      return false;
    }

    long x1 = deque.pollLast();
    long x2 = deque.pollLast();

    if(x1==0){
      return false;
    }

    long result = Math.abs(x2)/Math.abs(x1);
    int minus = 0;

    if(x2<0){
      minus++;
    }

    if(x1<0){
      minus++;
    }

    if(minus==1) {
      result *= -1;
    }

    deque.addLast(result);
    return true;
  }

  public static boolean mod(){
    if(deque.isEmpty()||deque.size()==1){
      return false;
    }

    long x1 = deque.pollLast();
    long x2 = deque.pollLast();

    if(x1==0){
      return false;
    }

    long result = x2%Math.abs(x1);

    deque.addLast(result);
    return true;
  }

}