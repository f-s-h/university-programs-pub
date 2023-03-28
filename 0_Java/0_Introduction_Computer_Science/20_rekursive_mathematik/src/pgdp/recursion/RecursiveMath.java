package pgdp.recursion;

public class RecursiveMath {

	public static long binomCoeffIterative(int n, int k) {
		if (k == 0 || n == k) {
			return 1;
		}
		if (k > n) {
			return 0;
		}
		long result = 1;
		for (int i = 1; i <= k; i++) {
			result *= n + 1 - i;
			result /= i;
		}
		return result;
	}

	public static long binomCoeffRecursive(int n, int k) {
		if(n == k | k == 0){
			return 1L;
		}
		if(k > n){
			return 0L;
		}

		long b1 = binomCoeffRecursive(n-1, k-1);
		long b2 = binomCoeffRecursive(n-1, k);

		return b1 + b2;
	}

	public static long binomCoeffEndRec(int n, int k) {
		if(n == k | k == 0){
			return 1L;
		}
		if(k > n){
			return 0L;
		}

		return binomCoeffEndRec(n-1, k-1) + binomCoeffEndRec(n-1, k);
	}

	public static long fibonacciIterative(int n) {
		if (n <= 0) {
			return 0;
		}
		long last = 1;
		long current = 0;
		long tmp;
		for (int i = 0; i < n; i++) {
			tmp = last + current;
			last = current;
			current = tmp;
		}
		return current;
	}

	public static long fibonacciRecursive(int n) {
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		long f1 = fibonacciRecursive(n - 1);
		long f2 = fibonacciRecursive(n - 2);
		return f1 + f2;
	}

	public static long fibonacciEndRec(int n) {
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		return fibonacciEndRec(n-1) + fibonacciEndRec(n-2);
	}
}
