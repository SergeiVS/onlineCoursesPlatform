package core.entity;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private Integer courseId;
    private  String courseName;
    private boolean isActive;
    private List<String> material;

    public Integer getCourseId() {
        return courseId;
    }

    public Course(Integer courseId, String courseName, boolean isActive, List<String> material) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.isActive = isActive;
        this.material = material;
    }

    public String getCourseName() {
        return courseName;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<String> getMaterial() {
        return material;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setMaterial(List<String> material) {
        this.material = material;
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", isActive=" + isActive +
                ", material=" + material +
                '}';
    }
}
