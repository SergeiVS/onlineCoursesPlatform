package core.dto.requests;

// Может передаваться с некоторыми пустыми параметрами, но Новый курс должен содержать Имя,
// может содержать ссылки(источник, целевой файл. не могут быть одна без другой) на файл с материалами. Запрос на изменения должен содержать ИД и
// Новую ссылку на файл с материалами. Это надо учитывать при валидации в сервисах.

public class AddChangeCourseDto {

    private final Integer courseId;
    private final String courseName;
    // sourceMaterial- ссылка на файл откуда брать материал, это поле при создании курса может остаться пустым,
    // но при пустых материалах и/или тестах курс не может быть активным.
    private final String materialSource;


    public AddChangeCourseDto(Integer courseId, String courseName, String sourceMaterial) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.materialSource = sourceMaterial;

    }

    public Integer getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getMaterialSource() {
        return materialSource;
    }


    @Override
    public String toString() {
        return "AddChangeCourseDto{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", sourceMaterial='" + materialSource + '\'' +
                '}';
    }
}
