import java.util.Scanner;
public class SubarrayWithGivenSumV2 {
	
	public static int[] subarrayWithGivenSum(int noOfTestCases, int size, int[] inputlist, int sum)
	{
		int total = 0 ;
		int start = 0;
		for(int i=0;i<size;i++) {
			total= total+inputlist[i];
			while(total>sum){
				total = total - inputlist[start];
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
		for(int j=0;j<noOfTestCases;j++) {
			String[] sizeOfArraySum = sc.nextLine().split(" ");
			int size = Integer.parseInt(sizeOfArraySum[0]);
			int sum = Integer.parseInt(sizeOfArraySum[1]);

			String list = sc.nextLine();
			String[] number = list.split(" ");
			int[] inputlist = new int[size];
			for(int i=0;i<number.length;i++)
				inputlist[i] = Integer.parseInt(number[i]);

			int[] output = subarrayWithGivenSum(noOfTestCases,size,inputlist,sum);
			if(output[0] > -1)
				System.out.println(output[0]+" "+output[1]);
			else
				System.out.println(output[0]);
		}
	}



}
