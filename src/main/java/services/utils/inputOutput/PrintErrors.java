package services.utils.inputOutput;

import core.dto.errors.ErrorsDto;

import java.util.List;

public class PrintErrors {

    public static void printErrorsList(List<ErrorsDto> errors){

        for (ErrorsDto error : errors){
            System.out.println(error.getErrorCode() + " : " + error.getMessage());
        }
    }
}
