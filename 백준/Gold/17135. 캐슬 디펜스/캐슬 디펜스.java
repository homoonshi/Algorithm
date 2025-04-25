
import java.io.*;
import java.util.*;

public class Main {

    static int[][] enemies;
    static int[][] copyEnemies;
    static int[] archers = new int[3];
    static int N, M, D;
    static int result;

    public static void main(String[] args) throws IOException{
        inputs();
        result = 0;
        archerDispatch(0, 0);
        System.out.println(result);
    }


    // 궁수와 적 입력
    public static void inputs() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        D = Integer.parseInt(input[2]);

        enemies = new int[N][M];
        copyEnemies = new int[N][M];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                enemies[i][j]=Integer.parseInt(input[j]);
            }
        }
    }

    // 궁수 경우의 수
    public static void archerDispatch(int count, int n){
        if(count==3){
            for(int i = 0; i < N; i++) {
                System.arraycopy(enemies[i], 0, copyEnemies[i], 0, M);
            }
            result = Math.max(result, archerAttack());
            return;
        }
        for (int i = n; i < M; i++) {
            archers[count] = i;
            archerDispatch(count+1, i+1);
        }
    }

    // 궁수 round 시작
    public static int archerAttack(){
        int res = 0;
        for(int round = 1; round<=N; round++){
            res += roundAttack(round);
        }
        return res;
    }

    // round 과정 + 적들 거리 구하기
    public static int roundAttack(int round){
        List<int[]>[][] roundEnemy = new List[3][D+1];
        for(int i=0; i<3; i++){
            for(int j=1; j<=D; j++){
                roundEnemy[i][j] = new ArrayList<>();
            }
        }

        int archerN = N-round+1;
        int n = archerN-1;
        while(n>=0&&n>=(archerN-D)){
            for(int m=0; m<M; m++) {
                for (int i = 0; i < 3; i++) {
                    if(copyEnemies[n][m]==1) {
                        int distance = enemyDistance(new int[]{n, m}, new int[]{archerN, archers[i]});
                        if (distance <= D) {
                            roundEnemy[i][distance].add(new int[]{n, m});
                        }
                    }
                }
            }
            n--;
        }

        return attackEnemy(roundEnemy);
    }

    // 궁수와 적의 거리 계산
    public static int enemyDistance(int[] enemy, int[] archer){
        return Math.abs(enemy[0]-archer[0]) + Math.abs(enemy[1]-archer[1]);
    }

    // 공격 대상 타겟 + 공격한 적 계산
    public static int attackEnemy(List<int[]>[][] roundEnemy){
        int res = 0;
        for(int i=0; i<3; i++){
            for(int j=1; j<=D; j++){
                int size = roundEnemy[i][j].size();
                if(size==0){
                    continue;
                }
                Collections.sort(roundEnemy[i][j], Comparator.comparingInt(o -> o[1]));
                for(int k=0; k<size; k++) {
                    int[] e = roundEnemy[i][j].get(k);
                    if(copyEnemies[e[0]][e[1]]==1){
                        copyEnemies[e[0]][e[1]]=0;
                        res++;
                    }
                    break;
                }
                break;
            }
        }
        return res;
    }

}