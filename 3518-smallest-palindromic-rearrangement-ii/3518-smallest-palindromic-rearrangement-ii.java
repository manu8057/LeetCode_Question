class Solution {
    public long fun(int a[],long k){
        long ans=1;
        int len=0;
        for(int x:a){
            if(x==0) continue;
            len+=x;
            long n=len;
            long r=x;
            if(r>n-r) r=n-r;
            long c=1;
            for(int i=1;i<=r;i++){
                c=c*(n-i+1)/i;
                if(c>k){
                    c=k+1;
                    break;
                }
            }
            ans*=c;
            if(ans>k) return k+1;
        }
        return ans;
    }
    public String smallestPalindrome(String s,int k) {
        int fr[]=new int[26];
        for(char ch:s.toCharArray()) fr[ch-'a']++;

        int a[]=new int[26];
        String m="";
        int n=0;
        for(int i=0;i<26;i++){
            if((fr[i]&1)==1) m+=(char)(i+'a');
            a[i]=fr[i]/2;
            n+=a[i];
        }
        if(fun(a,k)<k) return "";
        StringBuilder h=new StringBuilder();
        while(h.length()<n){
            for(int i=0;i<26;i++){
                if(a[i]==0) continue;
                a[i]--;
                long c=fun(a,k);
                if(c>=k){
                    h.append((char)(i+'a'));
                    break;
                }else{
                    k-=c;
                    a[i]++;
                }
            }
        }
        String x=h.toString();
        String y=h.reverse().toString();
        return x+m+y;
    }
}