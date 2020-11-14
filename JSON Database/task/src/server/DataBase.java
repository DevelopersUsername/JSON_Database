package server;

import java.util.Arrays;
import java.util.Scanner;

public class DataBase {

    String[] db;
    Scanner scanner;

    public DataBase() {
        db = new String[100];
        scanner = new Scanner(System.in);
    }

    void start() {
        while (true) {

            String command = scanner.nextLine();

            switch (command.split(" ")[0].toLowerCase()) {
                case ("get"):
                    get(command, db);
                    break;
                case ("set"):
                    set(command, db);
                    break;
                case ("delete"):
                    delete(command, db);
                    break;
                default:
                    return;
            }
        }
    }

    static void get(String command, String[] db) {

        int cellNumber = getCellNumber(command);

        if (isInvalidCellNumber(cellNumber) || db[cellNumber] == null) {
            printERROR();
        } else {
            System.out.println(db[cellNumber]);
        }
    }

    static void set(String command, String[] db) {

        int cellNumber = getCellNumber(command);

        if (isInvalidCellNumber(cellNumber)) {
            printERROR();
        } else {
            db[cellNumber] = Arrays.toString(command.split(" ", 2));
            printOK();
        }
    }

    static void delete(String command, String[] db) {

        int cellNumber = getCellNumber(command);

        if (isInvalidCellNumber(cellNumber)) {
            printERROR();
        } else {
            db[cellNumber] = null;
            printOK();
        }
    }

    static int getCellNumber(String command) {
        return Integer.parseInt(command.split(" ")[1]) - 1;
    }

    static boolean isInvalidCellNumber(int cellNumber) {
        return !(cellNumber >= 0 && cellNumber < 100);
    }

    static void printOK() {
        System.out.println("OK");
    }

    static void printERROR() {
        System.out.println("ERROR");
    }
}