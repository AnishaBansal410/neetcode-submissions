class Solution {
    String[] digitsToChar = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return ans;
        }
        backtrack(digits,0,new StringBuilder());
        return ans;
    }

    public void backtrack(String digits,int idx,StringBuilder sb){
        if(sb.length()==digits.length()){
            ans.add(sb.toString());
            return;
        }
        
        for(int i=idx;i<digits.length();i++){
            for(char c : digitsToChar[digits.charAt(i)-'0'].toCharArray()){
                sb.append(c);
                backtrack(digits,i+1,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
