string postToInfix(string postfix) {
    int n = postfix.length();
    stack<string> st;
    for (int i = 0; i < n; i++) {
        if ('a' <= postfix[i] && postfix[i] <= 'z')
            st.push(string(1, postfix[i]));
        else if ('A' <= postfix[i] && postfix[i] <= 'Z')
            st.push(string(1, postfix[i]));
        else {
            string v1 = st.top();
            st.pop();
            string v2 = st.top();
            st.pop();
            st.push('(' + v2 + postfix[i] + v1 + ')');
        }
    }
    return st.top();
}