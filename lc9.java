/**
 * lc9
 */
public class lc9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int temp = x;
        int ans = 0;
        while (temp != 0) {
            ans = ans * 10 + temp % 10;
            temp /= 10;
        }

        return ans == x;
    }

    public static void main(String[] args) {
        lc9 l = new lc9();
        System.out.println(l.isPalindrome(121111));
    }
}