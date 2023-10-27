package archiver;

import archiver.exception.WrongZipFileException;

import java.io.IOException;

public class Archiver {
    public static void main(String[] args) throws IOException {

        Operation operation = null;
        do {
            try {
                operation = askOperation();
                archiver.CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                archiver.ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                archiver.ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }

        } while (operation != archiver.Operation.EXIT);
    }


    public static Operation askOperation() throws IOException {
        archiver.ConsoleHelper.writeMessage("");
        archiver.ConsoleHelper.writeMessage("Выберите операцию:");
        archiver.ConsoleHelper.writeMessage(String.format("\t %d - упаковать файлы в архив", archiver.Operation.CREATE.ordinal()));
        archiver.ConsoleHelper.writeMessage(String.format("\t %d - добавить файл в архив", archiver.Operation.ADD.ordinal()));
        archiver.ConsoleHelper.writeMessage(String.format("\t %d - удалить файл из архива", archiver.Operation.REMOVE.ordinal()));
        archiver.ConsoleHelper.writeMessage(String.format("\t %d - распаковать архив", archiver.Operation.EXTRACT.ordinal()));
        archiver.ConsoleHelper.writeMessage(String.format("\t %d - просмотреть содержимое архива", archiver.Operation.CONTENT.ordinal()));
        archiver.ConsoleHelper.writeMessage(String.format("\t %d - выход", archiver.Operation.EXIT.ordinal()));

        return archiver.Operation.values()[archiver.ConsoleHelper.readInt()];
    }
}