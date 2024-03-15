package org.onlinecoursesplatform;

import UI.*;
import repository.*;
import services.TestLoader;
import services.TestRepositoryService;
import services.analytics.GetStudentGrades;
import services.curseServices.AddCourseService;
import services.curseServices.FindCourseServices;
import services.personServices.AddPersonService;
import services.personServices.FindPersonService;
import services.personServices.LogInService;
import services.personServices.SetPersonOnCourseService;
import services.testing.TestForPassing;
import services.testing.TestResult;
import services.utils.fileReder.ReadCourseFromFile;
import services.utils.fileReder.ReadPassesFromFile;
import services.utils.fileReder.ReadPersonDatabaseFromFile;

import services.utils.fileReder.ReadTestFromFile;
import services.utils.fileWriter.AddPasswordToIntoFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class OnlineCoursesPlatformApplication {

    public static void main(String[] args) throws IOException {

        ReadCourseFromFile readCourseFromFile = new ReadCourseFromFile();
        ReadPassesFromFile readPassesFromFile = new ReadPassesFromFile();
        ReadPersonDatabaseFromFile personDatabaseFromFile = new ReadPersonDatabaseFromFile();
        ReadTestFromFile testFromFile = new ReadTestFromFile();

        AddPasswordToIntoFile addPasswordToIntoFile = new AddPasswordToIntoFile();
        repository.PersonRepository personRepository = new repository.PersonRepository(personDatabaseFromFile.readFromFile("src/main/resources/persons/PersonsDatabase.txt"));
        repository.CoursesRepository coursesRepository = new repository.CoursesRepository();
        repository.Passwords passwords = new repository.Passwords(readPassesFromFile.readFromFile("src/main/resources/PassesDatabase"));
        repository.TestsRepository testsRepository = new repository.TestsRepository();
        Grades gradesRepository = new Grades();

        LogInService logInService = new LogInService(personRepository, passwords);
        FindCourseServices findCourseServices = new FindCourseServices(coursesRepository);
        AddPersonService addPersonService = new AddPersonService(personRepository, passwords);
        TestForPassing testForPassing = new TestForPassing(personRepository,gradesRepository, testsRepository);
        SetPersonOnCourseService setPersonOnCourseService = new SetPersonOnCourseService(personRepository);
        AddCourseService addCourseService = new AddCourseService(coursesRepository, readCourseFromFile);
        TestRepositoryService testRepositoryService = new TestRepositoryService(testsRepository, testFromFile);
        FindPersonService findPersonService = new FindPersonService(personRepository);
        TestResult testResult = new TestResult(personRepository,gradesRepository, testsRepository);
        TestLoader testLoader = new TestLoader(testRepositoryService);
        GetStudentGrades getStudentGrades = new GetStudentGrades(gradesRepository, personRepository);

        MainMenu mainMenu = new MainMenu();
        LogInMenu logInMenu = new LogInMenu(logInService);
        RegisterNewUser registerNewUserMenu = new RegisterNewUser(addPersonService);
        GetCourseInformationMenu getCourseInformationMenu = new GetCourseInformationMenu(findCourseServices);
        StudentMenu studentMenu = new StudentMenu();
        AdminMenu adminMenu = new AdminMenu();
        RegisterOnCourseMenu registerOnCourseMenu = new RegisterOnCourseMenu(setPersonOnCourseService);
        TestingMenu testingMenu = new TestingMenu(testForPassing, testResult);
        AddChangeCourseMenu changeCourseMenu = new AddChangeCourseMenu(addCourseService);
        AddTestMenu addTestMenu = new AddTestMenu(testRepositoryService);
        GetGradesMenu getGradesMenu = new GetGradesMenu(getStudentGrades);
        FindPersonByIdMenu findPersonByIdMenu = new FindPersonByIdMenu();
        GetAllPersonsMenu getAllPersonsMenu = new GetAllPersonsMenu(findPersonService);
        GetBestStudentsMenu getBestStudentsMenu = new GetBestStudentsMenu();

        List<UIInterface> menus = new ArrayList<>();

        menus.add(mainMenu);
        menus.add(logInMenu);
        menus.add(registerNewUserMenu);
        menus.add(getCourseInformationMenu);
        menus.add(studentMenu);
        menus.add(adminMenu);
        menus.add(registerOnCourseMenu);
        menus.add(testingMenu);
        menus.add(8,getGradesMenu);
        menus.add(9, findPersonByIdMenu);
        menus.add(10, getAllPersonsMenu);
        menus.add(11,getAllPersonsMenu);
        menus.add(12,changeCourseMenu);
        menus.add(13,addTestMenu);

        addCourseService.loadCoursesFromFiles("src/main/resources/loadCourses.txt");
testLoader.loadTests("src/main/resources/loadAllTests.txt");
        MenuSwitcher menuSwitcher = new MenuSwitcher(menus);
        menuSwitcher.execute();


    }


}
