import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

//a.	ID (a String as before in Person)
//b.	Name (a String)
//c.	Description (a String a short sentence)
//d.	Cost (This is currency so it will be a Java double)
        public class PersonReader {
            public static void main(String[] args) {
                ArrayList<String> folks = new ArrayList<>();
                Scanner in = new Scanner(System.in);

                File workingDirectory = new File(System.getProperty("user.dir"));
                Path file = Paths.get(workingDirectory.getPath() + "\\src\\personData.txt");

                Boolean done = false;

                String personRec = "";
                String ID = "";
                String name = "";

                String Description = "";
                int cost = 0;

                do {
                    ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]: ");
                    name = SafeInput.getNonZeroLenString(in, "Enter the first name:");
                    Description = SafeInput.getNonZeroLenString(in, "Enter the Description ");
                    cost = SafeInput.getInt(in, "Enter the cost ");

                    personRec = ID + "," + firstName + "," + lastName + "," + Description + "," + cost;
                    folks.add(personRec);

                    done = SafeInput.getYNConfirm(in, "Another person (y/n)? ");


                } while (!done);
                for (String person : folks) {
                    System.out.println(person);
                }

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile())))
                {

                    // Finally can write the file LOL!

                    for(String rec : folks)
                    {
                        writer.write(rec, 0, rec.length());  // stupid syntax for write rec
                        // 0 is where to start (1st char) the write
                        // rec. length() is how many chars to write (all)
                        writer.newLine();  // adds the new line

                    }
                    writer.close(); // must close the file to seal it and flush buffer
                    System.out.println("Data file written!");
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
