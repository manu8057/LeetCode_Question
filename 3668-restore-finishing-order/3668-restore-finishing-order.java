class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
       int arr[]=new int[101];
       int n=order.length;
       int ans[]=new int[friends.length];
       for(int el:friends){
          arr[el]+=1;
       }
       int id=0;
       for(int i=0;i<n;i++){
           if(arr[order[i]]!=0){
                ans[id++]=order[i];
           }
       }
       return ans;
    }
}