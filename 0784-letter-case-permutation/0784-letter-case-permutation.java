class Solution {
    List<String>l=new ArrayList<>();
    public void fun(int i,int n,String str,String s){
        if(i>=n){
            l.add(str);
            return;
        }
        if(!Character.isDigit(s.charAt(i))){
            char a=Character.toUpperCase(s.charAt(i));
            char b=Character.toLowerCase(s.charAt(i));
            fun(i+1,n,str+a,s);
            fun(i+1,n,str+b,s);
        }
        else{
            fun(i+1,n,str+s.charAt(i),s);
        }
    }
    public List<String> letterCasePermutation(String s) {
        fun(0,s.length(),"",s);
        return l;
    }
}