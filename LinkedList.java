// Template 1: Iterative reversal 
ListNode prev = null, curr = head;
while (curr != null) {
    ListNode next = curr.next;  // save before overwrite
    curr.next = prev;
    prev = curr;
    curr = next;
}
return prev; // new head

// Template 2: Dummy Head + Two-Pointer Merge/Splice
ListNode dummy = new ListNode(-1);
ListNode tail = dummy;
while (l1 != null && l2 != null) {
    if (l1.val <= l2.val) { tail.next = l1; l1 = l1.next; }
    else { tail.next = l2; l2 = l2.next; }
    tail = tail.next;
}
tail.next = (l1 != null) ? l1 : l2;
return dummy.next;

// Template 3: Fast/Slow Pointer (cycle / middle)
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow == fast) { /* cycle detected */ }
}

// Template 4: Dummy + Gap for Nth-from-end
ListNode dummy = new ListNode(0, head);
ListNode fast = dummy, slow = dummy;
for (int i = 0; i < n; i++) fast = fast.next;
while (fast.next != null) { fast = fast.next; slow = slow.next; }
slow.next = slow.next.next;
return dummy.next;
