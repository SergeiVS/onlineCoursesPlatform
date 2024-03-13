package UI;

import services.utils.inputOutput.UserInput;

import java.util.List;

public class AdminMenu implements UIInterface {

    @Override
    public int execute() {
            printActionName();
            while (true) {
                System.out.println("1. Get all persons list");
                System.out.println("2. Get student grades");
                System.out.println("3. Get course information");
                System.out.println("4. Get best students");
                System.out.println("5. Get Student information by Id");
                System.out.println("6. Set student on course");
                System.out.println("7. Add new course or new info about course");
                System.out.println("8. Exit");
                int index = UserInput.insertInt("Insert menu number from above");
                switch (index) {
                    case 1:
                        return MenuIndexes.I_11.getIndex();
                    case 2:
                        return MenuIndexes.I_8.getIndex();
                    case 3:
                        return MenuIndexes.I_3.getIndex();
                    case 4:
                        return MenuIndexes.I_12.getIndex();
                    case 5:
                        return MenuIndexes.I_10.getIndex();
                    case 6:
                        return MenuIndexes.I_6.getIndex();
                    case 7:
                        return MenuIndexes.I_13.getIndex();
                    default:
                        return 0;
                }
            }
    }

    @Override
    public void printActionName() {
        System.out.println("Admin menu");
    }
}
