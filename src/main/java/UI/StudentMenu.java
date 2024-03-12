package UI;

import java.util.List;

public class StudentMenu implements UIInterface{
    private final List<UIInterface> uiInterfaceList;

    public StudentMenu(List<UIInterface> uiInterfaceList) {
        this.uiInterfaceList = uiInterfaceList;
    }

    @Override
    public void execute() {
printActionName();
UiStatic.choiceMenuExecute(uiInterfaceList);
    }

    @Override
    public void printActionName() {

    }
}
