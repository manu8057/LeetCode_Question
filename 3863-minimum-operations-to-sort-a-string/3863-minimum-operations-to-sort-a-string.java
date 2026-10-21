class Solution{
    public int minOperations(String s){
        int n=s.length();
        boolean ok=true;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)>s.charAt(i+1)){
                ok=false;
                break;
            }
        }
        if(ok)return 0;
        if(n==2)return -1;
        char min='z'+1;
        char max='a'-1;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c<min){
                min=c;
            }
            if(c>max){
                max=c;
            }
        }
        char ft=s.charAt(0);
        char lt=s.charAt(n-1);
        if(ft==min || lt==max){
            return 1;
        }
        if(ft==max &&  lt==min){
            int c1=0;
            int c2=0;
            for(int i=0;i<n;i++){
                if(s.charAt(i)==min){
                    c1++;
                }
                if(s.charAt(i)==max){
                    c2++;
                }
            }
            if(c1==1  && c2==1){
                return 3;
            }
        }
        return 2;
    }
}