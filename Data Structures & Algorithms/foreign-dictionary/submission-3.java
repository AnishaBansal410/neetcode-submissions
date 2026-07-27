class Solution {
    public String foreignDictionary(String[] words) {
        List<Set<Character>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new HashSet<>());
        }

        int[] indegree = new int[26];
        boolean[] present = new boolean[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = true;
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int j = 0;
            while (j < w1.length() && j < w2.length()) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    char from = w1.charAt(j);
                    char to = w2.charAt(j);

                    if (adj.get(from - 'a').add(to)) {
                        indegree[to - 'a']++;
                    }
                    break;
                }
                j++;
            }

            // invalid prefix case: "abc" before "ab"
            if (j == w2.length() && w1.length() > w2.length()) {
                return "";
            }
        }

        return findOrder(adj, present, indegree);
    }

    public String findOrder(List<Set<Character>> adj, boolean[] present, int[] indegree) {
        Queue<Character> q = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        int total = 0;

        for (int i = 0; i < 26; i++) {
            if (present[i]) {
                total++;
                if (indegree[i] == 0) {
                    q.offer((char) ('a' + i));
                }
            }
        }

        while (!q.isEmpty()) {
            char c = q.poll();
            ans.append(c);

            for (char neighbor : adj.get(c - 'a')) {
                indegree[neighbor - 'a']--;
                if (indegree[neighbor - 'a'] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        if (ans.length() != total) {
            return "";
        }

        return ans.toString();
    }
}