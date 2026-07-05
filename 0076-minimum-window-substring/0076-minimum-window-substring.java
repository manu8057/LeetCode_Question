class Solution {
    public int idx(char ch){
        if(ch>='A'&&ch<='Z'){
            return ch-'A';
        }
        return 26+(ch-'a');
    }
    public boolean check(int fr[],int arr[]){
        for(int i=0;i<52;i++){
            if(fr[i]<arr[i]){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s,String t){
        int n=s.length();
        int len=t.length();
        int arr[]=new int[52];
        for(int i=0;i<len;i++){
            char ch=t.charAt(i);
            arr[idx(ch)]++;
        }
        int fr[]=new int[52];
        int j=0;
        int ans=n+1;
        int res[]={-1,-1};
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(arr[idx(ch)]>0) fr[idx(ch)]++;
            if(i+1>=len){
                while(j<=i&&check(fr,arr)){
                    char p=s.charAt(j);
                    if(arr[idx(p)]>0) fr[idx(p)]--;
                    if(ans>(i-j+1)){
                        res[0]=j;
                        res[1]=i;
                        ans=i-j+1;
                    }
                    j++;
                }
            }
        }
        if(res[0]==-1){
            return "";
        }
        return s.substring(res[0],res[1]+1);
    }
}