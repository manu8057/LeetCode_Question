class Solution {
    public int minJumps(int[] nums) {
        int n=nums.length;
        int mx=0;
        for(int x:nums){
            mx=Math.max(mx,x);
        }
        boolean[] prime=new boolean[mx+1];
        Arrays.fill(prime,true);
        if(mx>=0)prime[0]=false;
        if(mx>=1)prime[1]=false;
        for(long i=2;i*i<=mx;i++){
            if(prime[(int)i]){
                for(long j=i*i;j<=mx;j+=i){
                    prime[(int)j]=false;
                }
            }
        }
        ArrayList<Integer>[] pos=new ArrayList[mx+1];
        for(int i=0;i<=mx;i++){
            pos[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            pos[nums[i]].add(i);
        }
        Queue<int[]> q=new LinkedList<>();
        int[] vis=new int[n];
        vis[0]=1;
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int[] it=q.poll();
            int idx=it[0];
            int dist=it[1];
            if(idx==n-1)return dist;
            if(idx+1<n&&vis[idx+1]==0){
                vis[idx+1]=1;
                q.offer(new int[]{idx+1,dist+1});
            }
            if(idx-1>=0&&vis[idx-1]==0){
                vis[idx-1]=1;
                q.offer(new int[]{idx-1,dist+1});
            }
            if(prime[nums[idx]]){
                int p=nums[idx];
                for(int i=p;i<=mx;i+=p){
                    for(int j:pos[i]){
                        if(vis[j]==0){
                            vis[j]=1;
                            q.offer(new int[]{j,dist+1});
                        }
                    }
                    pos[i].clear();
                }
                prime[p]=false;
            }
        }
        return n-1;
    }
}