import java.util.HashMap;
import java.util.Map;

/***
 * Given an array of Integers, Find Two number such that they add up to specific target number.
 * The function CalculateTwoSum should return the indices of two number such that add they add to the target
 * where index1 < intex2 and both should be non zero.
 * each input have exactly one solution
 */
public class TwoSum {

	public static int[] CalcutateTwoSum(int target,int numbers[]) {
		Map<Integer,Integer> numberMap = new HashMap<Integer,Integer>();
		for(int i=0;i<numbers.length;i++)
			numberMap.put(numbers[i], i);

		for(int i=0;i<numbers.length;i++) {
			int newTarget = target - numbers[i];
			if(numberMap.containsKey(newTarget) && i!= numberMap.get(newTarget))
				return new int[] {i+1,numberMap.get(newTarget)+1};
		}
		
		return null;
	}

	public static void main(String args[]) {
		int []numbers = {3,2,4};
		int target = 6;

		int[] result = CalcutateTwoSum(target,numbers);
		if (result!=null){
			for(int i=0;i<result.length;i++) {
				System.out.println(""+result[i]);
			}
		}else {
			System.out.println("pair not found");
		}
	}
}
