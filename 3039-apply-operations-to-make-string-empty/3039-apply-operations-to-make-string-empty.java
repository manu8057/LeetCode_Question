class Solution {
    public String lastNonEmptyString(String s) {
        int arr[]=new int[26];
        int n=s.length();
        int max=0;
        for(int i=0;i<n;i+=1){
            char ch=s.charAt(i);
            arr[ch-'a']+=1;
            max=Math.max(max,arr[ch-'a']);
        }
        int c=0;
        for(int i=0;i<26;i+=1){
            if(arr[i]==max){
                arr[i]=-1;
                c+=1;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            if(arr[ch-'a']==-1){
                sb.append(ch);
                arr[ch-'a']=1;
                c-=1;
            }
            if(c==0) break;
        }
        return sb.reverse().toString();
    }
}