import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Nordstrom_fileread {

    private static final int REC_LEN = 35;
    private static final int FN_START = 0;
    private static final int FN_END = 12;
    private static final int LN_START = 12;
    private static final int LN_END = 24;
    private static final int EID_START = 24;
    private static final int EID_END = 34;
    private static final int STATUS_START = 34;
    private static final int STATUS_END = 35;

    private static String statusMap(char c) {
        switch(c) {
            case '1': return "Active";
            case '2': return "Terminated";
            case '3': return "Retired";
            default: return "Unknown";
        }
    }
    
    
    public static void main(String[] args) {

        String readerFilePath = args[0];
        String writerFilePath = args[1];

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(readerFilePath));
            writer = new BufferedWriter(new FileWriter(writerFilePath));

            String line;

            while((line = reader.readLine()) != null) {

                String firstName = line.substring(FN_START, FN_END);
                String lastName = line.substring(LN_START, LN_END);
                String employeeID = line.substring(EID_START, EID_END);
                String status = statusMap(line.charAt(STATUS_START));
                
                String fullName = "";
                if(firstName.length() > 0 && lastName.length() > 0)
                    fullName = firstName + " " + lastName;

                else if(firstName.length() > 0)
                    fullName = firstName;

                else
                    fullName = lastName;

                String csvLine = fullName + "," + employeeID + "," + status;
                writer.write(csvLine);

                writer.close();
                reader.close();
            }
        }

        catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
            System.exit(0);
        }

        

        
    }
}
