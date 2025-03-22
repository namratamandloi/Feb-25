class ElectricityBill
{
	String customerName;
	double unitsConsumed;
	double billAmount;
	
	public ElectricityBill(String customerName, double unitsConsumed) throws IllegalArgumentException{
		this.customerName = customerName;
		if(unitsConsumed>0){
			this.unitsConsumed = unitsConsumed;
		} else {
				throw new IllegalArgumentExcepotion();
				}
		}
		
	public void calculateBillAmount() {
        if (unitsConsumed <= 100) {
            billAmount = unitsConsumed * 5;
        } else if (unitsConsumed <= 300) {
            billAmount = 100 * 5 + (unitsConsumed - 100) * 7;
        } else {
            billAmount = 100 * 5 + 200 * 7 + (unitsConsumed - 300) * 10;
        }
    }
	
	public void displayBill() {
        System.out.println("Name: " + name);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Total Bill Amount: Rs. " + billAmount);
    }
}

class ElectricityBillDemo
{
	public static void main(String args[])
	{
        Scanner sc = new Scanner(System.in);

        try {
            
            System.out.print("Enter the customer's name: ");
            String customerName = sc.nextLine();

            System.out.print("Enter the units consumed: ");
            double unitsConsumed = sc.nextDouble();

            ElectricityBill eb = new ElectricityBill(customerName, unitsConsumed);
            bill.calculateBillAmount();
            bill.displayBill();

        } catch (InputMismatchException e) {
           e.printStackException();
        } catch (IllegalArgumentException e) {
			e.printStackException();
        } 
		double billAmount = eb.calculateBillAmount();
		
    }
}