class Solution {
    public boolean check(int fr[],int arr[]){
        for(int i=0;i<26;i+=1){
            if(fr[i]!=arr[i]) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>l=new ArrayList<>();
        if(s.length()<p.length()){
            return l;
        }
        int len=p.length();
        int n=s.length();
        int arr[]=new int[26];
        for(char ch:p.toCharArray()){
            arr[ch-'a']++;
        }
        int fr[]=new int[26];
        for(int i=0;i<len;i+=1){
            char jk=s.charAt(i);
            fr[jk-'a']++;
        }
        if(check(fr,arr)){
            l.add(0);
        }
        for(int i=len;i<n;i+=1){
            char  u=s.charAt(i-len);
            fr[u-'a']--;
            fr[s.charAt(i)-'a']++;
            if(check(fr,arr)){
                l.add(i-len+1);
            }
        }
        return l;
    }
}