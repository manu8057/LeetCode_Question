class Solution {
    public int rotatedDigits(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            int t=i;
            boolean f=false;
            boolean fl=false;
            while(t>0){
                int m=t%10;
                if(m!=2 && m!=5 && m!=6 && m!=9 && m!=1 && m!=0 && m!=8){
                    f=true;
                    break;
                }
                if(m!=1 && m!=0 && m!=8){
                    fl=true;
                }
                t/=10;
            }
            if(!f && fl) ans++;
        }
        return ans;
    }
}