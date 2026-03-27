class Solution {
    public void fun(List<String>l,String s,int n,char pre){
        if(s.length()==n){
            l.add(s);
            return;
        }
        if(pre=='7'){
            fun(l,s+'1',n,'1');
            fun(l,s+'0',n,'0');
        }
        else{
            if(pre=='0'){
               fun(l,s+'1',n,'1');
            }
            else{
                fun(l,s+'1',n,'1');
                fun(l,s+'0',n,'0');
            }
        }
    }
    public List<String> validStrings(int n) {
        List<String>l=new ArrayList<>();
        fun(l,"",n,'7');
        return l;
    }
}