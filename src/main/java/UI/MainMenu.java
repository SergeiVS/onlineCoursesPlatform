package UI;

import services.utils.inputOutput.UserInput;

public class MainMenu implements UIInterface {

    @Override
    public int execute() {
        printActionName();

        try {


        while (true) {
            System.out.println("1. Log In");
            System.out.println("2. Register");
            System.out.println("3. Get courses information");
            System.out.println("4. Exit");
            int index = UserInput.insertInt("Insert menu number from above");
            switch (index) {
                case 1:
                    return MenuIndexes.I_1.getIndex();
                case 2:
                    return MenuIndexes.I_2.getIndex();
                case 3:
                    return MenuIndexes.I_3.getIndex();
                case 4:
                    return -1;
                default:
                    return 0;
            }

        }
    }catch (RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void printActionName() {
        System.out.println(" Main menu");
    }
}
