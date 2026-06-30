class Solution {
    public boolean fun(int arr[]){
        if(arr[0]>=1 && arr[1]>=1 && arr[2]>=1){
            return true;
        }
        return false;
    }
    public int numberOfSubstrings(String s) {
        int ans=0;
        int n=s.length();
        int arr[]=new int[3];
        int j=0;
        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']++;
            while(fun(arr)){
                ans=ans+(n-i);
                arr[s.charAt(j)-'a']--;
                j++;
            }
        }
        return ans;
    }
}