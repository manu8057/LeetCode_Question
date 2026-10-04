class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        int c1=0;
        int h1=0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==')' || s.charAt(i)=='*'){
                c1++;
            }
            else{
                h1++;
            }
            if(h1>c1){
                return false;
            }
        }
        int c2=0;
        int h2=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='*'){
                c2++;
            }
            else{
                h2++;
            }
            if(h2>c2){
                return false;
            }
        }
        return true;
    }
}