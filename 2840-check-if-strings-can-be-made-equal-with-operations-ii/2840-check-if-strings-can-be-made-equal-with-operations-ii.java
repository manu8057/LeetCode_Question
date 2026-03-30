class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n=s1.length();
        char arr1[]=new char[26];
        char arr2[]=new char[26];
        for(int i=0;i<n;i++){
            char ch=s1.charAt(i);
            if(i%2==0){
                arr2[ch-'a']++;
            }
            else{
                arr1[ch-'a']++;
            }
        }
        for(int i=0;i<n;i++){
            char ch=s2.charAt(i);
            if(i%2==0){
                if(arr2[ch-'a']<=0){
                    return false;
                }
                else{
                    arr2[ch-'a']--;
                }
            }
            else{
                if(arr1[ch-'a']<=0){
                    return false;
                }
                else{
                    arr1[ch-'a']--;
                }
            }
        }
        return true;
    }
}