class Solution {
    // public int fun(int r,boolean arr[][]){
    //    boolean a=true;
    //    boolean b=true;
    //    boolean c=true;
    //    for(int i=1;i<5;i+=1){
    //         if(arr[r][i]){
    //             a=false;
    //             break;
    //         }
    //    }
    //    for(int i=3;i<7;i+=1){
    //         if(arr[r][i]){
    //             b=false;
    //             break;
    //         }
    //    }
    //    for(int i=5;i<9;i+=1){
    //         if(arr[r][i]){
    //             c=false;
    //             break;
    //         }
    //    }
    //    int count=0;
    //    if(a && b && c){
    //       count+=2;
    //    }
    //    else if(a || b || c){
    //        count+=1;
    //    }
    //    return count;
       
    // }
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // boolean arr[][]=new boolean[n][10];
        // for(int ar[]:reservedSeats){
        //     arr[ar[0]-1][ar[1]-1]=true;
        // }
        // int ans=0;
        // for(int i=0;i<n;i+=1){
        //     ans+=fun(i,arr);
        // }
        // return ans;
        HashMap<Integer,HashSet<Integer>>map=new HashMap<>();
        for(int ar[]:reservedSeats){
            if(map.containsKey(ar[0])){
                map.get(ar[0]).add(ar[1]);
            }
            else{
                map.put(ar[0],new HashSet<>());
                map.get(ar[0]).add(ar[1]);
            }
        }
        int sz=map.size();
        int ans=(n-sz)*2;
        for(Integer r:map.keySet()){
            boolean a=true;
            boolean b=true;
            boolean c=true;
            HashSet set=map.get(r);
            for(int i=2;i<=5;i+=1){
                if(set.contains(i)){
                    a=false;
                    break;
                }
            }
            for(int i=4;i<=7;i+=1){
                if(set.contains(i)){
                    b=false;
                    break;
                }
            }
            for(int i=6;i<=9;i+=1){
                if(set.contains(i)){
                    c=false;
                    break;
                }
            }
            if(a && b && c){
                ans+=2;
            }
            else if(a || b || c){
                ans+=1;
            }
        }
        return ans;
    }
}