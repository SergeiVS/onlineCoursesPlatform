package core.dto.responses;
import java.util.List;

public class ResponseDto {
    private final List<ResponsePerson> top10BestStudents;

    public ResponseDto(List<ResponsePerson> top10BestStudents) {
        this.top10BestStudents = top10BestStudents;
    }
    public List<ResponsePerson> getTop10BestStudents()
    {
        return top10BestStudents;
    }
}
