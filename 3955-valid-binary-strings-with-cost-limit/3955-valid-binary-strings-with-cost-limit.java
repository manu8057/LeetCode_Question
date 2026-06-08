class Solution {
    public void fun(int n,int k,String s,List<String>l,int c,char pre,int cost){
        if(s.length()==n){
            if(cost<=k){
                l.add(s);
            }
            return;
        }
        if(pre=='1'){
            fun(n,k,s+'0',l,c+1,'0',cost);
        }
        else{
            if(cost+c>k){
                fun(n,k,s+'0',l,c+1,'0',cost);
            }
            else{
                fun(n,k,s+'1',l,c+1,'1',cost+c);
                fun(n,k,s+'0',l,c+1,'0',cost);
            }
        }
    }
    public List<String> generateValidStrings(int n, int k) {
        List<String>l=new ArrayList<>();
        fun(n,k,"",l,0,'z',0);
        return l;
    }
}