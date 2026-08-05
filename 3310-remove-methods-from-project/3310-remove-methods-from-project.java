class Solution {
    public List<Integer> remainingMethods(int n,int k,int[][] invocations) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i+=1){
            adj.add(new ArrayList<>());
        }
        for(int ar[]:invocations){
            adj.get(ar[0]).add(ar[1]);
        }
        int mr[]=new int[n];
        Queue<Integer>q=new ArrayDeque<>();
        q.add(k);
        while(!q.isEmpty()){
            int u=q.poll();
            if(mr[u]==-1){
                continue;
            }
            mr[u]=-1;
            for(int el:adj.get(u)){
                if(mr[el]!=-1){
                    q.add(el);
                }
            }
        }
        for(int ar[]:invocations){
            if(mr[ar[0]]!=-1 && mr[ar[1]]==-1){
                List<Integer>l=new ArrayList<>();
                for(int i=0;i<n;i+=1){
                    l.add(i);
                }
                return l;
            }
        }
        List<Integer>l=new ArrayList<>();
        for(int i=0;i<n;i+=1){
            if(mr[i]!=-1){
                l.add(i);
            }
        }
        return l;
    }
}