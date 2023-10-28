package com.zainco.screenshotuitesting

object RemoveDuplicatedFromSortedArray2 {
    @JvmStatic
    fun main(args: Array<String>) {
        println(removeDuplicates(intArrayOf(1, 1, 1, 2, 2, 3)))
    }

    fun removeDuplicates(nums: IntArray): Int {
        var i = 0
        for (n in nums) {
            if (i < 2 || n != nums[i - 2]) {
                nums[i++] = n
            }
        }
        return i
    }
}