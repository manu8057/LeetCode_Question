class Solution {
    public String getSmallestString(String s, int k) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(k==0){
                sb.append(ch);
                continue;
            }
            int a=ch-'a';
            int j=Math.min(a,26-a);
            if(j<=k){
                sb.append('a');
                k-=j;
            }
            else{
                char el=(char)(ch-k);
                if(el<'a'){
                    el=(char)('z'-('a'-el-1));
                }
                sb.append(el);
                k=0;
            }
        }
        return sb.toString();
    }
}