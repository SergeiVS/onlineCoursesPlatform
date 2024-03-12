package org.onlinecoursesplatform;

import UI.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.*;
import services.personServices.AddPersonService;
import services.personServices.LogInService;
import services.utils.fileReder.ReadCourseFromFile;
import services.utils.fileReder.ReadPassesFromFile;
import services.utils.fileReder.ReadPersonDatabaseFromFile;
import services.utils.fileWriter.AddPasswordToIntoFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class OnlineCoursesPlatformApplication {

    public static void main(String[] args) throws IOException {

        ReadCourseFromFile readCourseFromFile = new ReadCourseFromFile();
        ReadPassesFromFile readPassesFromFile = new ReadPassesFromFile();
        ReadPersonDatabaseFromFile personDatabaseFromFile = new ReadPersonDatabaseFromFile();
        AddPasswordToIntoFile addPasswordToIntoFile = new AddPasswordToIntoFile();
        PersonRepository personRepository = new PersonRepository(personDatabaseFromFile.readFromFile("src/main/resources/persons/PersonsDatabase.txt"));
        CoursesRepository coursesRepository = new CoursesRepository();
        Passwords passwords = new Passwords(readPassesFromFile.readFromFile("src/main/resources/PassesDatabase"));
        TestsRepository testsRepository = new TestsRepository();
        LogInService logInService = new LogInService(personRepository, passwords);
        Grades gradesRepository = new Grades();
        AddPersonService addPersonService = new AddPersonService(personRepository, passwords);
        MainMenu mainMenu = new MainMenu();
        LogInMenu logInMenu = new LogInMenu(logInService);
        RegisterNewUser registerNewUserMenu = new RegisterNewUser(addPersonService);
        GetCourseInformationMenu getCourseInformationMenu = new GetCourseInformationMenu();
        StudentMenu studentMenu = new StudentMenu();
        AdminMenu adminMenu = new AdminMenu();

        List<UIInterface> menus = new ArrayList<>();
        menus.add(mainMenu);
        menus.add(logInMenu);
        menus.add(registerNewUserMenu);
        menus.add(getCourseInformationMenu);
        menus.add(studentMenu);
        menus.add(adminMenu);
        MenuSwitcher menuSwitcher = new MenuSwitcher(menus);
        menuSwitcher.execute();


    }


}
