package UI;

import java.util.List;

public class MenuSwitcher implements UIInterface{

    private final List<UIInterface> uiInterfaces;



    public MenuSwitcher(List<UIInterface> uiInterfaces) {
        this.uiInterfaces = uiInterfaces;
    }

    @Override
    public int execute() {
try {
    int index = uiInterfaces.get(0).execute();
        while (index >= 0){
            index = uiInterfaces.get(index).execute();
        }
    }catch (RuntimeException e){
    e.printStackTrace();
    return 0;
}

        return -1;
    }



    @Override
    public void printActionName() {

    }
}
