class Solution {
    public int numberOfSpecialChars(String word) {
        int arr[]=new int[26];
        boolean vis[]=new boolean[26];
        int ans[]=new int[26];
        int cp[]=new int[26];
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if((int)ch>=97){
                if(ans[ch-'a']>0){
                    ans[ch-'a']=0;
                }
                if(cp[ch-'a']>=1){
                    vis[ch-'a']=true;
                }
                arr[ch-'a']++;
            }
            else{
                if(arr[(ch+32-'a')]>=1 && !vis[(ch+32-'a')]){
                    vis[(ch+32-'a')]=true;
                    ans[ch+32-'a']++;
                }
                cp[ch+32-'a']++;
            }
        }
        int res=0;
        for(int i:ans){
            res+=i;
        }
        return res;
    }
}