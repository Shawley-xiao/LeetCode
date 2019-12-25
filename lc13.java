import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * lc13
 */
public class lc13 {

    private HashMap<String, Integer> mappings;
    private ArrayList<String> prefixs;

    public lc13() {
        this.mappings = new HashMap<String, Integer>();
        this.mappings.put("I", 1);
        this.mappings.put("V", 5);
        this.mappings.put("X", 10);
        this.mappings.put("L", 50);
        this.mappings.put("C", 100);
        this.mappings.put("D", 500);
        this.mappings.put("M", 1000);
        this.mappings.put("IV", 4);
        this.mappings.put("IX", 9);
        this.mappings.put("XL", 40);
        this.mappings.put("XC", 90);
        this.mappings.put("CD", 400);
        this.mappings.put("CM", 900);

        this.prefixs = new ArrayList<String>();
        this.prefixs.add("I");
        this.prefixs.add("X");
        this.prefixs.add("C");
    }

    public int romanToInt(String s) {
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (flag) {
                flag = false;
                continue;
            }

            String key = s.substring(i, i+1);
            if (this.prefixs.contains(key) && i < s.length() -1) {
                String next = s.substring(i+1, i+2);
                if (this.mappings.containsKey(key + next)) {
                    key += next;
                    flag = true;
                }
            }

            sum += this.mappings.get(key).intValue();
        }

        return sum;
    }

    public static void main(String[] args) {
        lc13 lc = new lc13();
        System.out.println(lc.romanToInt("IX"));
    }
}