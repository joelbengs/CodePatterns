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

   //Factory
   public static Command parse(String[] parts) {
        try {
            var employeeNumber = Utils.toInt(parts[1]);
            var name = parts[2];
            var salary = Utils.toDouble(parts[3]);
            var accountNumber = parts[4];
            return new AddEmployeeCommand(employeeNumber, name, accountNumber, salary);
        } catch (Exception e) {
            return IllegalCommand.parse(parts);
        }
    }
}

