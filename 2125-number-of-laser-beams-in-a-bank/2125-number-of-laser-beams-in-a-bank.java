class Solution {
    public int fun(String s){
        int c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') c++;
        }
        return c;
    }
    public int numberOfBeams(String[] bank) {
        int ans=0;
        int pre=-1;
        int n=bank.length;
        for(int i=0;i<n;i++){
            int c=fun(bank[i]);
            if(c!=0){
                if(pre!=-1) ans=ans+pre*c;
                pre=c;
            }
        }
        return ans;
    }
}