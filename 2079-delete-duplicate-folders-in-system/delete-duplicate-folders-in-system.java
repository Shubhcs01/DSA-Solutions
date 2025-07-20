class Solution {

    // 1. Build Trie
    // 2. Seliarlize + markk duplicate (dfs)
    // 3. Delete duplicate

    static class TrieNode {
        Map<String, TrieNode> children = new TreeMap<>();
        boolean isEnd = false;
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {

        // Build trie ds
        TrieNode root = new TrieNode(); // "/"
        for (List<String> path : paths) {
            TrieNode curr = root;
            for (String name : path) {
                if (!curr.children.containsKey(name)) {
                    curr.children.put(name, new TrieNode());
                }
                curr = curr.children.get(name); // point to next node
            }
        }

        // Seliarize trie tree to string
        Map<String, List<TrieNode>> map = new HashMap<>();
        encode(root, map);

        // mark duplicate
        for (List<TrieNode> group : map.values()) {
            if (group.size() > 1) {
                for (TrieNode n : group) {
                    n.isEnd = true;
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        // collect result without duplicates
        collect(root, new ArrayList<>(), result);
        return result;
    }

    // DFS
    private String encode(TrieNode node, Map<String, List<TrieNode>> map) {

        if (node.children.isEmpty())
            return "[]"; // leaf node

        List<String> parts = new ArrayList<>();
        for (String name : node.children.keySet()) {
            TrieNode child = node.children.get(name);
            String sub = encode(child, map);
            parts.add(name + sub);
        }

        Collections.sort(parts);
        String signature = "[" + String.join("", parts) + "]";

        if (!map.containsKey(signature)) {
            map.put(signature, new ArrayList<>());
        }
        map.get(signature).add(node);

        return signature;
    }

    //  DFS
    private void collect(TrieNode node, List<String> path, List<List<String>> res) {

        for (String name : node.children.keySet()) {

            TrieNode child = node.children.get(name);
            if (child.isEnd) continue; // skip duplicate subtree

            path.add(name);
            res.add(new ArrayList<>(path));
            collect(child, path, res);
            path.remove(path.size() - 1);
        }
    }
}