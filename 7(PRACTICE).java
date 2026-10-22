// Skip invalid marks using NumberFormatException
import java.io.*;

public class ResultReport {
    public static void main(String[] args) {
        int pass = 0, fail = 0, total = 0, n = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("student.txt"));
             PrintWriter pw = new PrintWriter("result.txt")) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] f = line.split(",");

                try {
                    int m = Integer.parseInt(f[2]);
                    total += m;
                    n++;

                    if (m >= 50) {
                        pass++;
                        pw.println(f[1] + " PASS");
                    } else {
                        fail++;
                        pw.println(f[1] + " FAIL");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid marks skipped: " + line);
                }
            }

            pw.println("Passed : " + pass);
            pw.println("Failed : " + fail);

            if (n > 0)
                pw.printf("Average : %.2f%n", (double) total / n);

            System.out.println("result.txt created. Passed " + pass
                    + ", failed " + fail);

        } catch (IOException e) {
            System.out.println("File error : " + e.getMessage());
        }
    }
}

/*
OUTPUT (if student.txt contains only the original three valid lines):

result.txt created. Passed 2, failed 1

If student.txt contains an invalid line such as 104,Ram,ABC:

Invalid marks skipped: 104,Ram,ABC
result.txt created. Passed 2, failed 1

CONTENTS OF result.txt:

Aravind PASS
Divya PASS
Karthik FAIL
Passed : 2
Failed : 1
Average : 71.33
*/
