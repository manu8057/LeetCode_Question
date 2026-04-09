class Solution {
    public void fun(int id,int n,String s,StringBuilder str,HashSet<String>set,boolean vis[]){
        if(id==n){
            if(str.length()>=1){
                set.add(str.toString());
            }
            return;
        }
        if(str.length()>=1){
            set.add(str.toString());
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                vis[i]=true;
                str.append(s.charAt(i));
                fun(id+1,n,s,str,set,vis);
                str.deleteCharAt(str.length()-1);
                vis[i]=false;
            }
        }
    }
    public int numTilePossibilities(String tiles) {
        int n=tiles.length();
        HashSet<String>set=new HashSet<>();
        boolean vis[]=new boolean[n];
        StringBuilder sb=new StringBuilder();
        fun(0,n,tiles,sb,set,vis);
        return set.size();
    }
}