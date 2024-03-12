package UI;

import java.util.List;

public class OldStudentMenu implements UIInterface {
    private final List<UIInterface> uiInterfaceList;

    public OldStudentMenu(List<UIInterface> uiInterfaceList) {
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
