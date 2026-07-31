class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        int n=graph.length;
        int fr[]=new int[n];
        for(int i=0;i<n;i+=1){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int el:graph[i]){
                fr[i]++;
                adj.get(el).add(i);
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
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