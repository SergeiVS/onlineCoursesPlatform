package UI;

import java.util.List;

public class AdminMenu implements UIInterface {

    private final List<UIInterface> uiInterfaceList;

    public AdminMenu(List<UIInterface> uiInterfaceList) {
        this.uiInterfaceList = uiInterfaceList;
    }

    @Override
    public void execute() {
        printActionName();
        UiStatic.choiceMenuExecute(uiInterfaceList);
    }

    @Override
    public void printActionName() {
        System.out.println("Admin menu");
    }
}
