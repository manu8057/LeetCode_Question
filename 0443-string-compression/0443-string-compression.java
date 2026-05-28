class Solution{
    public int compress(char[] chars){
        StringBuilder sb=new StringBuilder();
        int n=chars.length,c=1;
        char x=chars[0];
        for(int i=1;i<n;i++){
            char ch=chars[i];
            if(ch!=x){
                sb.append(x);
                if(c>1){
                    sb.append(c);
                }
                c=1;
                x=ch;
            }
            else{
                c++;
            }
        }
        sb.append(x);
        if(c>1){
            sb.append(c);
        }
        String s=sb.toString();
        for(int i=0;i<s.length();i++){
            chars[i]=s.charAt(i);
        }
        return s.length();
    }
}