class Solution {

    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> combine(int n, int k) {
        
        int[] arr = new int[n];

        used = new boolean[n];

        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }

        backtrack(new ArrayList<>(),arr,0,k);

        return res;
    }

    public void backtrack(List<Integer> tmp,int[] nums,int st,int k){
        if(tmp.size()==k){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=st;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            tmp.add(nums[i]);
            backtrack(tmp,nums,i+1,k);
            tmp.remove(tmp.size()-1);
            used[i] = false;
        }
    }
}