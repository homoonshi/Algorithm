class Solution {
    
    int[][] map;
    
    public int[] solution(int[][] arr) {
        int[] answer = {};
        
        map = new int[arr.length][arr.length];
        map = arr;
        
        answer = quard(0, 0, (arr.length)/2);
        
        return answer;
    }
    
    public int[] quard(int sx, int sy, int size){
        
        int[] result = new int[2];
        int[] temp;
        
        int[] nx = {sx, sx+size, sx, sx+size};
        int[] ny = {sy, sy, sy+size, sy+size};
        
        int[] pass = new int[2];
        
        if(size!=1){
            
            for(int i=0; i<4; i++){
                temp = quard(nx[i], ny[i], size/2);
                
                if(temp[0]==1 && temp[1]==0){
                    pass[0]++;
                }else if(temp[0]==0 && temp[1]==1){
                    pass[1]++;
                }
                
                result[0] += temp[0];
                result[1] += temp[1];
            }
            
            if(pass[0]==4){
                result[0]=1;
                result[1]=0;
            }else if(pass[1]==4){
                result[0]=0;
                result[1]=1;
            }
            
        }else{
            
            for(int i=0; i<4; i++){
                if(map[nx[i]][ny[i]]==0){
                    result[0]++;
                }else{
                    result[1]++;
                }
            }
            
            if(result[0]==4){
                result[0]=1;
                result[1]=0;
            }else if(result[1]==4){
                result[0]=0;
                result[1]=1;
            }
            
        }
        
        return result;
    }
    
}