class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
        int fr[]=new int[102];
        List<Integer>l=new ArrayList<>();
        int min=101;
        int max=-1;
        for(int el:nums){
            fr[el]+=1;
            min=Math.min(el,min);
            max=Math.max(el,max);
        }
        for(int i=min;i<=max;i+=1){
            if(fr[i]==0) l.add(i);
        }
        return l;
    }
}