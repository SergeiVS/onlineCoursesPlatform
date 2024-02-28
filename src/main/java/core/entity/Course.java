package core.entity;

import java.util.List;

public class Course {

    private String name;
    private boolean isActive;
    private String material;
    private List<String> tests;

    public Course(String name, boolean isActive, String material, List<String> tests) {
        this.name = name;
        this.isActive = isActive;
        this.material = material;
        this.tests = tests;
    }

    public String getName() {
        return name;
    }

   public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public List<String> getTests() {
        return tests;
    }

    public void setTests(List<String> tests) {
        this.tests = tests;
    }
}
