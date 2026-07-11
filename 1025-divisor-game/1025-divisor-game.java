class Solution {
    Boolean arr[];
    public boolean fun(int n){
        if(n==1) return arr[n]=false;
        if(arr[n]!=null) return arr[n];
        for(int i=1;i<n;i++){
            if(n%i==0){
                if(!fun(n-i)){
                    return arr[n]=true;
                }
            }
        }
        return arr[n]=false;
    }
    public boolean divisorGame(int n) {
        arr=new Boolean[n+1];
        return fun(n);
    }
}