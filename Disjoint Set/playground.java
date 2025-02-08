
 class Disjoint{
    int[] parent;
    int[] size;
    int[] rank;

    public Disjoint(int n){
        parent = new int[n+1];
        size = new int[n+1];
        rank = new int[n+1];

        for(int i = 0; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
            rank[i] = 0;
        }
    }

    public int findParent(int node){
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }

    public void unionByRank(int u , int v){
        int up = findParent(u);
        int vp = findParent(v);

        if(up == vp) return;

        if(rank[up] < rank[vp]){
            parent[up] = vp;
        }else if(rank[up] > rank[vp]){
            parent[vp] = up;
        }else{
            parent[vp] = up;
            rank[up] += 1;
        }
    }

    public void unionBySize(int u , int v){
        int up = findParent(u);
        int vp = findParent(v);

        if(up == vp) return;

        if(size[up] < size[vp]){
            parent[up] = vp;
            size[vp] += size[up];
        }else{
            parent[vp] = up;
            size[up] += size[vp];
        }
    }
 }