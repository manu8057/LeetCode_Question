class Solution {
    public int minNumberOperations(int[] target) {
        int ans=target[0];
        for(int  i=1;i<target.length;i+=1){
            if(target[i]-target[i-1]>0){
                ans+=target[i]-target[i-1];
            }
        }
        return ans;
    }
}