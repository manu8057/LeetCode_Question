class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int n=s.length();
        int t=0;
        int f=0;
        int ans=0;
        int j=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='T') t++;
            else f++;
            while(t>k && f>k){
                if(s.charAt(j)=='T'){
                    t--;
                }
                else{
                    f--;
                }
                j++;
            }
            ans=Math.max(ans,i-j+1);
        }
        return ans;
    }
}