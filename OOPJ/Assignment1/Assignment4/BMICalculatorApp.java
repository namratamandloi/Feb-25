import java.util.Scanner;
class BMICalculator
{
	private double height;
    private double weight;
	
	public BMICalculator(double height, double weight){
		this.height = height;
		this.weight = weight;
	}
	
	public double getHeight(){
		return height;
	}
	public void setHeight(double height){
	    this.height = height;
	}
	
	public double getWeight(){
	    return weight;
	}
	public void SetWeight(double weight){
		this.weight = weight;
	}
	public double calculateBMI(){
		return weight/(height * height);
	}
}
class BMICalculatorApp
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your height: ");
        double height = sc.nextDouble();

        System.out.print("Enter your weight: ");
        double weight = sc.nextDouble();
		
        BMICalculator bmi1 = new BMICalculator(height, weight);
        double bmi = bmi1.calculateBMI();
        System.out.println("Your BMI is: " + bmi);

    }
 }

	    