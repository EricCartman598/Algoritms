package merge_lists;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = null;
        ListNode head = null;

        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        while (mergedList == null || mergedList.next != null) {
            boolean firstLessOrEqualsSecond = list1.val <= list2.val;
            ListNode node = firstLessOrEqualsSecond ? new ListNode(list1.val, list1.next) : new ListNode(list2.val, list2.next);
            if(mergedList == null) {
                mergedList = node;
                head = mergedList;
            } else {
                mergedList.next = node;
                mergedList = mergedList.next;
            }

            if (firstLessOrEqualsSecond) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
        }

        ListNode lastNode = list1 == null ? new ListNode(list2.val, list2.next) : new ListNode(list1.val, list1.next);
        mergedList.next = lastNode;
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node13 = new ListNode(4, null);
        ListNode node12 = new ListNode(2, node13);
        ListNode node11 = new ListNode(1, node12);

        ListNode node23 = new ListNode(4, null);
        ListNode node22 = new ListNode(3, node23);
        ListNode node21 = new ListNode(1, node22);

        System.out.println(new MergeTwoSortedLists().mergeTwoLists(node11, node21));
    }

}
