class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int num: piles){
            max = Math.max(max, num);
        }
        int s = 1, e = max;
        while(s < e){
            int t = 0;
            int mid = s + (e-s)/2;
            for(int num: piles){
                t += Math.ceilDiv(num, mid);
            }
            if(t <= h){
                e = mid;
            }
            else{
                s = mid + 1;
            }
        }
        return s;
    }
}