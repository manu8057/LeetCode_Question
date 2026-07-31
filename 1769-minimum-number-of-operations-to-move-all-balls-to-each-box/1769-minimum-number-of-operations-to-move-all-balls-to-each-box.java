class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int ans[]=new int[n];
        int b=0;
        int c=0;
        for(int i=0;i<n;i+=1){
            ans[i]+=c;
            if(boxes.charAt(i)=='1') b++;
            c+=b;
        }
        b=0;
        c=0;
        for(int i=n-1;i>=0;i-=1){
            ans[i]+=c;
            if(boxes.charAt(i)=='1') b++;
            c+=b;
        }
        return ans;
    }
}