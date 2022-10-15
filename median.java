//Enes Kalinsazlioglu
import java.util.*;
public class cmsc401{
	
	public static int[] getArr() 
    {
		Scanner sc = new Scanner(System.in);
		int n;				
		n = sc.nextInt();
		int[] ys = new int[n];
		int[] sizes = new int[n];
		
		for (int i = 0; i < n; i++) {
			ys[i] = sc.nextInt();
			sizes[i] = sc.nextInt();
		}
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += sizes[i];
		}
		int[] mainA = new int[sum];
		int j=0;
		for (int i = 0; i < n; i++) {			
			switch (sizes[i]) {
			  case 1:
				mainA[j] = ys[i];
				j++;
			    break;
			  case 2:
				mainA[j] = ys[i];
				mainA[j+1] = ys[i];
				j+=2;
			    break;
			  case 3:
				mainA[j] = ys[i];
				mainA[j+1] = ys[i];
				mainA[j+2] = ys[i];
				j+=3;
			    break;
			}
		}
		sc.close();
		return mainA;       
    }
	
	public static int[] swap (int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        return A;
    }
	
	public static int Partition (int A[], int p, int r) 
	{
		int x = A[r];
		int i = p-1;
		for (int j=p; j<=r-1; j++) {
			if (A[j] <= x) {
				i++;
				A = swap(A, i, j);
			}
		}
		A = swap(A, i+1, r);
		return i+1;
	}
	
	static int md1, md2;		
    
	public static int setY(int A[], int p, int r, int middle)
    { 
        if (p <= r)
        {
        	int n = r - p + 1;
            int x = (int) (Math.random() % n);
            A = swap(A, p + x, r);
        	int q = Partition(A, p, r);
 
            if (q == middle)
                md2 = A[q];
            else if (q == middle - 1)
                md1 = A[q];
            
            if (q >= middle)         
            	setY(A, p, q - 1, middle);
            else
                setY(A, q + 1, r, middle);
        }
 
        return 0;
    }
		    	     
    public static void main(String[] args) 
    {
    	int A[] = getArr();
    	int n = A.length;
    	int y;

    	setY(A, 0, n - 1, n / 2);
        
    	if (n % 2 == 1)
            y = md2;
        else
            y = (md1 + md2) / 2;
 
        System.out.print(y);

	}
}
