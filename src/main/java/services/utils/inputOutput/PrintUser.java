package services.utils.inputOutput;

import core.dto.responses.ResponsePerson;

public class PrintUser {

    public static void userPrintOut(ResponsePerson person){

        System.out.println("Student id: " + person.getPersonId());
        System.out.println("Name: " + person.getFirstName() + " " + person.getLastName() + ".");
        System.out.println("Course id: " + person.getCourseId());

    }
}
