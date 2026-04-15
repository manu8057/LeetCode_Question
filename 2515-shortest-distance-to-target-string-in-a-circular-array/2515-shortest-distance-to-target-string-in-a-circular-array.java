class Solution {
    public int closestTarget(String[] words, String target, int si) {
        int n=words.length;
        int a=Integer.MAX_VALUE;
        for(int i=si;i<2*n;i++){
            if(words[i%n].equals(target)){
                a=i-si;
                break;
            }
        }
        for(int i=n+si;i>=0;i--){
            if(words[i%n].equals(target)){
                a=Math.min(a,n+si-i);
            }
        }
        return a==Integer.MAX_VALUE?-1:a;
    }
}