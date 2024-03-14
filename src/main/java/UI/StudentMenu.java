package UI;

import services.utils.inputOutput.UserInput;

import java.util.List;

public class StudentMenu implements UIInterface {


    @Override
    public int execute() {
        printActionName();
        while (true) {
            System.out.println("1. Register on course");
            System.out.println("2. Testing");
            System.out.println("3. Get Course information");
            System.out.println("4. Get grades");
            System.out.println("5. Exit");
            int index = UserInput.insertInt("Insert menu number from above");
            switch (index) {
                case 1:
                    return MenuIndexes.I_6.getIndex();
                case 2:
                    return MenuIndexes.I_7.getIndex();
                case 3:
                    return MenuIndexes.I_3.getIndex();
                case 4:
                    return MenuIndexes.I_8.getIndex();
                default:
                    return 0;
            }
        }
    }

    @Override
    public void printActionName() {
        System.out.println("Student menu");
    }
}
