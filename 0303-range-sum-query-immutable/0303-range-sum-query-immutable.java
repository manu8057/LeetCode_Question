class NumArray {
    int seg[];
    int size;
    public int cal(int i,int l,int r,int st,int end){
        if(r<st || l>end){
            return 0;
        }
        if(l>=st && r<=end){
            return seg[i];
        }
        else{
            int mid=(l+r)/2;
            return cal(2*i+1,l,mid,st,end)+cal(2*i+2,mid+1,r,st,end);
        }
    }
    public void fun(int i,int l,int r,int nums[]){
        if(l==r){
            seg[i]=nums[r];
            return;
        }
        int mid=(l+r)/2;
        fun(2*i+1,l,mid,nums);
        fun(2*i+2,mid+1,r,nums);
        seg[i]=seg[2*i+1]+seg[2*i+2];
    }
    public NumArray(int[] nums) {
        int n=nums.length;
        seg=new int[4*n]; 
        size=n;
        fun(0,0,n-1,nums);
    }
    public int sumRange(int left, int right) {
        return cal(0,0,size-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */