import java.util.ArrayList;
import java.util.List;

/**
 * lc14
 */
public class lc14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 ) {
            return "";
        }

        String firstStr = strs[0];
        if (firstStr.length() == 0) {
            return "";
        }

        int offset = 0;
        for (int i = 0; i < firstStr.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(firstStr.substring(0, i+1))) {
                    return offset > 0 ?firstStr.substring(0, offset) :"";
                }
            }

            offset++;
        }

        return firstStr;
    }

    public static void main(String[] args) {
        lc14 lc = new lc14();
        String[] strs = new String[]{"abcde", "egeabcdc", "abcdereab"};
        System.out.println(lc.longestCommonPrefix(strs));
    }
}