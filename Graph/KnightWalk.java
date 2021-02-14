/*
Given a square chessboard, the initial position of Knight and position of a target. 
Find out the minimum steps a Knight will take to reach the target position.
https://practice.geeksforgeeks.org/problems/knight-walk4521/1#
*/

class Pair{
    int x,y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution
{
    int X[] = {1,-1,1,-1,2,-2,2,-2};
    int Y[] = {2,2,-2,-2,1,1,-1,-1};
    
    boolean isValidMove(int x, int y, boolean[][] visited, int n){
        if(x<0 || y<0 || x>=n || y>=n || visited[x][y])
            return false;
        return true;
    }
    
	/*Use BFS to count minSteps*/
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int n)
    {
        int startX = KnightPos[0] -1;
        int startY = KnightPos[1] -1;
        
        int endX = TargetPos[0]-1;
        int endY = TargetPos[1]-1;
        boolean[][] visited = new boolean[n][n];
        
        int stepCount = 0;
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(startX, startY));
        q.add(null);
        
        while(q.size() >0){
            Pair curr = q.poll();
            if(curr == null){
                if(q.size()>0)
                    q.add(null);
                    
                stepCount++;
            }
            else if(curr.x == endX && curr.y == endY)
                return stepCount;
            else {
                for(int i=0;i<8;i++){
                    int nextX = curr.x+X[i];
                    int nextY = curr.y+Y[i];
                    if(isValidMove(nextX,nextY,visited,n)){
                        visited[nextX][nextY] = true;
                        q.add(new Pair(nextX,nextY));
                    }
                }
            }
        }
        return stepCount;
    }
}