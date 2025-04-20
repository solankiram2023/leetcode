class Solution {
    int counter =0;
    public int countArrangement(int n) {
        
        boolean[] seen = new boolean[n+1];
        calculate(n,1,seen);
        return counter;    
    }
    public void calculate(int n, int index, boolean[] seen){
        //base case
        if(index>n){
            counter++;
            return;

        }

        //beautiful array logic
        for(int i=1; i<=n;i++){
            if(!seen[i] && (index % i ==0 || i % index ==0)){
                seen[i]=true;
                calculate(n, index+1, seen);
                seen[i]=false;
            }
        }
    }

}