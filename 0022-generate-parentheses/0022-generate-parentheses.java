class Solution {
    public void fun(int n,List<String>l,String s,int op){
        if(s.length()==n*2){
            if(op==0){
                l.add(s);
            }
            return;
        }
        if(op==0){
            fun(n,l,s+'(',op+1);
        }
        else if(op>0){
            fun(n,l,s+'(',op+1);
            fun(n,l,s+')',op-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>l=new ArrayList<>();
        fun(n,l,"",0);
        return l;
    }
}