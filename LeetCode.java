import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * leetCode
 */
public class LeetCode {

    // 70.爬楼梯
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        Integer cache = map.get(Integer.valueOf(n));
        if (cache != null) {
            return cache.intValue();
        }

        int result = climbStairs(n-1) + climbStairs(n-2);
        map.put(n, Integer.valueOf(result));
        return result;
    }

    // 88.合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int offset1 = 1;
        int offset2 = 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (offset2 > n) {
                break;
            }

            if (offset1 <= m && nums1[m-offset1] >= nums2[n-offset2]) {
                nums1[i] = nums1[m-offset1];
                offset1++;
            } else {
                nums1[i] = nums2[n-offset2];
                offset2++;
            }
        }
    }

    // 104. 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        int maxDeep = 0;
        while (root.left != null || root.right != null) {
            if (root.left != null) {
                root = root.left;
                maxDeep++;
            }

            if (root.right != null) {
                
            }
        }

        return maxDeep;
    }

    // 121.卖出股票的最佳时机
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > max) {
                    max = profit;
                }
            }
        }

        return max;
    }

    // 121.卖出股票的最佳时机 II
    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        int sumMinPrice = Integer.MAX_VALUE;
        int sumProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (maxProfit < prices[i] - minPrice) {
                maxProfit = prices[i] - minPrice;
            }

            if (prices[i] < sumMinPrice) {
                sumMinPrice = prices[i];
            } else {
                sumProfit += prices[i] - sumMinPrice;
                sumMinPrice = Integer.MAX_VALUE;
            }
        }

        return Math.max(maxProfit, sumProfit);
    }

    // 136.只出现一次的数字
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num ^= nums[i];
        }

        return num;
    }

    Set<ListNode> hash_set = new HashSet<ListNode>();

    // 141.环形链表检测
    public boolean hasCycle(ListNode head) {
        while (head != null) {
            if (hash_set.contains(head)) {
                return true;
            }

            hash_set.add(head);
            head = head.next;
        }

        return false;
    }

    // 160.相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null || headB != null) {
            if (hash_set.contains(headA)) {
                return headA;
            } else if (hash_set.contains(headB)) {
                return headB;
            }
            
            hash_set.add(headA);
            headA = headA.next;
            hash_set.add(headB);
            headB = headB.next;
        }

        return null;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer valueI = Integer.valueOf(nums[i]);
            Integer value = map.get(valueI);
            if (value == null) {
                value = Integer.valueOf(1);
            } else {
                value = Integer.valueOf(value.intValue() + 1);
            }

            map.put(valueI, value);
            if (value.intValue() > nums.length / 2) {
                return value;
            }
        }

        return -1;
    }

    // 206.反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            ListNode node = list.get(i);
            if (i > 0) {
                node.next = list.get(i-1);
            } else {
                node.next = null;
            }
        }

        return list.get(0);
    }

    // 206.反转链表 双指针法
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode preNode = head;
        ListNode nextNode = preNode.next;
        head.next = null;
        while (nextNode != null) {
            ListNode currentNode = nextNode;
            nextNode = nextNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
        }

        return preNode;
    }

    // 217.存在重复元素
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hash_set = new HashSet<>();
        for (int num : nums) {
            if (hash_set.contains(num)) {
                return true;
            }

            hash_set.add(num);
        }

        return false;
    }

    // 231.2的幂
    public boolean isPowerOfTwo(int n) {
        return (n & (n-1)) == 0;
    }

    // 292. Nim 游戏
    public boolean canWinNim(int n) {
        return n > 0 && n % 4 != 0;
    }
    
    // 344. 反转字符串
    public void reverseString(char[] s) {
        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            char temp = s[i];
            s[i] = s[length-i-1];
            s[length-i-1] = temp;
        }
    }

    // LCP1. 猜数字
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < answer.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        LeetCode lc = new LeetCode();
        int[] a1 = new int[] {1, 1, 1, 0, 0, 0};
        int[] a2 = new int[] {1, 2, 3};
        lc.merge(a1, 3, a2, 3);
        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i]);
        }
    }
}