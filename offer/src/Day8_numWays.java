/**
 * @author Okunoda
 * @date 2023年02月27日18:27
 */
public class Day8_numWays {
    public int numWays(int n) {
     int[] ways = new int[n+1];
     ways[0] = 1;
     ways[1] = 1;
     ways[2] = 2;
     for(int i = 0 ; i < n ; i++){
            ways[i] = ways[i-1] + ways[ i -2 ];
        }
     return ways[ n ];
    }
}
