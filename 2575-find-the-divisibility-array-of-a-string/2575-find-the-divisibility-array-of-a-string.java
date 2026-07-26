class Solution {
    public int[] divisibilityArray(String word, int m) {
        int sum=0;
        int n=word.length();
        int ans[]=new int[n];
        long val=0;
        for(int i=0;i<n;i++){
            long el=(long)word.charAt(i)-'0';
            val=val*10+el;
            if(val>=m){
                val%=m;
            }
            if(val%m==0){
                ans[i]=1;
            }
            else{
                ans[i]=0;
            }
        }
        return ans;
    }
}