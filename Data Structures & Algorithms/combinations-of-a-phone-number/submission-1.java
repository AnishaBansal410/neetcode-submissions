class Solution {

    String[] digitsToChar = {"","","abc","def","ghi","jkl","mno","qprs","tuv","wxyz"};

    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return ans;
        }
        backtrack(digits,new StringBuilder(),0);
        return ans;
    }

    public void backtrack(String digits,StringBuilder sb,int st){
        if(sb.length()==digits.length()){
            ans.add(sb.toString());
            return;
        }
        String curr = digitsToChar[digits.charAt(st)-'0'];
        
        for(char c : curr.toCharArray()){
            sb.append(c);
            backtrack(digits,sb,st+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
