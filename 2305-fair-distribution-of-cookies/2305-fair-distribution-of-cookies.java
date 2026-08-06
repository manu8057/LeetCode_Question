class Solution {
    int arr[];
    int min=Integer.MAX_VALUE;
    // public int find(int arr[]){
    //     int m1=Integer.MAX_VALUE;
    //     int m2=Integer.MIN_VALUE;
    //     for(int el:arr){
    //         m2=Math.max(el,m2);
    //         m1=Math.min(el,m1);
    //     }
    //     return m2-m1;
    // }
    int ans=Integer.MAX_VALUE;
    public int sol(int arr[]){
        int m2=Integer.MIN_VALUE;
        for(int el:arr){
            m2=Math.max(el,m2);
        }
        return m2;
    }
    public int fun(int id,int n,int cookies[],int k){
        if(id>=n){
           ans=Math.min(ans,sol(arr));
           return ans;
        }
        int val=cookies[id];
        for(int i=0;i<k;i+=1){
            arr[i]+=val;
            fun(id+1,n,cookies,k);
            arr[i]-=val;
        }
        return ans;
    }
    public int distributeCookies(int[] cookies, int k) {
        int n=cookies.length;
        arr=new int[k];
        return fun(0,n,cookies,k);
    }
}