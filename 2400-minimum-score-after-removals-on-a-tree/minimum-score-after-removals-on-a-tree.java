import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {

    private List<List<Integer>> adj;
    private int[] values;
    private int[] subtreeXor;
    private int[] tin;
    private int[] tout;
    private int timer;

    private void dfs(int u, int parent) {
        tin[u] = timer++;
        subtreeXor[u] = values[u];
        for (int v : adj.get(u)) {
            if (v == parent) {
                continue;
            }
            dfs(v, u);
            subtreeXor[u] ^= subtreeXor[v];
        }
        tout[u] = timer++;
    }

    private boolean isAncestor(int u, int v) {
        return tin[u] < tin[v] && tout[u] > tout[v];
    }

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.values = nums;

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        subtreeXor = new int[n];
        tin = new int[n];
        tout = new int[n];
        timer = 0;

        dfs(0, -1);

        int totalXor = subtreeXor[0];

        int minScore = Integer.MAX_VALUE;

        List<Integer> cutNodesForEdges = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (isAncestor(u, v)) {
                cutNodesForEdges.add(v);
            } else {
                cutNodesForEdges.add(u);
            }
        }

        int numEdges = edges.length;
        for (int i = 0; i < numEdges; i++) {
            for (int j = i + 1; j < numEdges; j++) {
                int node1 = cutNodesForEdges.get(i);
                int node2 = cutNodesForEdges.get(j);

                int xor1, xor2, xor3;

                if (isAncestor(node1, node2)) {
                    xor1 = subtreeXor[node2];
                    xor2 = subtreeXor[node1] ^ subtreeXor[node2];
                    xor3 = totalXor ^ subtreeXor[node1];
                }
                else if (isAncestor(node2, node1)) {
                    xor1 = subtreeXor[node1];
                    xor2 = subtreeXor[node2] ^ subtreeXor[node1];
                    xor3 = totalXor ^ subtreeXor[node2];
                }
                else {
                    xor1 = subtreeXor[node1];
                    xor2 = subtreeXor[node2];
                    xor3 = totalXor ^ subtreeXor[node1] ^ subtreeXor[node2];
                }

                int currentMax = Math.max(xor1, Math.max(xor2, xor3));
                int currentMin = Math.min(xor1, Math.min(xor2, xor3));
                minScore = Math.min(minScore, currentMax - currentMin);
            }
        }

        return minScore;
    }
}