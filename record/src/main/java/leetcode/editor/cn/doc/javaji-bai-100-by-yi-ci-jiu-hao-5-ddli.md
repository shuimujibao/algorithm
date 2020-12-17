
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre=head,post=head,node=head;
        ListNode p=head;
        int len=0;
        while(p!=null){//记录节点的个数
            p=p.next;
            len++;
        }
        if(len==n){//如果要删除头节点那么只需要将头节点后移即可
            head=head.next;
            return head;
        }
       for(int i=0;i<n;i++){
            node=node.next;//让该节点与头节点距离n个节点的长度
        }
        while(node!=null){//之后进行后移即可
            pre=post;//保存前一个节点
            post=post.next;////保存后一个节点
            node=node.next;
        }
        //结束while循环之后此时post节点就是倒数第n个节点，删除即可
        pre.next=post.next;
        post.next=null;
        return head;//返回头节点
    }
}