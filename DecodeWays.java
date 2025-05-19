class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        if(s==null || n==0 || s.charAt(0)=='0') return 0;

        int prev2 = 1, prev1 = 1;

        for(int i=2;i<=n;i++) {
            int curr = 0;
            if(s.charAt(i-1)!='0') {
                curr+=prev1;
            }

            int value = Integer.parseInt(s.substring(i-2, i));
            if(value>=10 && value<=26) {
                curr+= prev2;
            }
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}