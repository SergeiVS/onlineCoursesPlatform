package UI;

import services.utils.inputOutput.UserInput;

import java.util.List;

public class UiStatic {

    public static void choiceMenuExecute( List<UIInterface> uiInterfaceList, int userId) {

        System.out.println();
        for (int i = 0; i < uiInterfaceList.size(); i++) {
            System.out.print((i+1) + ". ");
            uiInterfaceList.get(i).printActionName();
        }
        int choice = UserInput.insertInt("please insert action number from above");
        while (choice < 1 || choice > uiInterfaceList.size()){
            choice = UserInput.insertInt("please insert action number from above");
        }
        uiInterfaceList.get(choice-1).execute();

    }
    public static void choiceMenuExecute( List<UIInterface> uiInterfaceList) {

        System.out.println();
        for (int i = 0; i < uiInterfaceList.size(); i++) {
            System.out.print((i+1) + ". ");
            uiInterfaceList.get(i).printActionName();
        }
        int choice = UserInput.insertInt("please insert action number from above");
        while (choice < 1 || choice > uiInterfaceList.size()){
            choice = UserInput.insertInt("please insert action number from above");
        }
        uiInterfaceList.get(choice-1).execute();

    }
}
