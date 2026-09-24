
 
import java.util.Scanner;

public class MonthlyExpenseAnalyzer {
   
    static int[] expenseIds = new int[50];       
    static double[] expenseAmounts = new double[50]; 
    static String[] expenseCategories = new String[50]; 
    static int count = 0; 
    static double monthlyBudget = 0;

    
    public static void addExpense(int id, double amount, String category) {
        expenseIds[count] = id;
        expenseAmounts[count] = amount;
        expenseCategories[count] = category;
        count++;
        System.out.println("Expense added successfully!");
    }

    public static void viewExpenses() {
        System.out.println("=== All Expenses ===");
        for (int i = 0; i < count; i++) {
            System.out.println("ID: " + expenseIds[i] +
                               " | Amount: " + expenseAmounts[i] +
                               " | Category: " + expenseCategories[i]);
        }
    }

    public static void searchExpense(int id) {
        boolean found = false;
        for (int i = 0; i < count; i++) { 
            if (expenseIds[i] == id) { 
                System.out.println("Found Expense → ID: " + expenseIds[i] +
                                   " | Amount: " + expenseAmounts[i] +
                                   " | Category: " + expenseCategories[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Expense not found!");
        }
    }

    public static void showBudgetSummary() {
        double totalExpense = 0;
        for (int i = 0; i < count; i++) {
            totalExpense += expenseAmounts[i];
        }
        System.out.println("Monthly Budget: " + monthlyBudget);
        System.out.println("Total Expenses: " + totalExpense);
        System.out.println("Remaining Balance: " + (monthlyBudget - totalExpense));

        
        if (totalExpense > monthlyBudget) {
            System.out.println(" Overspending Alert!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Monthly Budget: ");
        monthlyBudget = sc.nextDouble();

        while (true) {
            System.out.println("\n===== MONTHLY EXPENSE & BUDGET ANALYZER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Search Expense");
            System.out.println("4. View Budget Summary");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();


            switch (choice) {
                case 1:
                    System.out.print("Enter Expense ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine(); 
                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();
                    addExpense(id, amount, category); 
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    System.out.print("Enter Expense ID to search: ");
                    int searchId = sc.nextInt();
                    searchExpense(searchId);
                    break;

                case 4:
                    showBudgetSummary();
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}


