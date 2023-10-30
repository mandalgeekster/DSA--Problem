// Java program for the above approach
public class Main
{
	// Initial size of
	// the Array
	static int Max = 5;
	
	// Array for the stack
	// implementation
	static int[] arr = new int[Max];
	
	// Stores the minimum
	// Element of the stack
	static int minEle = 0;
	
	// Stores the top element
	// of the stack
	static int Top = 0;
	
	// Method to check whether
	// stack is empty or not
	static boolean empty()
	{
		if (Top <= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	// Method to push elements
	// to the Special Stack
	static void push(int x)
	{
		// If stack is empty
		if (empty()) {
	
			// Assign x to minEle
			minEle = x;
	
			// Assign x to arr[top]
			arr[Top] = x;
	
			// Increment top by 1
			Top++;
		}
		// If array is full
		else if (Top == Max) {
	
			// Update the Max size
			Max = 2 * Max;
	
			int[] temp = new int[Max];
	
			// Traverse the array arr[]
			for (int i = 0; i < Top; i++) {
				temp[i] = arr[i];
			}
	
			// If x is less than minEle
			if (x < minEle) {
	
				// Push 2*x-minEle
				temp[Top] = 2 * x - minEle;
	
				// Assign x to minEle
				minEle = x;
	
				Top++;
			}
			// Else
			else {
	
				// Push x to stack
				temp[Top] = x;
				Top++;
			}
			// Assign address of the
			// temp to arr
			arr = temp;
		}
		else {
			// If x is less
			// than minEle
			if (x < minEle) {
	
				// Push 2*x-minEle
				arr[Top] = 2 * x - minEle;
				Top++;
	
				// Update minEle
				minEle = x;
			}
			else {
				// Push x to the
				// stack
				arr[Top] = x;
				Top++;
			}
		}
	}
	// Method to pop the elements
	// from the stack.
	static void pop()
	{
		// If stack is empty
		if (empty()) {
			System.out.print("Underflow");
			return;
		}
		// Stores the top element
		// of the stack
		int t = arr[Top - 1];
	
		// If t is less than
		// the minEle
		if (t < minEle) {
			// Pop the minEle
			System.out.println("Popped element : " + minEle);
	
			// Update minEle
			minEle = 2 * minEle - t;
		}
		// Else
		else {
			// Pop the topmost element
			System.out.println("Popped element : " + t);
		}
		Top--;
		return;
	}
	
	// Method to find the topmost
	// element of the stack
	static int peek()
	{
		// If stack is empty
		if (empty()) {
			System.out.println("Underflow");
			return -1;
		}
	
		// Stores the top element
		// of the stack
		int t = arr[Top - 1];
	
		// If t is less than
		// the minEle
		if (t < minEle) {
			return minEle;
		}
		// Else
		else {
			return t;
		}
	}
	// Method to find the Minimum
	// element of the Special stack
	static int getMin()
	{
		// If stack is empty
		if (empty()) {
			System.out.println("Underflow");
			return -1;
		}
		// Else
		else {
			return minEle;
		}
	}
	
// Driver code
	public static void main(String[] args) {
		push(10);
		push(4);
		push(9);
		push(6);
		push(5);
		
		System.out.println("Top Element : " + peek());
		
		System.out.println("Minimum Element : " + getMin());
		
		pop();
		pop();
		pop();
		pop();
		
		System.out.println("Top Element : " + peek());
		System.out.println("Minimum Element : " + getMin());
	}
}
