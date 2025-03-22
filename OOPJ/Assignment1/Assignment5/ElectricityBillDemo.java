import java.util.Scanner;
import java.util.InputMismatchException;
class ElectricityBill{
	String customerName;
	double unitsConsumed;
	double billAmount=0;
	
	ElectricityBill(String name, double unitsConsumed) throws IllegalArgumentException{
		this.customerName = name;
		if(unitsConsumed>0){
			this.unitsConsumed = unitsConsumed;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	double calculateBillAmount(){
		if(unitsConsumed>=300){
			billAmount = 1900 + ((unitsConsumed-300)*10);
		} else if(unitsConsumed<300 && unitsConsumed>100){
			billAmount = 500 + ((unitsConsumed-100)*7);
		} else {
			billAmount = unitsConsumed*5;
		}
		return billAmount;
	}
}
class ElectricityBillDemo{
	public static void main(String[] args){
		String name = "";
		double d =  0.0;
		ElectricityBill eb = null;
		Scanner sc = new Scanner(System.in);
		try{
			name = sc.nextLine();
			d = sc.nextDouble();
			eb = new ElectricityBill(name, d);
		} catch (InputMismatchException e){
			e.printStackTrace();
		} catch (IllegalArgumentException e){
			e.printStackTrace();
		}
		
		double billAmount = eb.calculateBillAmount();
		System.out.println("Customer: " + name + ", Units Consumed: " + d + ", Bill: " + billAmount);
	}
}