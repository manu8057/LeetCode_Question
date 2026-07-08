class Solution {
    public int fun(int arr[]){
        int max=0;
        for(int i=0;i<26;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
    public int characterReplacement(String s, int k) {
        int fr[]=new int[26];
        int n=s.length();
        int ans=0;
        int max=0;
        int j=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            fr[ch-'a'+32]++;
            cnt++;
            while(cnt-fun(fr)>k){
                fr[s.charAt(j)-'a'+32]--;
                j++;
                cnt--;
            }
            ans=Math.max(ans,i-j+1);
        }
        return ans;
    }
}