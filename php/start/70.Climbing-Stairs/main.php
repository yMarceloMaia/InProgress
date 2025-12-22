<?php

class Solution {
  /**
   * @param Integer $n
   * @return Integer
   */
  function climbStairs($n) {
    if ($n <= 2) return $n;
    
    $prev2 = 1;
    $prev1 = 2;

    for ($i = 3; $i <= $n; $i++) {
        $current = $prev1 + $prev2;
        $prev2 = $prev1;
        $prev1 = $current;
    }

    return $prev1;
  }
}

$solution = new Solution();
$result = $solution->climbStairs(28);

print_r($result);