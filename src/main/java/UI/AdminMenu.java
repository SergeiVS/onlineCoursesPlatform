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
                System.out.println("3. Get best students");
                System.out.println("4. Get Student information");
                System.out.println("5. Set student on course");
                System.out.println("4. Exit");
                int index = UserInput.insertInt("Insert menu number from above");
                switch (index) {
                    case 1:
                        return MenuIndexes.I_6.getIndex();
                    case 2:
                        return MenuIndexes.I_7.getIndex();
                    case 3:
                        return MenuIndexes.I_8.getIndex();
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
