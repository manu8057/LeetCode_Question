
class Solution {
    public int minSumOfLengths(int[] arr,int target) {
        int n=arr.length;
        int max=n+1;
        int pre=n+1;
        ArrayList<int[]>l=new ArrayList<>();
        int sum=0;
        int j=0;
        int pd=-1;
        for(int i=0;i<n;i+=1){
            sum+=arr[i];
            while(j<=i && sum>target){
                sum-=arr[j];
                j++;
            }
            if(sum==target){
                l.add(new int[]{j,i});
            }
        }
        if(l.size()<=1){
            return -1;
        }
        int[] best=new int[n];
        for(int i=0;i<n;i+=1){
            best[i]=max;
        }
        int k=0;
        int mn=max;
        for(int i=0;i<n;i+=1){
            while(k<l.size() && l.get(k)[1]==i){
                int[] ar=l.get(k);
                int d=ar[1]-ar[0]+1;
                if(ar[0]>0 && best[ar[0]-1]<max){
                    pre=Math.min(pre,best[ar[0]-1]+d);
                }
                mn=Math.min(mn,d);
                k++;
            }
            best[i]=mn;
        }
        return pre==max?-1:pre;
    }
}