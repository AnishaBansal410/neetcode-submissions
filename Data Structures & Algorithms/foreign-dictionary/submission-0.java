class Solution {
    public String foreignDictionary(String[] words) {
        List<Character>[] adj = new ArrayList[26];
        for(int i=0;i<26;i++){
            adj[i]=new ArrayList<>();
        }

        int[] indegree = new int[26];

        boolean[] present = new boolean[26];

        for(String word:words){
            for(Character c : word.toCharArray()){
                present[c-'a']=true;
            }
        }

        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];

            int j=0;
            while(j<w1.length()){
                if(j==w2.length()){
                    return "";
                }
                if(w1.charAt(j)!=w2.charAt(j)){
                    adj[w1.charAt(j)-'a'].add(w2.charAt(j));
                    indegree[w2.charAt(j)-'a']++;
                    break;
                }
                else{

                }
                j++;
            }
        }

        return findOrder(adj,present,indegree);
    }

    public String findOrder(List<Character>[] adj , boolean[] present, int[] indegree){

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

        while(!q.isEmpty()){
            Character c = q.poll();
            ans.append(c);
            for(Character neighbor : adj[c-'a']){
                indegree[neighbor-'a']--;
                if(indegree[neighbor-'a']==0){
                    q.offer(neighbor);
                }
            }
        }
        
        if(ans.length()!=total){
            return "";
        }
        
        return ans.toString();
    }
}
