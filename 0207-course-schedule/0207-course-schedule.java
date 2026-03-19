class Solution {
    public boolean canFinish(int num, int[][] arr) {
        int n=arr.length;
        if(n==0){
            return true;
        }
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<num;i++){
            adj.add(new ArrayList<>());
        }
        int f[]=new int[num];
        for(int ar[]:arr){
            adj.get(ar[1]).add(ar[0]);
            f[ar[0]]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<num;i++){
            if(f[i]==0){
                q.add(i);
            }
        }
        if(q.size()==0){
            return false;
        }
        ArrayList<Integer>l=new ArrayList<>();
        while(!q.isEmpty()){
            int el=q.poll();
            l.add(el);
            for(int x:adj.get(el)){
                f[x]--;
                if(f[x]==0){
                    q.add(x);
                }
            }
        }
        return l.size()==num;
    }
}