class Solution {
    
    static int start, end, current, len;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        start = changeTime(op_start.split(":"));
        end = changeTime(op_end.split(":"));
        current = changeTime(pos.split(":"));
        len = changeTime(video_len.split(":"));
        
        skipOpening();
        
        for(int i=0; i<commands.length; i++){
            String com = commands[i];
            
            if(com.equals("prev")){
                current -= 10;
                if(current<0){
                    current = 0;
                }
            }else{
                current += 10;
                if(current>len){
                    current = len;
                }
            }
            
            skipOpening();
        }
        
        StringBuilder sb = new StringBuilder("");
        
        int m = current/60;
        
        if(m<10){
            sb.append("0"+m);
        }else{
            sb.append(m);
        }
        
        sb.append(":");
        
        int s = current%60;
        
        if(s<10){
            sb.append("0"+s);
        }else{
            sb.append(s);
        }
        
        return sb.toString();
    }
    
    public static int changeTime(String[] time){
        return Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
    }
    
    public static void skipOpening(){
        if(start<=current && current<=end){
            current = end;
        }
    }
}