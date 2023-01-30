package org.example;

import java.util.Stack;

public class Solution {
    // thế nào là một chuỗi string con valid nghĩa là bao gồm các bộ "()" hoặc "(())" hoặc "((()))" liên tiếp
    // kiểu dạng gồm các chuỗi ngoặc đơn đối xứng
    // Chính xác hơn thì nó tìm một substring có độ dài chẵn và có số lượng "(" = số lượng ")", thì sẽ luôn
    // tìm được vị trí đối xứng của một cặp () là khe giữa các phần tử dù ở bất kì vị trí nào
    // Thuật toán sau sử dụng stack và method kiểm tra rỗng của nó để kiếm tra tính đối xứng của substring
    // được pass in bằng cách kiểm tra số lượng "(" và số lượng ")" có bằng nhau hay không
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); // Declare stack chứa các kí tự cần thiết
        for (int i = 0; i < s.length(); i++) { // for loop String pass in
            if (s.charAt(i) == '(') {
                stack.push('('); // Nếu kí tự tại vị trí thứ i là "(" thì đẩy vào stack đã declare
            } else if (!stack.empty() && stack.peek() == '(') { // Nếu stack không rỗng và phần tử trên cùng hay
                // cuối cùng == "(" thì giữ giá trị nó vào trong method pop và remove nó
                stack.pop();
            } else {
                return false; // nếu 2 if statement trên dều không được thi hành thì trả lại giá trị boolean cho
                // method to bao ngoài
            }
        }
        return stack.empty(); // Nếu 1 trong 2 if statement được thi hành đến khi kết thúc loop ( không thi hành lệnh else lần nào)
        // thì lấy giá trị boolean từ method empty của stack
    }
    public int longestValidParentheses(String s) {
        int maxlen = 0; // declare biến int lưu giá trị của độ dài valid paratheses lớn nhất cần tính
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (isValid(s.substring(i, j))) { // substring bao gồm các phần tử từ vị trí i đến vị trí j-1
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }
}
