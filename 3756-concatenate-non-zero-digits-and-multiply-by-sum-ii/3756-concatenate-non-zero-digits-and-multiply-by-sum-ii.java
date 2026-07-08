class Solution {
    int m=(int)1e9+7;
    public int fun(ArrayList<Integer>list,long[]prefNum,long[]p10,int l,int h){
        int low=0,high=list.size()-1;
        int startIdx=list.size();
        while(low<=high){
            int mid=low+(high-low)/2;
            if(list.get(mid)>=l){
                startIdx=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        low=0;
        high=list.size()-1;
        int endIdx=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(list.get(mid)<=h){
                endIdx=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        if(startIdx>endIdx) return 0;
        int len=endIdx-startIdx+1;
        long sub=(prefNum[startIdx]*p10[len])%m;
        long y=(prefNum[endIdx+1]-sub+m)%m;
        return (int)y;
    }
    public int[] sumAndMultiply(String s,int[][] queries){
        int n=s.length();
        int pre[]=new int[n];
        int sum=0;
        ArrayList<Integer>l=new ArrayList<>();
        long[]prefNum=new long[n+1];
        long[]p10=new long[n+1];
        p10[0]=1;
        int nzCount=0;
        for(int i=0;i<n;i++){
            sum+=s.charAt(i)-'0';
            pre[i]=sum;
            if(s.charAt(i)-'0'!=0){
                l.add(i);
                int digit=s.charAt(i)-'0';
                prefNum[nzCount+1]=(prefNum[nzCount]*10+digit)%m;
                p10[nzCount+1]=(p10[nzCount]*10)%m;
                nzCount++;
            }
        }
        int len=queries.length;
        int ans[]=new int[len];
        int idx=0;
        for(int ar[]:queries){
            int sp=0;
            if(ar[0]==0){
                sp=pre[ar[1]];
            }
            else{
                sp=pre[ar[1]]-pre[ar[0]-1];
            }
            int num=fun(l,prefNum,p10,ar[0],ar[1]);
            ans[idx]=(int)(((long)num*sp)%m);
            idx++;
        }
        return ans;
    }
}