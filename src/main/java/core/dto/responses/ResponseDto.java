package core.dto.responses;
import java.util.List;

public class ResponseDto {
    private (List<ResponsePerson> top10BestStudents) {
        this.top10BestStudents = top10BestStudents;
    }
    public List<ResponsePerson> getTop10BestStudents() {
        return top10BestStudents;
    }
    public void setTop10BestStudents(List<ResponsePerson>) {
        this.top10BestStudents = top10BestStudents;
    }
}
