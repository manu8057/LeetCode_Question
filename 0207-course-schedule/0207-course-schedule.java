class Solution {
    public boolean canFinish(int n, int[][] arr) {
        int fr[]=new int[n];
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int  i=0;i<n;i+=1){
            adj.add(new ArrayList<>());
        }
        for(int ar[]:arr){
            adj.get(ar[1]).add(ar[0]);
            fr[ar[0]]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i+=1){
            if(fr[i]==0){
                q.add(i);
            }
        }
        int c=0;
        while(!q.isEmpty()){
            int u=q.poll();
            c+=1;
            for(int el:adj.get(u)){
                fr[el]--;
                if(fr[el]==0){
                    q.add(el);
                }
            }
        }
        return c==n;
    }
}