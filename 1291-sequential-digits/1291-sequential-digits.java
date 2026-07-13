class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s="123456789";
        List<Integer>l=new ArrayList<>();
        for(int i=2;i<10;i++){
            for(int j=0;j<=s.length()-i;j++){
                int el=Integer.parseInt(s.substring(j,j+i));
                if(el<=high && el>=low){
                    l.add(el);
                }
            }
        }
        return l;
    }
}