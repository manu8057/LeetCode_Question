class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        int[] fr=new int[101];
        List<Integer>l=new ArrayList<>();
        for(int el:bulbs){
            if(fr[el]==1){
                fr[el]=0;
            }
            else{
                fr[el]=1;
            }
        }
        for(int i=0;i<101;i++){
            if(fr[i]==1){
                l.add(i);
            }
        }
        return l;
    }
}