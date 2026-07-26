class Solution {
    public boolean winnerOfGame(String colors) {
        int n=colors.length();
        if(n<=2) return false;
        int a=0;
        int b=0;
        int a1=0;
        int b1=0;
        for(int i=0;i<n;i++){
            char ch=colors.charAt(i);
            if(ch=='A'){
                b1=0;
                a1+=1;
            }
            else{
                a1=0;
                b1+=1;
            }
            if(a1>=3) a+=1;
            if(b1>=3) b+=1;
        }
        return a>b;
    }
}