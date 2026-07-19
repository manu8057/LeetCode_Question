class Solution {
    public String smallestSubsequence(String s) {
        int n=s.length();
        Stack<Character>st=new Stack<>();
        int arr[]=new int[26];
        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']=i;
        }
        boolean vis[]=new boolean[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(vis[ch-'a']){
                continue;
            }
            while(!st.isEmpty() && st.peek()>ch && arr[st.peek()-'a']>i){
                vis[st.pop()-'a']=false;
            }
            vis[ch-'a']=true;
            st.push(ch);
        }
        StringBuilder sb=new StringBuilder();
        for(char x:st){
            sb.append(x);
        }
        return sb.toString();
    }
}