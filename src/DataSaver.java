import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        int idCounter = 1;
        boolean moreRecords = true;

        while (moreRecords) {
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String idNumber = String.format("%06d", idCounter);
            String email = SafeInput.getNonZeroLenString(in, "Enter Email");
            int yearOfBirth = SafeInput.getInt(in, "Enter Year of Birth (4 digits)");

            String record = firstName + "," + lastName + "," + idNumber + "," + email + "," + yearOfBirth;
            records.add(record);

            idCounter++;

            moreRecords = SafeInput.getYNConfirm(in, "Do you want to enter another record?");
        }

        String fileName = SafeInput.getNonZeroLenString(in, "Enter file name to save (without .csv)");
        fileName += ".csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/" + fileName))) {
            for (String rec : records) {
                writer.println(rec);
            }
            System.out.println("Data saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}