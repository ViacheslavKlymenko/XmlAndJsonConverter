package fileResources;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileOperation {

    private Scanner scanner;

    public FileOperation() {
        this.scanner = new Scanner(System.in);
    }

    public File getFile() {
                File result;
        String filePath;
        while (true) {
            System.out.println("Enter path to file...");
            filePath = scanner.nextLine();
            result = new File(filePath);
            if (result.exists()) {
                break;
            } else {
                System.out.println("Invalid path, try again...");
            }
        }
        return result;
    }

    public File createNewFile() {
        File result;
        String filePath;
        while (true) {
            System.out.println("Enter path for new file...");
            filePath = scanner.nextLine();
            result = new File(filePath);
            try {
                result.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (result.exists()) {
                break;
            } else {
                System.out.println("Invalid path, try again...");
            }
        }
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        scanner.close();
    }
}
