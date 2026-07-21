class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode next=null;
        ListNode previous=null;
        while(cur!=null){
            next=cur.next;
            cur.next=previous;
            previous=cur;
            cur=next;
        }
        return previous;
    }
}
