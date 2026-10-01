class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>s=new Stack<>();
        for(int input:asteroids){
            if(s.isEmpty()){
                s.push(input);
            }
            else if(s.peek()<0&&input>0){
                s.push(input);
            }
            else if(s.peek()>0&&input>0){
                s.push(input);
            }
            else if(s.peek()<0&&input<0){
                s.push(input);
            } else{
                boolean exploded=false;
                while(!s.isEmpty()&&s.peek()>0&&input<0){
                    if(s.peek()>Math.abs(input)){
                        exploded=true;
                        break;
                    }
                    else if(s.peek()<Math.abs(input)){
                        s.pop();
                    } else{
                        s.pop();
                        exploded=true;
                        break;
                    }
                }
                if(!exploded){
                    s.push(input);
                }
            }
        }
                int[] ans=new int[s.size()];
                for(int i=0;i<s.size();i++){
                    ans[i]=s.get(i);
                }
                return ans;
    }
}