class Solution {
    public String removeDuplicateLetters(String s) {
        int n=s.length();
        int arr[]=new int[26];
        boolean vis[]=new boolean[26];
        Stack<Character>st=new Stack<>();
        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']=i;
        }
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(vis[ch-'a']){
                continue;
            }
            while(!st.isEmpty() && st.peek()>ch &&  arr[st.peek()-'a']>i){
                char c=st.pop();
                vis[c-'a']=false;
            }
            st.push(ch);
            vis[ch-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        int m=st.size();
        for(int i=0;i<m;i++){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}