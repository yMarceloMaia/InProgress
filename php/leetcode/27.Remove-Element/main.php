<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $val
     * @return Integer
     */
    function removeElement(&$nums, $val) {
      $newNums = [];

      for ($i = 0; $i < count($nums); $i++) {
        $v = $nums[$i];
        if($v !== $val) {
          array_push($newNums, $v);
        }
      }
      
      $nums = $newNums;
    }
}


$solution = new Solution();

$arr = [0,1,2,2,3,0,4,2];

$result = $solution->removeElement($arr, 2);

print_r($result);

?>