import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * lc20
 */
public class lc20 {

    public boolean isValid(String s) {
        Map<String, String> s_map = new HashMap<String, String>() {{
            put(")", "(");
            put("]", "[");
            put("}", "{");
        }};

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            String exist = null;
            if (!list.isEmpty()) {
                exist = list.get(list.size() - 1);
            }

            String s_sub = s.substring(i, i+1);
            String s_sub_pop = s_map.get(s_sub);
            if (exist != null && s_sub_pop != null && exist.contentEquals(s_sub_pop)) {
                list.remove(list.size() - 1);
            } else {
                list.add(s_sub);
            }
        }

        return list.isEmpty();
    }

    public static void main(String[] args) {
        lc20 lc = new lc20();
        System.out.println(lc.isValid("[([]])"));
    }
}