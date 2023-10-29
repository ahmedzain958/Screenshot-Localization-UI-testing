package com.zainco.screenshotuitesting

object RotateArray {
    @JvmStatic
    fun main(args: Array<String>) {
        println(removeDuplicates(intArrayOf(1, 1, 1, 2, 2, 3)))
    }

    fun rotate(nums: IntArray, k: Int) {
        var k = k
        var i = nums.size - 2
        while (i > 0) {
            val temp = nums[nums.size - 1]
            nums[i + 1] = nums[i]
            i--

        }
    }
}