class Solution {
    public String processStr(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z'){
                sb.append(ch);
            }
            else if(ch=='*'){
                if(sb.length()>=1){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            else if(ch=='#'){
                sb.append(sb.toString());
            }
            else{
                sb.reverse();
            }
        }
        return sb.toString();
    }
}