class trienode{
    int idx=Integer.MAX_VALUE;
    trienode[] child=new trienode[26];
}
class trie{
    trienode root;
    String[] w;
    trie(String[] words){
        root=new trienode();
        w=words;
        for(int i=0;i<words.length;i++){
            insert(words[i],i);
        }
        fill(root);
    }
    boolean check(int i,int j){
        int n=w.length;
        return (j>=0 && j<n) &&
        (!(i>=0 && i<n) ||
        w[j].length()<w[i].length() ||
        (w[j].length()==w[i].length() && j<i));
    }
    int fill(trienode cur){
        for(trienode x:cur.child){
            int r=x!=null ? fill(x):Integer.MAX_VALUE;
            if(check(cur.idx,r)){
                cur.idx=r;
            }
        }
        return cur.idx;
    }
    void insert(String s,int idx){
        trienode cur=root;
        for(int i=s.length()-1;i>=0;i--){
            int c=s.charAt(i)-'a';
            if(cur.child[c]==null){
                cur.child[c]=new trienode();
            }
            cur=cur.child[c];
        }
        cur.idx=Math.min(cur.idx,idx);
    }
    int search(String s){
        trienode cur=root;
        for(int i=s.length()-1;i>=0;i--){
            int c=s.charAt(i)-'a';
            if(cur.child[c]==null){
                break;
            }
            cur=cur.child[c];
        }
        return cur.idx;
    }
}
class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        trie t=new trie(wordsContainer);
        int[] ans=new int[wordsQuery.length];
        for(int i=0;i<wordsQuery.length;i++){
            ans[i]=t.search(wordsQuery[i]);
        }
        return ans;
    }
}