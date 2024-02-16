class Solution {
    public int maxDepth(String s) {
        Stack <Character> a=new Stack<>();
        int m=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                a.push(s.charAt(i));
            }
            else if(s.charAt(i)==')' && !a.isEmpty()){
                m=Math.max(m,a.size());
                a.pop();
            }
        }
    return m;
    }
}