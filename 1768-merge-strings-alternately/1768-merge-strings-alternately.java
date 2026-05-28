class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int n1=word1.length();
        int n2=word2.length();
        int i=0,j=0;
        boolean f=false;
        while(i<n1 && j<n2){
            if(!f){
                sb.append(word1.charAt(i));
                i++;
                f=!f;
            }
            else{
                sb.append(word2.charAt(j));
                j++;
                f=!f;
            }
        }
        while(i<n1){
            sb.append(word1.charAt(i));
            i++;
        }
        while(j<n2){
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}