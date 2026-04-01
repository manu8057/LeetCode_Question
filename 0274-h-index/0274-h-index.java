class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n=citations.length;
        int ans=0;
        int jk=1;
        for(int i=n-1;i>=0;i--){
            if(citations[i]>=jk){
                ans++;
                jk++;
            }
            else{
                break;
            }
        }
        return ans;
    }
}