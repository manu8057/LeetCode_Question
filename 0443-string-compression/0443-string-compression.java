class Solution{
    public int compress(char[] chars){
        int n=chars.length,i=0,k=0;
        while(i<n){
            char ch=chars[i];
            int c=0;
            while(i<n&&chars[i]==ch){
                i++;
                c++;
            }
            chars[k++]=ch;
            if(c>1){
                String s=c+"";
                for(char x:s.toCharArray()){
                    chars[k++]=x;
                }
            }
        }
        return k;
    }
}