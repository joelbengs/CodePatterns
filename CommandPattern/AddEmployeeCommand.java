class AddEmployeeCommand implements Command {
    private int employeeNumber;
    private String name, accountNumber;
    private double salary;

    public AddEmployeeCommand(int employeeNumber, String name, String accountNumber, double salary) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.accountNumber = accountNumber;
        this.salary = salary;
    }

    public void execute(Database db, PaymentSystem ps){
        db.addEmployee(employeeId, name, accountNumber);
        db.setSalary(employeeId, salary);
   }
}

