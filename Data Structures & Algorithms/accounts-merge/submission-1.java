class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        DSU dsu = new DSU(n);
        Map<String, Integer> emailToAcc = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                Integer existing = emailToAcc.putIfAbsent(email, i);

                if (existing != null) {
                    dsu.union(i, existing);
                }
            }
        }

        Map<Integer, List<String>> emailGroups = new HashMap<>();

        for (String email : emailToAcc.keySet()) {
            int leader = dsu.find(emailToAcc.get(email));

            emailGroups.computeIfAbsent(leader, key -> new ArrayList<>())
                       .add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry : emailGroups.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);

            List<String> merged = new ArrayList<>(emails.size() + 1);
            merged.add(accounts.get(entry.getKey()).get(0));
            merged.addAll(emails);

            result.add(merged);
        }

        return result;
    }
}

class DSU {
    private final int[] parent;
    private final int[] size;

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (size[rootX] < size[rootY]) {
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }

        parent[rootY] = rootX;
        size[rootX] += size[rootY];
    }
}