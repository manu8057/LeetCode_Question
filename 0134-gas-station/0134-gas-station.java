class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int ans=0;
        int t=0;
        int y=0;
        for(int i=0;i<n;i++){
            int d=gas[i]-cost[i];
            t+=d;
            y+=d;
            if(y<0){
                ans=i+1;
                y=0;
            }
        }
        if(t<0) return -1;
        return ans;
    }
}