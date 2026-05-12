class Solution{
    public int minimumEffort(int[][] tasks){
        Arrays.sort(tasks,(a,b)->(b[1]-b[0])-(a[1]-a[0]));
        long ans=0;
        long e=0;
        for(int i=0;i<tasks.length;i++){
            int a=tasks[i][0];
            int m=tasks[i][1];
            if(e<m){
                ans+=(m-e);
                e=m;
            }
            e-=a;
        }
        return (int)ans;
    }
}