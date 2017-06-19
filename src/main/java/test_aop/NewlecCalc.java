package test_aop;

public class NewlecCalc implements Calc {
	
	private int x;
	private int y;
	
	public void set(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int add(){
		
		int result = x + y;
		
		return result;
	}
	
	public int sub(){
		
		int result = x - y;
		
		return result;
	}
}
