
package controller;

import java.util.Scanner;
import menu.Menu;
import validation.Validate;


public class Controller extends Menu {

    public Validate v = new Validate();

    public Controller(String title, String[] mc) {
        super(title, mc);
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                v.checkInputPhone();
                break;
            case 2:
                v.checkInputEmail();
                break;
            case 3:
                Scanner scanner = new Scanner(System.in);
                System.out.println("Nhap ngay thang nam hop le (dd/MM/yyyy):");
                String dateInput = v.checkInputDate(scanner);

                System.out.println( dateInput);
                break;
            case 4:
                return;
            default:
                throw new AssertionError();
        }
    }

}
