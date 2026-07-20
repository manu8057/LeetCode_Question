class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n1=g.length;
        int n2=s.length;
        int i=n2-1;
        int j=n1-1;
        int c=0;
        while(j>=0 && i>=0){
            if(g[j]<=s[i]){
                j--;
                i--;
                c++;
            }
            else{
                j--;
            }
        }
        return c;
    }
}