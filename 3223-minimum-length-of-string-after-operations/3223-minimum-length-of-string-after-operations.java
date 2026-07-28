class Solution {
    public int minimumLength(String s) {
       int n=s.length();
       int fr[]=new int[26];
       for(int i=0;i<n;i+=1){
            fr[s.charAt(i)-'a']++;
       }
       int ans=0;
       for(int i=0;i<26;i+=1){
          if(fr[i]>=3){
              if(fr[i]%2==0){
                   ans+=2;
              }
              else{
                  ans+=1;
              }
          }
          else{
            ans+=fr[i];
          }
       }
       return ans;
    }
}