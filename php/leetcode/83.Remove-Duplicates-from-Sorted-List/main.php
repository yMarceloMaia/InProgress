<?php

/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val = 0, $next = null) {
 *         $this->val = $val;
 *         $this->next = $next;
 *     }
 * }
 */
class Solution {

  /**
   * @param ListNode $head
   * @return ListNode
   */
  function deleteDuplicates($head) {
    $dummy = new ListNode(0);
    $curr = $dummy;

    while ($head != null) {
      if ($head->next == null || $head->val != $head->next->val) {
        $curr->next = $head;
        $curr = $curr->next;
      }
      $head = $head->next;
    }

    $curr->next = null;
  
    return $dummy->next;
  }
}