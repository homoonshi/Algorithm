class Solution {
    
    static long[] time_prev;
    
    public int solution(int[] diffs, int[] times, long limit) {
        int current = 0;
        
        int n = diffs.length;
        
        time_prev = new long[n];
        time_prev[0] = times[0];
        
        int start = 1;
        int end = diffs[0];
        
        for(int i=1; i<n; i++){
            time_prev[i] = times[i] + times[i-1];
            end = Math.max(end, diffs[i]);
        }
        
        base : while(start<=end){
            
            long res = 0;
            int mid = (start+end)/2;
            
            for(int i=0; i<n; i++){
                if(mid<diffs[i]){
                    res += time_prev[i] * (diffs[i]-mid) + times[i];
                }else{
                    res += times[i];
                }
                if(res>limit || res < 0){
                    start = mid+1;
                    continue base;
                }
            }
            
            end = mid-1;
        }
        
        return start;
    }
}