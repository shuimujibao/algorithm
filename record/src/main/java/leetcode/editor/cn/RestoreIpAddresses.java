package leetcode.editor.cn;

//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
// 和 "192.168@1.1" 是 无效的 IP 地址。 
//
// 
//
// 示例 1： 
//
// 输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 460 👎 0

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> ret = new ArrayList<>();

            StringBuilder ip = new StringBuilder();

            for (int a = 1; a < 4; ++a)
                for (int b = 1; b < 4; ++b)
                    for (int c = 1; c < 4; ++c)
                        for (int d = 1; d < 4; ++d) {
                            if (a + b + c + d == s.length()) {
                                int n1 = Integer.parseInt(s.substring(0, a));
                                int n2 = Integer.parseInt(s.substring(a, a + b));
                                int n3 = Integer.parseInt(s.substring(a + b, a + b + c));
                                int n4 = Integer.parseInt(s.substring(a + b + c));
                                if (n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {
                                    ip.append(n1).append('.').append(n2).append('.').append(n3).append('.').append(n4);
                                    if (ip.length() == s.length() + 3) {
                                        ret.add(ip.toString());
                                    }
                                    ip.delete(0, ip.length());
                                }
                            }
                        }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}