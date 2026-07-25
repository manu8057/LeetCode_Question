class Solution {
    public boolean isValidSerialization(String preorder) {
        String arr[]=preorder.split(",");
        int ans=1;
        for(int i=0;i<arr.length;i++){
            ans--;
            if(ans<0) return false;
            if(!arr[i].equals("#")){
                ans+=2;
            }
        }
        return ans==0;
    }
}