class Solution {
    public int find(int i,int pr[]){
        if(pr[i]==i) return i;
        return pr[i]=find(pr[i],pr);
    }
    public boolean equationsPossible(String[] equations) {
        int pr[]=new int[26];
        int fr[]=new  int[26];
        for(int i=0;i<26;i++){
            pr[i]=i;
            fr[i]=1;
        }
        for(String s:equations){
            int a=s.charAt(0)-'a';
            int b=s.charAt(3)-'a';
            char c=s.charAt(1);
            int ab=find(a,pr);
            int bb=find(b,pr);
            if(c=='='){
                if(fr[ab]>fr[bb]){
                    pr[bb]=pr[ab];
                    fr[ab]+=fr[bb];
                }
                else{
                    pr[ab]=pr[bb];
                    fr[bb]+=fr[ab];
                }
            }
        }
        for(String str:equations){
            int a=str.charAt(0)-'a';
            int b=str.charAt(3)-'a';
            int c=str.charAt(1);
            if(c=='!'){
                if(find(pr[a],pr)==find(pr[b],pr)) return false;
            }
        }
        return true;
    }
}