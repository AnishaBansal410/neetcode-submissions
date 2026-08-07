class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet set = new DisjointSet(new int[edges.length]);
        for(int[] edge : edges){
            int pu = set.find(edge[0]-1);
            int pv = set.find(edge[1]-1);

            if(pu==pv){
                return edge;
            }
            set.union(edge[0]-1,edge[1]-1);
        }
        return new int[0];
    }
}

class DisjointSet{
    int[] vertices;
    int[] parent;
    int[] rank;

    public DisjointSet(int[] arr){
        this.vertices = arr;
        this.parent = new int[arr.length];
        this.rank = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            parent[i] = i;
            rank[i]=1;
        }
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);   // Path compression
        }
        return parent[x];
    }

    public void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return;

        if(rank[pu] < rank[pv]){
            parent[pu] = pv;
        }
        else if(rank[pv] < rank[pu]){
            parent[pv] = pu;
        }
        else{
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}