class FirstMissingPositive {
    public int firstMissingPositive(int[] arr) {
        int i=0;

        while(i<arr.length) {
            int index=arr[i]-1;
            if(arr[i]>0 && arr[i]<arr.length && arr[i]!=arr[index]) {
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
            } else {
                i++;
            }
        }

        for(i=0;i<arr.length;i++) {
            if(arr[i]!=i+1) {
                return i+1;
            }
        }
        return arr.length+1;
    }
}