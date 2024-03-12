package UI;

import services.utils.inputOutput.UserInput;

import java.util.List;

import static UI.UiStatic.choiceMenuExecute;

public class StartMenu implements UIInterface{

    private final List<UIInterface> uiInterfaceList;

    public StartMenu(List<UIInterface> uiInterfaceList) {
        this.uiInterfaceList = uiInterfaceList;
    }

    @Override
    public void execute() {
        printActionName();
        UiStatic.choiceMenuExecute (uiInterfaceList);
    }



    @Override
    public void printActionName() {
        System.out.println("Main menu");
    }
}
