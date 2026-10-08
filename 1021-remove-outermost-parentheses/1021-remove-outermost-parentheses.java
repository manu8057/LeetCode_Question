class Solution {
    public String removeOuterParentheses(String s) {
        int op=0;
        int cl=0;
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        int st=0;
        for(int i=0;i<n;i+=1){
            char ch=s.charAt(i);
            if(ch=='(') op++;
            else cl++;
            if(op!=0 && cl!=0 && op==cl){
                sb.append(s.substring(st+1,i));
                op=0;
                cl=0;
                st=i+1;
            }
        }
        return sb.toString();
    }
}