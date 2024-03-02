package core.dto.requests;

public class activateDeactivateCourseDto {

    private final Integer courseId;
    private final boolean isActive;

    public activateDeactivateCourseDto(Integer courseId, boolean isActive) {
        this.courseId = courseId;
        this.isActive = isActive;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "activateDeactivateCourseDto{" +
                "courseId=" + courseId +
                ", isActive=" + isActive +
                '}';
    }
}
