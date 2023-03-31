package Portfolio.orgStructure;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    /**
     * Employee's id - first number in the line of the structure.scv
     */
    private Long id;

    /**
     * Employeee's boss id - second number (after ;) in the line of the structure.csv.
     * If no boss id is indicated, the entry refers to the CEO, who has no boss
     */
    private Long bossId;

    /**
     * Employee's name
     */
    private String name;

    /**
     * Employee's position
     */
    private String position;

    /**
     * Refers to employee's boss (if any)
     */
    private Employee boss;

    /**
     * List of direct subordinates of an employee
     */
    private final List<Employee> subordinate = new ArrayList<>();
    public Long getId() {
        return id;
    }

    /**
     * Sets emplyee's id
     * @param id employee's id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns employee's boss id (if any)
     * @return emplyee's boss id
     */
    public Long getBossId() {
        return bossId;
    }

    /**
     * Sets employee's boss id (if any)
     * @param bossId employee's boss id
     */
    public void setBossId(Long bossId) {
        this.bossId = bossId;
    }

    /**
     * Returns employee's name
     * @return employee's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets employee's name
     * @param name employee's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns employee's position
     * @return employee's position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets employee's position
     * @param position employee's position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Returns reference to employee's boss
     * @return reference to employee's boss
     */
    public Employee getBoss() {
        return boss;
    }

    /**
     * Sets reference to employee's boss
     * @param boss reference to employee's boss
     */
    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    /**
     * Returns list of direct subordinates of the employee
     * @return list of direct subordinates of the employee
     */
    public List<Employee> getSubordinate() {
        return subordinate;
    }

    /**
     * Returns employee's id, bossId, name, position and names of his / her subordinates
     * @return employee's id, bossId, name, position and names of his / her subordinates
     */
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", bossId=" + bossId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' + ", подчиненные: " +
                this.getSubordinate().stream().map(Employee::getName).toList() +
                '}';
    }
}
