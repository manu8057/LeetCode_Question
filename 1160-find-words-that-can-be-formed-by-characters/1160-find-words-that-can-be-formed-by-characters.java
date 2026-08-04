class Solution {
    public boolean fun(int ar[],int fr[]){
        for(int i=0;i<26;i+=1){
            if(fr[i]-ar[i]<0){
                return false;
            }
        }
        return true;
    }
    public int countCharacters(String[] words, String chars) {
        int n=chars.length();
        int fr[]=new int[26];
        for(int i=0;i<n;i++){
            fr[chars.charAt(i)-'a']++;
        }
        int ans=0;
        for(String w:words){
            int ar[]=new int[26];
            for(int i=0;i<w.length();i+=1){
                ar[w.charAt(i)-'a']++;
            }
            if(fun(ar,fr)){
                ans+=w.length();
            }
        }
        return ans;
    }
}