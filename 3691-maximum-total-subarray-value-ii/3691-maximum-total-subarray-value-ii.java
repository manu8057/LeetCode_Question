class Solution {
    int[][] mx;
    int[][] mn;
    int[] lg;
    long val(int l,int r){
        int len=r-l+1;
        int p=lg[len];
        int a=Math.max(
            mx[p][l],
            mx[p][r-(1<<p)+1]
        );
        int b=Math.min(
            mn[p][l],
            mn[p][r-(1<<p)+1]
        );
        return (long)(a-b);
    }
    public long maxTotalValue(int[] nums,int k){
        int n=nums.length;

        lg=new int[n+1];

        for(int i=2;i<=n;i++){
            lg[i]=lg[i/2]+1;
        }
        int m=lg[n]+1;
        mx=new int[m][n];
        mn=new int[m][n];
        for(int i=0;i<n;i++){
            mx[0][i]=nums[i];
            mn[0][i]=nums[i];
        }
        for(int j=1;j<m;j++){
            for(int i=0;i+(1<<j)<=n;i++){
                mx[j][i]=Math.max(
                    mx[j-1][i],
                    mx[j-1][i+(1<<(j-1))]
                );
                mn[j][i]=Math.min(
                    mn[j-1][i],
                    mn[j-1][i+(1<<(j-1))]
                );
            }
        }
        PriorityQueue<long[]> pq=new PriorityQueue<>(
            (x,y)->Long.compare(y[0],x[0])
        );
        for(int l=0;l<n;l++){
            pq.offer(new long[]{val(l,n-1),l,n-1});
        }
        long ans=0;
        while(k-->0){
            long[] t=pq.poll();
            long v=t[0];
            int l=(int)t[1];
            int r=(int)t[2];

            ans+=v;

            if(r>l){
                pq.offer(new long[]{val(l,r-1),l,r-1});
            }
        }
        return ans;
    }
}