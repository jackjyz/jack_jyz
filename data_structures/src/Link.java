public class Link {
      static class ListNode {
          //在这里添加一些注释
          private int val;
          private ListNode next;
          public ListNode(int x) {
              this.val = x;
          }
          public void setVal(int val) {
              this.val = val;
          }
          public ListNode getNext() {
              return next;
          }
          public void setNext(ListNode next) {
              this.next = next;
          }
          public int getVal() {
              return val;
          }
          /*public void addListNode(ListNode listNode){
              if(this.next==null){
                  this.next=listNode;
              }else{
                  this.next.addListNode(listNode);
              }
          }
          public void printListNode(){
              System.out.println(this.val+"-->");
              if(this.next!=null){
                  this.next.printListNode();
              }
          }*/
     }
    /*public void add(int val){
        ListNode newListNode = new ListNode(val);
        System.out.println(val);
        if(this.root==null){
            this.root=newListNode;
        }else {
            this.root.addListNode(newListNode);
        }
    }
    public void print(){
        if(this.root!=null){
            this.root.printListNode();
        }
    }*/

    /**
     * 将链表进行反转的方法
     * 需要将链表的头传入方法
     * 该方法会将反转后的链表头返回出来
     */
   static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode cur = head;
            ListNode next = null;
            ListNode pre = null;
            while (cur.next != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            cur.next = pre;
            return cur;
        }


    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        //Link link = new Link();
        Link.ListNode head = new Link.ListNode(1);
        Link.ListNode link1 = new Link.ListNode(2);
        Link.ListNode link2 = new Link.ListNode(3);
        Link.ListNode link3 = new Link.ListNode(4);
        Link.ListNode link4 = new Link.ListNode(5);
        head.setNext(link1);
        link1.setNext(link2);
        link2.setNext(link3);
        link3.setNext(link4);
        Link.ListNode h = head;
        while (null != h) {//将链表的原序列打印
            System.out.print(h.getVal() + " ");
            h = h.getNext();

        }
        System.out.println();

        ListNode soNode = solution.reverseList(head);

        Link.ListNode h1 = soNode;
        while (null != h1) {//打印反转后的链表
            System.out.print(h1.getVal() + " ");
            h1 = h1.getNext();
        }


    }


}
