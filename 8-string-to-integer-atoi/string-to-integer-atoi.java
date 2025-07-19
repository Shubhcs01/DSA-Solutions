class Solution {
    public int myAtoi(String s) {

        //remove leading spaces
        s = s.trim();

        if(s.length()==0) return 0;

        int i = 0;

        //check sign
        Boolean isNegative = false;
        if(s.charAt(0) == '-'){
            isNegative = true;
            i++;
        } else if(s.charAt(0) == '+'){
            i++;
        }

        //parse int
        int num = 0;
        int maxLimit = Integer.MAX_VALUE;
        int minLimit = Integer.MIN_VALUE;
        while( i < s.length() && Character.isDigit(s.charAt(i))){
            //check overflow before adding
            int digit = s.charAt(i) - '0';
            if(num > maxLimit/10 || (num == maxLimit/10 && digit > 7)){
                return isNegative? minLimit : maxLimit;
            }

            num = num * 10 + digit;
            i++;
        }

        return isNegative? -num : num;

    }
}