class Solution {
    String[] digitsToChar = {"","","abc","def","ghi","jkl","mno","qprs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()){
            return ans;
        }
        
        backtrack(ans,new StringBuilder(),0,digits);
        return ans;
    }

    public void backtrack(List<String> ans,StringBuilder tmp,int i,String digits){

        if(tmp.length()==digits.length()){
            ans.add(new StringBuilder(tmp).toString());
            return;
        }
        String curr = digitsToChar[digits.charAt(i)-'0'];
        for(char ct : curr.toCharArray()){
            tmp.append((char)ct);
            backtrack(ans,tmp,i+1,digits);
            tmp.deleteCharAt(tmp.length()-1);
        }
        
    }
}
