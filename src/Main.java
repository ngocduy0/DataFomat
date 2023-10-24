
import controller.Controller;



public class Main {
    public static void main(String[] args) {
        String title="Menu";
        String []mc = {"Phone","Email","Date","Exit"};
       Controller c = new Controller(title, mc);
       c.run();
    }
}
