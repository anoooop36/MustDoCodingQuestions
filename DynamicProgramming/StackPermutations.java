/*
    Given and array of n elements find all stack permutations possible of that array.
    Karumanchi Book
*/

public class StackPermutations {

    /*
        T(i,j) where i is number of elements to be pushed in stack
                and j is number of elements in stack
        T(0,j) = 1 where j > 0, only pop
        T(i,j) = T(i-1,j+1) where j==0, only push
        T(i,j) = T(i-1,j+1) + T(i,j-1) where i>0 and j>0, push or pop

        solution will be T(n,0) where no elements in stack and n elements to be pushed to stack
    */
    public static int countNumberOfPermutations(int n) {

        int dp[][] = new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                if(i==0){
                    dp[i][j] = 1;
                } else if(j==0){
                    dp[i][j] = dp[i-1][j+1];
                } else {
                    dp[i][j] = dp[i-1][j+1] + dp[i][j-1];
                }
            }
        }

        return dp[n][0];
    }

    public static void main(String[] args) {
        System.out.println(14 == countNumberOfPermutations(4));
        System.out.println(429 == countNumberOfPermutations(7));
    }
}