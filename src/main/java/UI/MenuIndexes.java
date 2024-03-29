package UI;

public enum MenuIndexes {
    I_0(0, "Main Menu"),
   I_1(1, "LogIn"),
    I_2(2,"Register"),
    I_3(3, "Get course information"),
    I_4(4,"Student menu"),
    I_5(5, "Admin menu"),
    I_6(6, "Register on course"),
    I_7(7, "Testing menu"),
    I_8(8, "Get grades"),
    I_9(9,"Get student information by Id"),
    I_10(10, "Get all students"),
    I_11(11, "Get best Students"),
    I_12(12, "add or change course"),
    I_13(13, "Add Test");

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
