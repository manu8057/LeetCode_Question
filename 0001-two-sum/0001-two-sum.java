class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i+=1){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i+=1){
            if(map.containsKey(target-nums[i]) && (map.get(target-nums[i])!=i || map.get(target-nums[i])>1)){
                return new int[]{i,map.get(target-nums[i])};
            }
        }
        return new int[]{-1,-1};
        // Arrays.sort(nums);
        // int n=nums.length;
        // int i=0;
        // int j=n-1;
        // while(i<j){
        //     int sum=nums[i]+nums[j];
        //     if(sum==target){
        //         return new int[]{)};
        //     }
        //     else if(sum>target){
        //         j-=1;
        //     }
        //     else{
        //         i+=1;
        //     }
        // }
        // return new int[]{-1,-1};
    }
}