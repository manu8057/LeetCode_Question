class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int fr[]=new int[n];
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i+=1){
            adj.add(new ArrayList<>());
        }
        int id=0;
        for(int ar[]:graph){
            fr[id]=ar.length;
            for(int el:ar){
                adj.get(el).add(id);
            }
            id++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i+=1){
            if(fr[i]==0){
                q.add(i);
            }
        }
        List<Integer>l=new ArrayList<>();
        while(!q.isEmpty()){
            int u=q.poll();
            l.add(u);
            for(int el:adj.get(u)){
                fr[el]--;
                if(fr[el]==0){
                    q.add(el);
                }
            }
        }
       Collections.sort(l);
       return l;
    }
}