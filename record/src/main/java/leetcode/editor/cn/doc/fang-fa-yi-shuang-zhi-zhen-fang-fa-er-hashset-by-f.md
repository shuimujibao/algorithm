### 解题思路
1. 方法一：双指针
   cur指针和curPrev指针，指向当前结点和当前结点之前的结点
   判断是否两个辅助指针的val关系，如果相等就删除掉cur指针，并且更新cur指针，如果不相等，两个指针都后    移，知道cur指针为空
2. 方法二：HashSet
   循环遍历链表，如果当前值在HashSet中没有出现，则将值add进集合，如果出现就删除该结点
   为了方便删除结点，可以新建一个空结点，指向链表头，用该结点进行遍历


```双指针 []
class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null||head.next==null) return head;
		ListNode cur = head.next;
		ListNode curPrev = head;
		while(cur!=null) {
			if(cur.val == curPrev.val) {
				curPrev.next = cur.next;
				cur = curPrev.next;
			}
			else if(cur.val != curPrev.val) {
				curPrev=cur;
				cur = cur.next;
			}
		}
		return head;
	}
}
```
```HashSet []
class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		ListNode countPrev = new ListNode(-1);
		countPrev.next = head;
		while (countPrev.next != null) {
			if (hashSet.contains(countPrev.next.val)) {
				// ListNode temp=countPrev.next;
				countPrev.next = countPrev.next.next;
				// temp.next=null;
			} else {
				hashSet.add(countPrev.next.val);
				countPrev = countPrev.next;
			}
		}
		return head;
	}
}
```

