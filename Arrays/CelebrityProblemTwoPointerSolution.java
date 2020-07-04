/*
In a party of N people, only one person is known to everyone. Such a person may be present in the party, 
if yes, (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “.
Find the stranger (celebrity) in the minimum number of questions.
https://www.geeksforgeeks.org/the-celebrity-problem/
*/

public class CelebrityProblem {

    /*
     * Two pointer solution( A=0 and B=n-1) if A knows B then A can't be celebrity
     * else B can't be celebrity, Update pointers accordingly
     */
    static int getCelebrity(int[][] arr, int m) {
        int i = 0, j = m - 1;
        while (i < j) {
            if (knows(arr, i, j)) {
                i++;
            } else {
                j--;
            }
        }
        for (int k = 0; k < m; k++) {
            if (k != i && (knows(arr, i, k) || !knows(arr, k, i)))
                return -1;
        }
        return i;
    }

    static boolean knows(int[][] arr, int i, int j) {
        if (arr[i][j] == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

        System.out.println(2 == getCelebrity(matrix, matrix.length));

        int matrix2[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };

        System.out.println(-1 == getCelebrity(matrix2, matrix2.length));
    }
}