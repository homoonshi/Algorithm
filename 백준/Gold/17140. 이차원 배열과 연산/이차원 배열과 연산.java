
import java.util.*;
import java.io.*;

public class Main {

    static int r,c,k;
    static int[][] map = new int[101][101];
    static int[][] numCount = new int[100][2];

    static int col;
    static int row;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        r = Integer.parseInt(input[0]); // r 행
        c = Integer.parseInt(input[1]); // c 열
        k = Integer.parseInt(input[2]); // k 찾을 숫자 == map[r][c] = k 면 끝

        for(int i=1; i<=3; i++){
            input = br.readLine().split(" ");
            for(int j=1; j<=3; j++){
                map[i][j]=Integer.parseInt(input[j-1]);
            }
        }

        boolean check = false;
        int res=0;
        col = 3; // 행 왼오른
        row = 3; // 열 위아래

        if(map[r][c]==k){
            bw.write(res+"");
            bw.flush();
            return;
        }

        for(int i=1; i<=100; i++){
            if(col<=row){
                R();
            }else{
                C();
            }
            if(map[r][c]==k){
                res = i;
                check = true;
                break;
            }
        }

        if(!check){
            res=-1;
        }

        bw.write(res+"");
        bw.flush();
    }

    public static void R(){

        int num;
        int size = col;
        col=0;

        for(int i=1; i<=row; i++){
            for(int j=1; j<=size; j++){
               num = map[i][j];
               if(num==0) continue;
               numCount[num-1][0]++;
               numCount[num-1][1]=num;
               map[i][j]=0;
            }
            Arrays.sort(numCount, (o1,o2)-> o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);
            int currentCol=0;

            for(int j=1; j<=100; j++){
                if(numCount[j-1][0]==0) {
                    numCount[j-1][1]=j;
                    continue;
                }
                currentCol++;
                map[i][currentCol++]=numCount[j-1][1];
                map[i][currentCol]=numCount[j-1][0];
                numCount[j-1][0]=0;
                numCount[j-1][1]=j;
            }

            col = Math.max(col,currentCol);

        }

    }

    public static void C(){

        int num;
        int size = row;
        row = 0;

        for(int i=1; i<=col; i++){
            for(int j=1; j<=size; j++){
                num = map[j][i];
                if(num==0) continue;
                numCount[num-1][1]=num;
                numCount[num-1][0]++;
                map[j][i]=0;
            }

            int currentRow = 0;
            Arrays.sort(numCount, (o1,o2)-> o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);

            for(int j=1; j<=100; j++){
                if(numCount[j-1][0]==0) {
                    numCount[j-1][1]=j;
                    continue;
                }
                currentRow++;
                map[currentRow++][i]=numCount[j-1][1];
                map[currentRow][i]=numCount[j-1][0];
                numCount[j-1][0]=0;
                numCount[j-1][1]=j;
            }

            row = Math.max(row, currentRow);

        }
    }

}