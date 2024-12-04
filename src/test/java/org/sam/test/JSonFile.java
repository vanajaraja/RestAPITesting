package org.sam.test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSonFile {

    public static void main(String[] args) throws ParseException, Throwable {

        JSONParser parser = new JSONParser();
        String json = "[\r\n" +
                "{\r\n" +
                "\"name\": \"Vanaja\",\r\n" +
                "\"Education\":\"BE\",\r\n" +
                "\"Role\":\"Automation tester\",\r\n" +
                "\"Skilset\":[\"Selenium\", \"Rest Assured\",\"SOAP UI\",\"POSTMAN\",\"TestNG\"]\r\n" +
                "\r\n" +
                "},\r\n" +
                "{\r\n" +
                "\"name\": \"Rajappa\",\r\n" +
                "\"Education\":\"B Tech\",\r\n" +
                "\"Role\":\"Soultion Architeture\",\r\n" +
                "\"Skilset\":[\"Devops\", \"Word\",\"PPt\",\"flowchart\",\"diagram\"]\r\n" +
                "\r\n" +
                "}\r\n" +
                "]";
        Object object = parser.parse(json);
        JSONArray ja = (JSONArray) object;
        for (Object object2 : ja) {
            JSONObject jb = (JSONObject) object2;
            System.out.println(jb.get("name"));
            JSONArray skillset = (JSONArray) jb.get("Skilset");
            Iterator<String> iterator = skillset.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());

            }

        }
        writeJSONFile();
    }

    public static void writeJSONFile() throws IOException {
        JSONObject object = new JSONObject();
        object.put("name", "Vanaja");
        object.put("Education", "BE");
        object.put("Role", "Automation tester");
        JSONArray ja = new JSONArray();
        ja.add("Selenium");
        ja.add("Rest Assured");
        ja.add("SOAP UI");
        ja.add("Postman");
        ja.add("TestNG");
        object.put("Skilset", ja);

        JSONObject object1 = new JSONObject();
        object1.put("name", "Vanaja");
        object1.put("Education", "BE");
        object1.put("Role", "Automation tester");
        JSONArray ja1 = new JSONArray();
        ja1.add("Selenium");
        ja1.add("Rest Assured");
        ja1.add("SOAP UI");
        ja1.add("Postman");
        ja1.add("TestNG");
        object1.put("Skilset", ja1);

        JSONArray finalJSON = new JSONArray();
        finalJSON.add(object);
        finalJSON.add(object1);

        FileWriter f = new FileWriter("employees.json");
        f.write(finalJSON.toJSONString());
        f.flush();
    }
}
