class MockDatabase implements Database {

    private record Employee(String name,
                            String accountNumber,
                            double salary) {}
    private Map<Integer, Employee> employees = new HashMap<>();

    public boolean addEmployee(int employeeId,
                               String name,
                               String accountNumber) {
        System.out.printf("  -> Adding %d (%s), with account number %s\n",
                          employeeId,
                          name,
                          accountNumber);
        employees.put(employeeId,
                      new Employee(name, accountNumber, 0.0));
        return true;
    }

    public boolean setSalary(int employeeId,
                             double salary) {
        System.out.printf("  -> Sets salary of %d to %.2f\n",
                          employeeId,
                          salary);
        if (employees.containsKey(employeeId)) {
            var emp = employees.get(employeeId);
            employees.put(employeeId,
                          new Employee(emp.name,
                                       emp.accountNumber,
                                       salary));
            return true;
        } else {
            return false;
        }
    }

    public double getSalary(int employeeId) {
        return
            Optional
            .ofNullable(employees.get(employeeId))
            .map(e -> e.salary)
            .orElse(0.0);
    }

    public String getAccountNumber(int employeeId) {
        return
            Optional
            .ofNullable(employees.get(employeeId))
            .map(e -> e.accountNumber)
            .orElse("<unknown>");
    }
}