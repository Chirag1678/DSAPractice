class SplitArrayLargestSum {
    public int splitArray(int[] arr, int m) {
        int s=0;
        int e=0;
        for(int i=0;i<arr.length;i++){
            e+=arr[i];
            s=Math.max(s,arr[i]);
        }
        while(s<=e){
            int mid=s+(e-s)/2;
            int sum=0;
            int p=1;
            for(int num:arr){
                if(sum+num>mid){
                    sum=num;
                    p++;
                }
                else{
                    sum+=num;
                }
            }
            if(p>m){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return s;
    }
}