class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
                result.append(c);
            } else if (c == ')') {
                if (open > 0) {
                    open--;
                    result.append(c);
                }
            } else {
                result.append(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = result.length() - 1; i >= 0; i--) {
            char c = result.charAt(i);
            if (c == '(' && open > 0) {
                open--;
            } else {
                ans.append(c);
            }
        }
        return ans.reverse().toString();
    }
}