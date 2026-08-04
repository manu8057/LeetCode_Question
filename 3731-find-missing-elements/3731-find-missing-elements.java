class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int pre=nums[0];
        List<Integer>l=new ArrayList<>();
        for(int i=1;i<n;i+=1){
            while((pre+1)!=nums[i]){
                l.add(pre+1);
                pre+=1;
            }
            pre=nums[i];
        }
        return l;
    }
}