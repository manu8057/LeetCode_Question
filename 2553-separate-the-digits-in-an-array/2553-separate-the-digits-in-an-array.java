class Solution {
    public int[] separateDigits(int[] nums) {
        // ArrayList<Integer>l=new ArrayList<>();
        // for(int el:nums){
        //     ArrayList<Integer>list=new ArrayList<>();
        //     while(el>0){
        //         list.add(el%10);
        //         el/=10;
        //     }
        //     for(int i=list.size()-1;i>=0;i--){
        //         l.add(list.get(i));
        //     }
        // }
        // int arr[]=new int[l.size()];
        // for(int i=0;i<l.size();i++){
        //     arr[i]=l.get(i);
        // }
        // return arr;
        StringBuilder sb=new StringBuilder();
        for(int el:nums){
            sb.append(el);
        }
        int arr[]=new int[sb.length()];
        for(int i=0;i<arr.length;i++){
            arr[i]=sb.charAt(i)-'0';
        }
        return arr;
    }
}