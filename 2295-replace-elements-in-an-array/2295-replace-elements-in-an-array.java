class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }
        for(int ar[]:operations){
            int k=ar[0];
            int el=ar[1];
            nums[map.get(k)]=el;
            map.put(el,map.get(k));
        }
        return nums;
    }
}