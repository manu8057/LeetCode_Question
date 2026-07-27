class Solution {
    public int minimumLength(String s) {
        int n=s.length();
        int i=0;
        int j=n-1;
        while(i<j){
            char ch=s.charAt(i);
            if(s.charAt(i)!=s.charAt(j)){
                return j-i+1;
            }
            else{
                while(i<=j && s.charAt(i)==ch){
                    i+=1;
                }
                while(i<=j && s.charAt(j)==ch){
                    j-=1;
                }
            }
        }
        return j-i+1;
    }
}