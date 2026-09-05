class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLen = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxLen) {
                            start = i;
                            maxLen = j - i + 1;
                        }
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}


//or

class Solution {
    public String longestPalindrome(String s) {
        if( s == null || s.length() < 1) return "";

        int st = 0, e = 0;
        for(int i =0; i<s.length(); i++){
            int len1 = expand(s,i,i);
            int len2 = expand(s, i, i+1);
            int len = Math.max(len1,len2);
            if(len > e - st){
                st = i - (len - 1)/2;
                e = i + len/2;
            }
        }
        return s.substring(st,e+1);
    }

    public int expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right) ){
            left--;
            right++;
        }
        return right - left -1;
    }
}
