class Solution {
    public int[] findOrder(int n, int[][] arr){
        int len=arr.length;
        int ans[]=new int[n];
        Queue<Integer>q=new LinkedList<>();
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int fr[]=new int[n];
        for(int ar[]:arr){
            adj.get(ar[1]).add(ar[0]);
            fr[ar[0]]++;
        }
        for(int i=0;i<n;i++){
            if(fr[i]==0){
                q.add(i);
            }
        }
        if(q.size()==0){
            return new int[]{};
        }
        int id=0;
        while(!q.isEmpty()){
            int y=q.poll();
            ans[id++]=y;
            for(int el:adj.get(y)){
                fr[el]--;
                if(fr[el]==0){
                    q.add(el);
                }
            }
        }
        if(id!=n){
            return new int[]{};
        }
        return ans;
    }
}