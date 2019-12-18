import java.util.LinkedList;
import java.util.Scanner;
public class SubarrayWithGivenSum {
	public static int[] getSubarrayLocationWithGivenSum(int noOfTestCases, int size, LinkedList<Integer> inputlist, int sum)
	{
		int total = 0 ;
		for(int i=0;i<size;i++) {
			total= inputlist.get(i);
			if(total == sum)
					return new int[] {i+1,i+1};
			for(int j=i+1;j<size && total<sum;j++) {
				total = total+inputlist.get(j);
				if(total == sum)
					return new int[] {i+1,j+1};
			}
		}
		return new int[] {-1};
	}
	public static int[] getSubarrayLocationWithGivenSumV2(int noOfTestCases, int size, LinkedList<Integer> inputlist, int sum)
	{
		int total = 0 ;
		int start = 0;
		for(int i=0;i<size;i++) {
			total= total+inputlist.get(i);
			while(total>sum){
			    total = total - inputlist.get(start);
			    start = start+1;
			}
			if(total == sum)
					return new int[] {start+1,i+1};
			
		}
		return new int[] {-1};
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int noOfTestCases = Integer.parseInt(sc.nextLine());
		for(int j=0;j< noOfTestCases;j++) {
		String[] sizeOfArraySum = sc.nextLine().split(" ");
		
		int size = Integer.parseInt(sizeOfArraySum[0]);
		int sum = Integer.parseInt(sizeOfArraySum[1]);
		
		String list = sc.nextLine();
		LinkedList<Integer> inputlist = new LinkedList<Integer>();
		for(String number:list.split(" "))
			inputlist.add(Integer.parseInt(number));
		
//		Collections.sort(inputlist);
		int[] output = getSubarrayLocationWithGivenSumV2(noOfTestCases,size,inputlist,sum);
		if(output[0] > -1)
			System.out.println(output[0]+" "+output[1]);
		else
			System.out.println(output[0]);
		}
	}
}
