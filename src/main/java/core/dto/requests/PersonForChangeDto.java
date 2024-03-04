package core.dto.requests;

//используется для передачи в систему новых параметров пользователя. поле ИД и как минимум одно из оставшихся полей
// должны быть заполнены
public class PersonForChangeDto {
    private final Integer personId;
    private final Integer courseId;
    private final String accessType;

    public PersonForChangeDto(Integer personId, Integer courseId, String accessType) {
        this.personId = personId;
        this.courseId = courseId;
        this.accessType = accessType;
    }

    public Integer getPersonId() {
        return personId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public String getAccessType() {
        return accessType;
    }

    @Override
    public String toString() {
        return "PersonForChangeDto{" +
                "personId=" + personId +
                ", courseId=" + courseId +
                ", accessType='" + accessType + '\'' +
                '}';
    }
}
