package Entities;

/**
 *
 * @author IceCreamSandwich
 */
public abstract class Persona {
    private String name;
    private String lastName;
    private int age;
    private String city;
    private String career;

    public Persona() {
        this.name = "---------";
        this.lastName = "---------";
        this.age = -1;
        this.city = "---------";
        this.career = "---------";
    }

    public Persona(String name, String lastName, int age, String city, String career) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
        this.career = career;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
    
    
}
