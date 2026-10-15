class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer>s=new Stack<>();
        int[] ans=new int[prices.length];
        for(int i=prices.length-1;i>=0;i--){
            while(!s.isEmpty()&&prices[i]<s.peek()){
                s.pop();
            }
        if (s.isEmpty()){
            ans[i]=prices[i];
        }
        else{
            ans[i]=prices[i]-s.peek();
        }
        s.push(prices[i]);
        }
     return ans;   
    }
}