package OOPSem6;

class Worker {
    private final String name;
    private final String lastName;
    private final float salary;
    private final Passport passport;
    private final int phoneNumber;
    private final byte cabinet;
    private Worker(EmployeeBuilder employeeBuilder) {
        name = employeeBuilder.name;
        lastName = employeeBuilder.lastName;
        salary = employeeBuilder.salary;
        passport = employeeBuilder.passport;
        phoneNumber = employeeBuilder.phoneNumber;
        cabinet = employeeBuilder.cabinet;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public float getSalary() {
        return salary;
    }
    public Passport getPassport() {
        return passport;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public byte getCabinet() {
        return cabinet;
    }
    public static class EmployeeBuilder {
        private String name;
        private String lastName;
        private float salary;
        private Passport passport;
        private int phoneNumber;
        private byte cabinet;

        //constructor for required fields
        public EmployeeBuilder(String lastName) {
            this.lastName = lastName;
        }

        //setter methods for optional fields
        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public EmployeeBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public EmployeeBuilder setSalary(float salary) {
            this.salary = salary;
            return this;
        }
        public EmployeeBuilder setPassport(Passport passport) {
            this.passport = passport;
            return this;
        }
        public EmployeeBuilder setPhoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public EmployeeBuilder setCabinet(byte cabinet) {
            this.cabinet = cabinet;
            return this;
        }

        //Build the Employee object
        public Worker build() {
            return new Worker(this);
        }
    }
    @Override
    public String toString() {
        String outName = name == null ? "" : "name='" + name + '\'' + ", ";
        return
                "Worker{" +
                        outName +
                        "lastName='" + lastName + '\'' +
                        ", salary=" + salary +
                        ", passportId=" + passport +
                        ", phoneNumber=" + phoneNumber +
                        ", cabinet=" + cabinet +
                        '}';
    }
}
