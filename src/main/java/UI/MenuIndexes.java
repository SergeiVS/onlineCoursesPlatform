package UI;

public enum MenuIndexes {
    I_0(0, "Main Menu"),
   I_1(1, "LonIn"),
    I_2(2,"Register"),
    I_3(3, "Get courses information"),
    I_4(4,"Student menu"),
    I_5(5, "Admin menu"),
    I_6(6, "Register on course"),
    I_7(7, "Testing menu"),
    I_8(8, "Get grades"),
    I_9(9, "Get course information");

    int index;
    String menuName;

    MenuIndexes(int index, String menuName) {
        this.index = index;
        this.menuName = menuName;
    }

    public int getIndex() {
        return index;
    }
}
