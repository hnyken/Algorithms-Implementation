public class MyClass {

  public static void main(String[] Args){
		int[] A = {13, -3 , -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15,-4, 7};
		int[] MaxSubArray = getMaxSubArray(A, 0, A.length-1);
		for(int i = MaxSubArray[0]; i <= MaxSubArray[1];i++)
			System.out.print(A[i] +"\t");
		System.out.println("Max Sum : " + MaxSubArray[2]);
	}

  private static int[] getMaxSubArray(int A[], int low, int high){
		int[] MaxArray = {0,0,0};
		if(high == low){
			MaxArray[0] = low;MaxArray[1] = high;MaxArray[2] = A[low];
			return MaxArray;
		}else{
			int mid = (low + high)/2;
			int[] LeftSubArray = getMaxSubArray(A, low, mid);
			int[] RightSubArray  = getMaxSubArray(A, mid+1, high);
			int[] CrossSubArray = getMaxCrossingSubArray(A, low, mid, high);
			if(LeftSubArray[2] >= RightSubArray[2] && LeftSubArray[2] >= CrossSubArray[2])
				return LeftSubArray;
			else if(RightSubArray[2] >= LeftSubArray[2] && RightSubArray[2] >= CrossSubArray[2])
				return RightSubArray;
			else
				return CrossSubArray;
		} 
	} 
  	
	private static int[] getMaxCrossingSubArray(int[] A, int low, int mid, int high){
		int[] MaxArray = {0,0,0};
		int LeftSum = -99999, Sum = 0;
		int MaxLeft = mid;
		for(int i = mid; i >=low;i--){
			Sum += A[i];
			if(Sum > LeftSum){
				LeftSum = Sum;
				MaxLeft = i;
			}
		}
		int RightSum = -99999, MaxRight = mid;
		Sum = 0;
		for(int j = mid+1;j<=high;j++){
			Sum += A[j];
			if(Sum > RightSum){
				RightSum = Sum;
				MaxRight = j;
			}
		}
		MaxArray[0] = MaxLeft;
		MaxArray[1] = MaxRight;
		MaxArray[2] = LeftSum + RightSum;
		return MaxArray; 
	}
}
