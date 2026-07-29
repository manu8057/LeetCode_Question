class Solution {
    public boolean canConstruct(String s, int k) {
        int fr[]=new int[26];
        int n=s.length();
        if(n<k) return false;
        for(int i=0;i<n;i+=1){
            fr[s.charAt(i)-'a']++;
        }
        int c=0;
        for(int i=0;i<26;i+=1){
            if(fr[i]%2==1){
                k-=1;
            }
        }
        return k>=0;
    }
}