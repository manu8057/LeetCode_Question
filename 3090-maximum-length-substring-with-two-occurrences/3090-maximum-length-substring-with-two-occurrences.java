class Solution {
    public boolean fun(int arr[]){
        for(int i=0;i<26;i+=1){
            if(arr[i]>2) return true;
        }
        return false;
    }
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int ans=0;
        int arr[]=new int[26];
        int j=0;
        for(int i=0;i<n;i+=1){
            arr[s.charAt(i)-'a']+=1;
            while(fun(arr)){
                arr[s.charAt(j)-'a']-=1;
                j+=1;
            }
            ans=Math.max(ans,i-j+1);
        }
        return ans;
    }
}