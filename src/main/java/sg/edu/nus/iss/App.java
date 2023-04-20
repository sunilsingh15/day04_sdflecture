package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String dirPath = args[0];
        String fileName = args[1];
        String dirPathFileName = dirPath + File.separator + fileName;

        File newDir = new File(dirPath);
        if (newDir.exists()) {
            System.out.println("Directory " + dirPath + "already exists.");
        } else {
            newDir.mkdir();
        }

        File newFile = new File(dirPathFileName);
        if (!newFile.exists()) {
            System.out.println("File " + dirPathFileName + " does not exist.");
            System.exit(0);
        }

        // use FileReader and BufferedReader to read file
        FileReader fr = new FileReader(new File(dirPathFileName));
        BufferedReader br = new BufferedReader(fr);

        StringBuilder sbFileContent = new StringBuilder();
        String lineInput = "";
        
        // while loop to read file into a String variable
        while ((lineInput = br.readLine()) != null) {
            sbFileContent.append(lineInput);
        }

        // close the readers
        br.close();
        fr.close();

        // print out the StringBuilder object sbFileContent
        System.out.println(sbFileContent);

        // convert the string in sbFileContent to all uppercase
        // print to screen
        System.out.println(sbFileContent.toString().toUpperCase());

        // convert StringBuilder to String
        // so that I can use String methods to perform other tasks
        String fileContent = sbFileContent.toString();
        fileContent = fileContent.replace(',' , ' ');
        fileContent = fileContent.replace('.' , ' ');
        fileContent = fileContent.replace('(' , ' ');
        fileContent = fileContent.replace(')' , ' ');
        fileContent = fileContent.replace('[' , ' ');
        fileContent = fileContent.replace(']' , ' ');
        fileContent = fileContent.replace('"' , ' ');
        fileContent = fileContent.replace('?' , ' ');
        fileContent = fileContent.replace('!' , ' ');

        // new array to store split words
        String [] fileContentArray = fileContent.split(" ");

        // store all the unique words read
        Map<String, Integer> words = new HashMap<>();

        for (String word : fileContentArray) {

            Integer wordExists = words.get(word);

            if (wordExists == null) {
                // new word found
                words.put(word, 1);

            } else {
                // the word exists in the Map/HashMap collection
                words.put(word, wordExists + 1);
            }
        }

        System.out.println(words);
    }
}
