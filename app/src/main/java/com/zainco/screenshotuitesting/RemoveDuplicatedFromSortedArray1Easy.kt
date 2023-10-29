package com.zainco.screenshotuitesting

object RemoveDuplicatedFromSortedArray1Easy {
    @JvmStatic
    fun main(args: Array<String>) {
        println(removeDuplicates(intArrayOf(1, 1, 1, 2, 2, 3)))
    }

    fun removeDuplicates(nums: IntArray): Int {
        var j = 1
        if  (nums.size == 1)
            return nums.size
        for (n in nums){
            if(n != nums[j-1]){
                nums[j++] = n
            }
        }
        return j
    }
}