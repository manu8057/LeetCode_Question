class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        s="1"+s+"1";
        int n=s.length();
        int one=0;
        for(int i=1;i<n-1;i++){
            if(s.charAt(i)=='1'){
                one++;
            }
        }
        int ans=one;
        int i=1;
        while(i<n-1){
            if(s.charAt(i)=='0'){
                i++;
                continue;
            }
            int st=i;
            while(i<n-1&&s.charAt(i)=='1'){
                i++;
            }
            int en=i-1;
            if(s.charAt(st-1)=='0'&&s.charAt(en+1)=='0'){
                int onelen=en-st+1;
                int l=0;
                int j=st-1;
                while(s.charAt(j)=='0'){
                    l++;
                    j--;
                }
                int r=0;
                j=en+1;
                while(s.charAt(j)=='0'){
                    r++;
                    j++;
                }
                int zero=l+onelen+r;
                ans=Math.max(ans,one-onelen+zero);
            }
        }
        return ans;
    }
}