class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int ex) {
        List<Boolean>l=new ArrayList<>();
        int max=candies[0];
        for(int el:candies){
            max=Math.max(el,max);
        }
        for(int el:candies){
            if((el+ex)>=max){
                l.add(true);
            }
            else{
                l.add(false);
            }
        }
        return l;
    }
}