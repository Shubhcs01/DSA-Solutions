class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        // make graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        return countComponent(graph);
    }

    private int countComponent(List<Integer>[] graph) {
        int count = 0;
        int v = graph.length;
        boolean[] vis = new boolean[v + 1];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, graph, vis);
            }
        }
        return count;
    }

    private void dfs(int node, List<Integer>[] graph, boolean[] vis) {
        vis[node] = true;
        //call neighbours
        for (Integer nbr : graph[node]) {
            if (!vis[nbr]) {
                dfs(nbr, graph, vis);
            }
        }
    }
}