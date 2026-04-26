class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int arr[]=new int[n];
        HashMap<Integer,Integer>map=new HashMap<>();
        int i=0;
        int j=0;
        int ans=0;
        while(j<n){
            int el=nums[j];
            map.put(el,map.getOrDefault(el,0)+1);
            while(i<j && map.get(el)>k){
                map.put(nums[i],map.get(nums[i])-1);
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}