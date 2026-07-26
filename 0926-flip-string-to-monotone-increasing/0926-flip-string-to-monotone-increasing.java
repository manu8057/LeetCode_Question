class Solution {
    public int minFlipsMonoIncr(String s) {
        int n=s.length();
        int c=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='1') c++;
        }
        int ans=Math.min(c,n-c);
        int zero=n-c;
        int count=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='0'){
                zero-=1;
            }
            else{
                count+=1;
            }
            if(zero==0){
                break;
            }
            else{
                ans=Math.min(ans,count+zero);
            }
        }
        return Math.min(ans,count);
    }
}