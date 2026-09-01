class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int fr[]=new int[1001];
        for(int el:target){
            fr[el]++;
        }
        for(int e:arr){
            fr[e]--;
            if(fr[e]<0){
                return false;
            }
        }
        return true;
    }
}