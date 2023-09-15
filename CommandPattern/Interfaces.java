interface Database {
    boolean addEmployee(int employeeId,
                        String name,
                        String accountNumber);
    boolean setSalary(int employeeId,
                      double salary);
    double getSalary(int employeeId);
    String getAccountNumber(int employeeId);
}

interface PaymentSystem {
    void transfer(String fromAccount,
                  String toAccount,
                  double amount);
}

//Step one: Define the interface for a general command
interface Command {
    void execute(Database db, PaymentSystem ps);
}
