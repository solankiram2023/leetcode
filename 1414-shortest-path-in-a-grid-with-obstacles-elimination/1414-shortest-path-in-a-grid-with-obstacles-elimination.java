class Solution {
    public int shortestPath(int[][] grid, int k) {
        //base case
        if (grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;

        if(m*n<k) return m+n-2;

        //directions
        int [][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        //queue
        Queue<int[]> q = new LinkedList<>();
        //adding root node to the queue
        q.add(new int[]{0,0,k});

        //making the visited matrix to avoid repetition of path
        boolean[][][] visited = new boolean[m][n][k+1];
        //Making the starting point as true meaning it is visited
        visited[0][0][k] = true;

        //counting and storing path in result
        int result = 0;
        //BFS
        while(!q.isEmpty()){
            int size= q.size();

            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int row=curr[0];
                int col=curr[1];
                int leftoverK= curr[2];
                //if we are able to reach the end point then return the path in result
                if(row ==m-1 && col == n-1) return result;
                //
                for(int[] dir: dirs){//traversing through the grid
                    int nr = row + dir[0];//going right
                    int nc = col +dir[1];//going down
                    //if the next element is within the bounds
                    if(nr>=0 && nc>=0 && nr<m && nc<n){
                        int nk=leftoverK - grid[nr][nc];
                        if(nk>=0 && !visited[nr][nc][nk]){
                            visited[nr][nc][nk] = true;
                            q.add(new int []{nr,nc,nk});
                        }
                    }

                }

            }
            result++;
        }

        return -1;
    }
}