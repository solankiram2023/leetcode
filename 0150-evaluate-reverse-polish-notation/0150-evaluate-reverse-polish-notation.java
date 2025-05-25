class Solution {
    public int evalRPN(String[] tokens) {

        //Create Stack
        Stack<Integer> stack =new Stack<>();

        for(String s : tokens){
            //Add operator
            if(s.equals("+")){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second+first);
            }
             //Subtractionoperator
            else if(s.equals("-")){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second-first);
            }
             //Multiply operator
            else if(s.equals("*")){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second*first);
            }
             //Divide operator
            else if(s.equals("/")){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second/first);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
            
        }
        return stack.pop();
    }

}
        










  