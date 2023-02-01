package OOPSem6;

public class Passport {
    private long id;
    private String name;
    private String lastName;
    private long dateOfBirth;
    private float dateOfGiven;
    private long departmentCode;
    public long getId() {
        return id;
    }
    public Passport setId(long id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }
    public Passport setName(String name) {
        this.name = name;
        return this;
    }
    public String getLastName() {
        return lastName;
    }
    public Passport setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public float getDateOfBirth() {
        return dateOfBirth;
    }
    public Passport setDateOfBirth(long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }
    public float getDateOfGiven() {
        return dateOfGiven;
    }
    public Passport setDateOfGiven(float dateOfGiven) {
        this.dateOfGiven = dateOfGiven;
        return this;
    }
    public long getDepartmentCode() {
        return departmentCode;
    }
    public Passport setDepartmentCode(long departmentCode) {
        this.departmentCode = departmentCode;
        return this;
    }
    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfGiven=" + dateOfGiven +
                ", departmentCode=" + departmentCode +
                '}';
    }
}
