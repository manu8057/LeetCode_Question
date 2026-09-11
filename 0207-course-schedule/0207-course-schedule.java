class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i+=1){
            adj.add(new ArrayList<>());
        }
        int fr[]=new int[n];
        for(int ar[]:prerequisites){
            int u=ar[0];
            int v=ar[1];
            fr[u]++;
            adj.get(v).add(u);
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i+=1){
            if(fr[i]==0){
                q.add(i);
            }
        }
        int c=0;
        while(!q.isEmpty()){
            int x=q.poll();
            c+=1;
            for(int el:adj.get(x)){
                fr[el]--;
                if(fr[el]==0){
                    q.add(el);
                }
            }
        }
        return c==n;
    }
}