class Solution {
    public int numberOfSpecialChars(String word) {
        int arr[]=new int[26];
        boolean vis[]=new boolean[26];
        int ans=0;
        int cp[]=new int[26];
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(ch>=97){
                if(cp[ch-'a']>0 && !vis[ch-'a']){
                    ans++;
                    vis[ch-'a']=true;
                }
                arr[ch-'a']++;
            }
            else{
                if(arr[ch+32-'a']>0 && !vis[ch+32-'a']){
                    vis[ch+32-'a']=true;
                    ans++;
                }
                cp[ch+32-'a']++;
            }
        }
        return ans;
    }
}