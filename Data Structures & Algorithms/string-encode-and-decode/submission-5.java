class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s:strs){
            int len = s.length();
            sb.append(String.valueOf(len));
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        int i=0;
        
        while(i<str.length()){
            int j=i;
            while(j<str.length() && str.charAt(j)!='#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            j++;
            ans.add(str.substring(j,j+len));
            i=j+len;
        }

        return ans;
    }
}
