class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        for(char c:s.toCharArray()){
            if(c == '(' || c == '{' || c== '['){
                stk.push(c);
            }
            else{
                if(stk.isEmpty())return false;
                char top = stk.pop();
                if(top != '(' && c == ')'){
                    return false;
                }
                if(top != '{' && c == '}'){
                    return false;
                }
                if(top != '[' && c == ']'){
                    return false;
                }
            }
        }
        return stk.isEmpty(); 
    }
}