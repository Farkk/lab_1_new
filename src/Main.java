import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("Выберите вариант \n1)Работа с символами\n2)Работа со строками");
            String choiceStr = scanner.nextLine();
            choice = selectionOfOperation(choiceStr);
        } while (choice == 0);

        int consoleWidth = 0;

        do {
            System.out.print("Введите ширину консоли: ");
            String consoleWidthStr = scanner.nextLine();
            try {
                consoleWidth = Integer.parseInt(consoleWidthStr);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка, вы ввели не число. Попробуйте снова!");
            }
        } while (consoleWidth == 0);

        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        int operation = 0;
        do {
            System.out.println("Выберите операцию \n1)Определение количества символов\n2)Определение количества строк");
            String operationStr = scanner.nextLine();
            operation = selectionOfOperation(operationStr);
        } while (operation == 0);

        if (choice == 1) {
            FindingCountRowsToOutConsole ConsoleManager = new FindingCountRowsToOutConsole();

            switch (operation) {
                case 1:
                    int charsToFillLastLine = ConsoleManager.calculateCharsToFillLastLine(consoleWidth, text);

                    System.out.println("Текст построчно:");
                    printTextLineByLine(text, consoleWidth);

                    System.out.println("Количество символов для заполнения последней строки: " + charsToFillLastLine);
                    break;
                case 2:
                    int countLines = ConsoleManager.calculateRowsToOutConsole(text, consoleWidth);
                    System.out.println("Текст построчно:");
                    printTextLineByLine(text, consoleWidth);

                    System.out.println("Количество строк для вывода: " + countLines);
                    break;
            }

        } else if (choice == 2) {
            FindingCountSymbolOnLastRows ConsoleManager = new FindingCountSymbolOnLastRows();

            switch (operation) {
                case 1:
                    int charsToFillLastLine = ConsoleManager.calculateCharsToFillLastLine(consoleWidth, text);

                    System.out.println("Текст построчно:");
                    printTextLineByLine(text, consoleWidth);

                    System.out.println("Количество символов на последней строке: " + charsToFillLastLine);
                    break;
                case 2:
                    int countLines = ConsoleManager.calculateRowsToOutConsole(text, consoleWidth);

                    System.out.println("Текст построчно:");
                    printTextLineByLine(text, consoleWidth);

                    System.out.println("Количество строк для вывода: " + countLines);
                    break;
            }
        }
    }
    private static void printTextLineByLine(String text, int consoleWidth) {
        while (!text.isEmpty()) {
            String line = text.substring(0, Math.min(consoleWidth, text.length()));
            System.out.println(line.trim());
            text = text.substring(line.length());
        }
    }

    private static int selectionOfOperation(String operationStr) {
        int operation;
            try {
                operation = Integer.parseInt(operationStr);
                if (operation == 1 || operation == 2) return operation;
                else System.out.println("Неверный выбор. Введите число 1 или 2.");
            } catch (NumberFormatException e) {
                System.out.println("Неверный выбор. Введите число 1 или 2.");
            }
        return 0;
    }
}