class NumArray {
    int seg[];
    int size;
    public void bt(int i,int l,int r,int nums[]){
        if(l==r){
            seg[i]=nums[l];
            return;
        }
        int mid=(l+r)/2;
        bt(2*i+1,l,mid,nums);
        bt(2*i+2,mid+1,r,nums);
        seg[i]=seg[2*i+1]+seg[2*i+2];
    }
    public NumArray(int[] nums) {
        int n=nums.length;
        seg=new int[4*n];
        size=n;
        bt(0,0,n-1,nums);
    }
    public void up(int i,int l,int r,int ind,int val){
        if(l==r){
            seg[i]=val;
            return;
        }
        int mid=(l+r)/2;
        if(ind<=mid){
            up(2*i+1,l,mid,ind,val);
        }
        else{
            up(2*i+2,mid+1,r,ind,val);
        }
        seg[i]=seg[2*i+1]+seg[2*i+2];
    }
    public void update(int index, int val) {
        up(0,0,size-1,index,val);
    }
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
    public int sumRange(int left, int right) {
        return cal(0,0,size-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */