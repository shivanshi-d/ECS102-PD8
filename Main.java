public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Interest Calculator!");
        Loan loan1 = new Loan(5000, 6.75, 12.5, 4);
        System.out.println("Loan 1: Simple Interest: $" + loan1.calculateSimpleInterest());
        System.out.println("Loan 1 Total Repayment: $" + loan1.calculateTotalRepayment());

    } //main method
}
