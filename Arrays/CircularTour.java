/*
    Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
    1. The amount of petrol that every petrol pump has.
    2. Distance from that petrol pump to the next petrol pump.
    Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
    Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.
*/

import java.util.*;

class First_Circular_tour {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            String arr[] = str.split(" ");
            int p[] = new int[n];
            int d[] = new int[n];
            int j = 0;
            int k = 0;
            for (int i = 0; i < 2 * n; i++) {
                if (i % 2 == 0) {
                    p[j] = Integer.parseInt(arr[i]);
                    j++;
                } else {
                    d[k] = Integer.parseInt(arr[i]);
                    k++;
                }
            }

            System.out.println(new GfG().tour(p, d));
            t--;
        }
    }
}

/*
 * Go till totalPetrol > tolalDistance 
 * start fresh from point it fails above condition since all other solution before that include this point of failure
 * (no need cosider them).
 *  O(n) time complexity
 */
class GfG {
    int tour(int petrol[], int distance[]) {
        int n = petrol.length;
        for (int i = 0; i < n; i++) {
            int j = 0;
            int currIndex = (i + j) % n;
            int totalPetrol = petrol[currIndex];
            int totalDistance = distance[currIndex];

            while (j < n && totalPetrol >= totalDistance) {
                j++;
                int nextIndex = (i + j) % n;
                totalPetrol += petrol[nextIndex];
                totalDistance += distance[nextIndex];
            }

            if (j == n)
                return i;
            else if (j > i) {
                i = j;
            }
        }

        return -1;
    }
}