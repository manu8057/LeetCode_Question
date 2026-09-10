class Solution {
    public int longestConsecutive(int[] nums) {
      if(nums.length==0){
        return 0;
      }
      TreeSet<Integer>set=new TreeSet<>();
      for(int i:nums) set.add(i);
      int c=1;
      int max=1;
      for(int i:set){
         if(set.contains(i+1)){
            c++;
         }
         else{
            max=Math.max(max,c);
            c=1;
         }
      }
      return max;
    }
}