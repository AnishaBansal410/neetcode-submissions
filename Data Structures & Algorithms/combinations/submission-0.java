class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        // boolean[] used = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(arr,0,new ArrayList<>(),ans,k);
        return ans;
    }

    public void backtrack(int[] arr,int start,List<Integer> tmp,List<List<Integer>> ans,int k){
        if(tmp.size()==k){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<arr.length;i++){
            tmp.add(arr[i]);
            backtrack(arr,i+1,tmp,ans,k);
            tmp.remove(tmp.size()-1);
        }
    }
}