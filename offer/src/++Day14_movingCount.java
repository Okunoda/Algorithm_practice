/**
 * @author Okunoda
 * @date 2023年03月08日22:04
 */
class Day14_movingCount {

    /**
     * @author GCBZB
     * @date 2023/3/8 23:01
     * 我的没剪枝版本，能通过，耗时192ms
     */
    public int movingCount(int m, int n, int k) {
        path = new int[m][n];
        this.m = m;
        this.n = n;
        dfs(k, 0, 0);
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (path[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    int[][] path;
    int m, n;

    private void dfs(int k, int ii, int jj) {
        if (total(ii, jj) > k || ii >= m || jj >= n || path[ii][jj] == 1) {
            return;
        } else {
            path[ii][jj] = 1;
        }
        for (int i = ii; i < m; i++) {
            for (int j = jj; j < n; j++) {
                dfs(k, ii + 1, jj);
                dfs(k, ii, jj + 1);
            }
        }

    }

    private int total(int n, int m) {
        int res = 0;
        while (n != 0) {
            res += n % 10;
            n /= 10;
        }
        while (m != 0) {
            res += m % 10;
            m /= 10;
        }
        return res;
    }

    /**
     * 作者：jyd
     * 链接：https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 佬的剪枝版本，耗时    ** 0ms **
     */
    class Solution {
        int m, n, k;
        boolean[][] visited;

        public int movingCount(int m, int n, int k) {
            this.m = m;
            this.n = n;
            this.k = k;
            this.visited = new boolean[m][n];
            return dfs(0, 0, 0, 0);
        }

        public int dfs(int i, int j, int si, int sj) {
            if (i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
            visited[i][j] = true;
            return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
        }
    }
}
