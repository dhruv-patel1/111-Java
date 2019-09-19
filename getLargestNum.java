
public class getLargestNum {
	public static void main (String[]args) {
		int [] nums = {3,5,43,2,24,66,78654,2,4567854};
		int x = getLargest(nums);
		System.out.print(x);
	}
	public static int getLargest(int[]nums) {
		int maxValue = nums[0];
	    for (int i = 1; i < nums.length; i++) {
	        if (nums[i] > maxValue) {
	            maxValue = nums[i];
	        }
	    }
	    return maxValue;
	}

}
