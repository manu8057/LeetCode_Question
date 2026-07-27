class Solution {
    public int appendCharacters(String s, String t) {
        int n2=s.length();
        int n1=t.length();
        int i=0;
        int j=0;
        while(i<n1 && j<n2){
            char ch=t.charAt(i);
            while(j<n2 && s.charAt(j)!=t.charAt(i)){
                j++;
            }
            if(j<n2){
                j+=1;
                i+=1;
            }
        }
        return n1-i;
    }
}