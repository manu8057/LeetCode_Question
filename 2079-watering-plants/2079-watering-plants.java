class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int n=plants.length;
        int ans=0;
        int k=capacity;
        for(int i=0;i<n;i++){
            if(plants[i]<=k){
                ans+=1;
                k-=plants[i];
            }
            else{
                ans+=2*i+1;
                k=capacity;
                k-=plants[i];
            }
        }
        return ans;
    }
}