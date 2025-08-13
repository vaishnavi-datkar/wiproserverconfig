package com.wipro.loop;

/*public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int arr[]=new int[] {1, 1, 2, 2, 3, 4, 4, 5};
				int count=arr.length;
			for(int i=0;i<arr.length-1;i++) {
				if(arr[i]== arr[i+1]){
					count=count-1;
					
				} 
			}
				System.out.println("Length of the array after removing duplicates." + count);
	}

} */
public class Array {

    public static void main(String[] args) {
        int arr[] = new int[] {1, 1, 2, 2, 3, 4, 4, 5};
        int n = arr.length;

       
        int[] temp = new int[n];
        int j = 0;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp[j++] = arr[i];
            }
        }

        temp[j++] = arr[n - 1]; 

        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < j; i++) {
            System.out.print(temp[i] + " ");
        }

        System.out.println("\nLength of array after removing duplicates: " + j);
    }
}

