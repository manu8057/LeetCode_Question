class Solution {
    public String fun(int n,String s){
        if(n==0){
            return s;
        }
        StringBuilder str=new StringBuilder();
        int i=0;
        int len=s.length();
        while(i<len){
            int c=1;
            char ch=s.charAt(i);
            while(i<len-1 && s.charAt(i)==s.charAt(i+1)){
                c++;
                i++;
            }
            str.append(c);
            str.append(ch);
            i++;
        }
        return fun(n-1,str.toString());
    }
    public String countAndSay(int n) {
        return fun(n-1,"1");
    }
}