class Solution {
    public int minimumChairs(String s) {
        int c=0;
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i+=1){
            char ch=s.charAt(i);
            if(ch=='E' && c==0){
                ans+=1;
            }
            else if(ch=='E' && c>0){
                c-=1;
            }
            else{
                c+=1;
            }
        }
        return ans;
    }
}