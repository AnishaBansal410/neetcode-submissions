class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] rank = new int[26];

        for(int i=0;i<order.length();i++){
            rank[order.charAt(i)-'a']=i;
        }

        for(int i=0;i<words.length-1;i++){
            String first = words[i];
            String second = words[i+1];

            int j=0;
            while(j<first.length()){
                if(j==second.length()){
                    return false;
                }
                if(first.charAt(j)!=second.charAt(j)){
                    if(rank[first.charAt(j)-'a']>rank[second.charAt(j)-'a']){
                        return false;
                    }
                    else{
                        break;
                    }
                }
                j++;
            }
        }

        return true;
    }
}