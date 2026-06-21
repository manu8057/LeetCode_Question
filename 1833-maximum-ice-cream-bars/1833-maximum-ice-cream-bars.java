class Solution {
    public int maxIceCream(int[] costs, int coins) {
       int n=costs.length;
       int max=0;
       for(int el:costs){
         max=Math.max(el,max);
       }
       int fr[]=new int[max+1];
       for(int i=0;i<n;i++){
          fr[costs[i]]++;
       }
       int ans[]=new int[n];
       int j=0;
       int id=0;
       while(j<=max){
          while(fr[j]>0){
             ans[id++]=j;
             fr[j]-=1;
          }
          j++;
       }
       int res=0;
       long sum=0;
       for(int i=0;i<n;i++){
           sum+=ans[i];
           if(sum<=coins) res++;
       }
       return res;
    }
}