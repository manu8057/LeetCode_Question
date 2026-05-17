class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        boolean vis[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        vis[0]=true;
        int f=0;
        while(!q.isEmpty()){
            int id=q.poll();
            if(id==n-1){
                return true;
            }
            int st=Math.max(id+minJump,f+1);
            int end=Math.min(id+maxJump,n-1);
            for(int i=st;i<=end;i++){
                if(s.charAt(i)=='0' && !vis[i]){
                    vis[i]=true;
                    q.offer(i);
                }
            }
            f=end;
        }
        return false;
    }
}