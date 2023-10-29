package com.zainco.screenshotuitesting

object RotateArray { // something like a game which reverses all the array then the first k-1 ones then the k -> n-1
    @JvmStatic
    fun main(args: Array<String>) {
        val array = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        rotate(array, 3)
        array.forEach {
            print("$it,")
        }
    }

    fun rotate(nums: IntArray, k: Int) {
        reverse(nums, 0, nums.size - 1)
        reverse(nums, 0, k - 1)
        reverse(nums, k, nums.size - 1)
    }

    fun reverse(nums: IntArray, firstIndex: Int, lastIndex: Int) {
        var firstIndexPointer = firstIndex
        var lastIndexPointer = lastIndex
        while (firstIndexPointer<lastIndexPointer){
            val temp = nums[lastIndexPointer]
            nums[lastIndexPointer--] = nums[firstIndexPointer]
            nums[firstIndexPointer++] = temp
        }
    }
}