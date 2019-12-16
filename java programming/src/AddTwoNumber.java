import java.util.LinkedList;
import java.util.Scanner;
public class AddTwoNumber {

	/***
	 * Given two non empty Linked list representing two non-negative integers. The digits are stored in reversed order and each node contain
	 * single digit. Add two numbers and return it as linked list. 
	 */
	public static LinkedList<Integer> addTwoSum(LinkedList<Integer> list1,LinkedList<Integer> list2){	
		int carry = 0;
		int sum = 0;
		int size1 = list1.size();
		int size2 = list2.size();
		int len = size1>=size2?size1:size2;
		LinkedList<Integer> resultList = new LinkedList<Integer>(len+1);
		for (int i=0;i<len;i++) {
			if(i<size1 && i<size2)
				sum = list1.get(i)+list2.get(i)+carry;
			else if(i>=size1)
				sum = list2.get(i)+carry;
			else
				sum = list1.get(i)+carry;
			int unitdigit = sum%10;
			if(sum!=0)
				carry = sum/10;
			resultList.add(unitdigit);	
		}
		if(carry>0)
			resultList.add(carry);
		return resultList;
	}

	public static LinkedList<Integer> takeUserInput(){
		System.out.println("Enter List: ");
		Scanner sc = new Scanner(System.in);
		String list1 = sc.nextLine();
		LinkedList<Integer> inputlist = new LinkedList<Integer>();
		for(String number:list1.split(" "))
			inputlist.add(Integer.parseInt(number));
		return inputlist;
	}
	
	public static void main(String args[]) {
		LinkedList<Integer> outputlist = addTwoSum(takeUserInput(),takeUserInput());
		for(int i=0;i<outputlist.size();i++)
			System.out.println(outputlist.get(i));
	}

}
