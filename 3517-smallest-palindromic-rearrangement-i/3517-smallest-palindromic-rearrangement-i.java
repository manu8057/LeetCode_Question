class Solution {
    public String smallestPalindrome(String s) {
        char arr[]=s.toCharArray();
        int n=s.length();
        Arrays.sort(arr);
        char nums[]=new char[n];
        int l=0;
        int h=n-1;
        HashMap<Character,Integer>map=new HashMap<>();
        for(char ch:arr){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<n;){
            char jk=arr[i];
            if(map.get(jk)>=2){
                nums[l]=jk;
                nums[h]=jk;
                l++;
                h--;
                map.put(jk,map.get(jk)-2);
                i+=2;
            }
            else if(map.get(jk)==1){
                nums[n/2]=jk;
                map.put(jk,map.get(jk)-1);
                i+=1;
            }
            else{
                i+=1;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char e:nums){
            sb.append(e);
        }
        return sb.toString();
    }
}