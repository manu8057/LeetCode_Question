class Solution {
    public int minChanges(String s) {
        int n=s.length();
        int c=0;
        int ans=0;
        int pre=-1;
        int i=0;
        while(i<n){
            int p=s.charAt(i)-'0';
            if(pre==-1){
                pre=p;
                c++;
            }
            else if(pre==p){
                c++;
            }
            else{
                if(c%2!=0){
                    ans+=1;
                    c=0;
                    pre=-1;
                }
                else{
                    c=1;
                    pre=p;
                }
            }
            i+=1;
        }
        return ans;
    }
}