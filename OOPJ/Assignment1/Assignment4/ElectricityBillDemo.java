import java.util.Scanner;
class ElectricityBil{
	String name;
	double unitsConsumed;
	double billAmount=0;
	
	public ElectricityBil(String name, double unitsConsumed){
		this.name = name;
		this.unitsConsumed = unitsConsumed;
		}
	 public void calculateBilAmount() {
        if (unitsConsumed <= 100) {
            billAmount = unitsConsumed * 5;
        } else if (unitsConsumed <= 300) {
            billAmount = 100 * 5 + (unitsConsumed - 100) * 7;
        } else {
            billAmount = 100 * 5 + 200 * 7 + (unitsConsumed - 300) * 10;
        }
    }
    public void displayBil() {
        System.out.println("Name: " + name);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Total Bill Amount: Rs. " + billAmount);
    }
}

class ElectricityBillDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter units consumed: ");
        double unitsConsumed = sc.nextDouble();
        ElectricityBil bill = new ElectricityBil(name, unitsConsumed);
        bill.calculateBilAmount();
        bill.displayBil();
    }
}
	
