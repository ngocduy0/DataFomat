
package validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validate {
    private static final String PHONE_VALID = "^[0-9]{10}$";
    private static final String EMAIL_VALID = "^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
    private final static Scanner sc = new Scanner(System.in);

    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int check = Integer.parseInt(sc.nextLine().trim());
                if (check < min || check > max) {
                    throw new Exception();
                } else {
                    return check;
                }
            } catch (Exception e) {
                System.out.println("Please input number in range [" + min + ", " + max + "]!");
                System.out.println("Enter again: ");
            }
        }
    }

    public String checkInputString(String mess) {
        System.out.println(mess);
        while (true) {
            String string = sc.nextLine().trim();
            if (string.isEmpty()) {
                System.out.println("Not allowed empty!");
                System.out.println("Enter again: ");
            } else {
                return string;
            }
        }
    }

    public int checkInt(String mess) {
        System.out.println(mess);
        return sc.nextInt();
    }

    public Double checkInputDouble(String mess) {
        System.out.println(mess);
        return sc.nextDouble();
    }

    

    public  String checkInputString() {
        //loop until user input true value
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public String checkInputPhone() {
    while (true) {
        String phoneCheck = sc.nextLine();
        if (phoneCheck.length() != 10) {
            System.err.println("Phone number must have exactly 10 digits.");
        } else if (!phoneCheck.matches("\\d{10}")) {
            System.err.println("Phone number must be a string of 10 digits.");
        } else {
            return phoneCheck;
        }
    }
}

    public  String checkInputDate() {
        while (true) {
            try {
                String dateCheck = checkInputString();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateCheck);
                return dateCheck;
            } catch (ParseException ex) {
                System.out.print("Date: ");
                System.err.println("Date to correct format(dd/MM/yyyy)");
            }
        }
    }

    public  String checkInputEmail() {
        while (true) {
            String emailCheck = checkInputString();
            if (!emailCheck.matches(EMAIL_VALID)) {
                System.err.println("Email must be correct format");
                System.out.print("Email: ");
            } else {
                return emailCheck;
            }
        }
    }
    // hàm để kiểm tra ngày tháng năm 
    public  static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Kiểm tra năm nhuận và điều chỉnh số ngày trong tháng 2 nếu cần
        if (isLeapYear(year)) {
            daysInMonth[2] = 29;
        }

        return day <= daysInMonth[month];
    }
    

    public static String checkInputDate(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Date: ");
                String dateCheck = scanner.nextLine();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateCheck);

                String[] dateParts = dateCheck.split("/");
                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]);

                if (isValidDate(day, month, year)) {
                    return dateCheck;
                } else {
                    System.err.println("Ngay khong hop le, nhap lai theo dinh dang dd/MM/yyyy.");
                }
            } catch (ParseException | NumberFormatException ex) {
                System.err.println("Ngay khong hop le, nhap lai theo dinh dang dd/MM/yyyy.");
            }
        }
    }
}
