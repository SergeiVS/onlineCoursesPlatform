package core.dto.requests;

// Может передаваться с некоторыми пустыми параметрами, но Новый курс должен содержать Имя,
// может содержать ссылки(источник, целевой файл. не могут быть одна без другой) на файл с материалами. Запрос на изменения должен содержать ИД и
// Новую ссылку на файл с материалами. Это надо учитывать при валидации в сервисах.

public class AddChangeCourseDto {

    private final Integer courseId;
    private final String courseName;
    // courseMaterial- ссылка на файл откуда брать материал
    private final String sourceMaterial;

    // courseMaterial- ссылка на файл куда записать материал так можно записывать как информацию о курсе,
    // так и добавлять тесты. В зависимости в какой файл записывается.
    private final String courseMaterial;

    public AddChangeCourseDto(Integer courseId, String courseName, String sourceMaterial, String courseMaterial) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.sourceMaterial = sourceMaterial;
        this.courseMaterial = courseMaterial;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getSourceMaterial() {
        return sourceMaterial;
    }

    public String getCourseMaterial() {
        return courseMaterial;
    }

    @Override
    public String toString() {
        return "AddChangeCourseDto{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", sourceMaterial='" + sourceMaterial + '\'' +
                ", courseMaterial='" + courseMaterial + '\'' +
                '}';
    }
}
