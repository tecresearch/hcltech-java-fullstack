package java8.lambda_expression;

public class Main {
	public static void main(String[] args) {

		Adable obj = (a, b) -> {
			System.out.println(a + b);
			return a;
		};
		obj.add(4, 7);
		
		MyComperator cpr=(a,b)->{
			return a>b;
		};
		
		boolean status=cpr.compare(12,30);
		System.out.println(status);
	}
}

@FunctionalInterface
interface MyComperator{
	boolean compare(int a1,int b1);
}
