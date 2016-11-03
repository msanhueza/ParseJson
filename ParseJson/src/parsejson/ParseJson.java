/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsejson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author msanhuezal
 */
public class ParseJson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String jsonFile = args[0];//"C:/Users/msanhuezal/Desktop/test.json";
        String fileKeys = args[1];//"C:/Users/msanhuezal/Desktop/testFile.txt";
        executeParseJson(readFile(fileKeys), jsonFile);
    }
    
    public static void executeParseJson(ArrayList<String> keys, String jsonFile){
        JSONParser parser = new JSONParser();
	try {
		Object obj = parser.parse(new FileReader(jsonFile));
		JSONObject jsonObject = (JSONObject) obj;
                keys.stream().forEach((keyField) -> {
                    String valueField = (String) jsonObject.get(keyField);
                    System.out.println(keyField + ":  " + valueField);
                });


	} catch (FileNotFoundException e) {
            System.out.println(e);
	} catch (IOException | ParseException e) {
            System.out.println(e);
	}        
    }
    
    public static ArrayList<String> readFile(String filePath){
        ArrayList<String> keys = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                    keys.add(line);
            }
            return keys;

        } catch (IOException e) {
                e.printStackTrace();
        }
        return null;
    }
    
}
