package jsonFiles;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/** The example demonstrates reading from a JSON file */
public class JsonParser {
    public static void main(String[] args) {
        JsonParser jp = new JsonParser();

        //jp.parseSimple("src/main/java/jsonFiles/exJsonSimple.json");
        //jp.parsePersonInfo("src/main/java/jsonFiles/exJsonPersonInfo.json");
        jp.parsePeople("src/main/java/jsonFiles/exJsonPeople.json");

        //jp.parseJSONObjectWithArray("src/main/java/jsonFiles/exJsonWithArray.json");
    }

    /** This method demonstrates how to parse a simple json file
     * that contains info about fruits; using GSON library.
     *
     * @param filePath path to the json file
     */
    public void parseSimple(String filePath) {

        // This is the main class for using Gson.
        // Gson is typically used by first constructing a Gson instance
        Gson gsonObj = new Gson();

        try (FileReader fileObj = new FileReader(filePath))  {

            // This method deserialize the Json (convert JSON to Java Object)
            Fruit fruit = gsonObj.fromJson(fileObj, Fruit.class);
            System.out.println(fruit);
        }
        catch(IOException e) {
            System.out.println("Could not read the file:" + e);
        }

    }

    /** This method demonstrates how to parse a json file
     * that contains info about the person using GSON library.
     * Person has an address that is also a Json object
     *
     * @param filePath path to the json file
     */
    public void parsePersonInfo(String filePath) {

        // This is the main class for using Gson.
        // Gson is typically used by first constructing a Gson instance
        Gson gsonObj = new Gson();

        // FileReader - used in java.io and not java.nio
        try (FileReader fileObj = new FileReader(filePath))  {
            Person p = gsonObj.fromJson(fileObj, Person.class);
            System.out.println(p);
        }
        catch(IOException e) {
            System.out.println("Could not read the file: " + e);
        }
    }

    /** This method demonstrates how to parse a json file
     * that contains info about several people (value stored in a JSON Array).
     * Uses GSON library.
     * @param filePath path to the json file
     */
    public void parsePeople(String filePath) {

        // This is the main class for using Gson.
        // Gson is typically used by first constructing a Gson instance
        Gson gsonObj = new Gson();

        try (FileReader file = new FileReader(filePath))  {
            People people = gsonObj.fromJson(file, People.class);
            System.out.println(people);
        }
        catch(IOException e) {
            System.out.println("Could not read the file: " + e);
        }

    }

    /** Demonstrates another way of reading json files using GSON library
     * Here we read each JSON token one by one.
     * @param filePath path to the file
     */
    public void parse(String filePath) {
        try (JsonReader jsonReader = new JsonReader(new FileReader(filePath))) {
            jsonReader.beginObject();

            while (jsonReader.hasNext()) {

                String name = jsonReader.nextName();
                if (name.equals("name")) {
                    String nameOfFruit = jsonReader.nextString();
                    System.out.println(nameOfFruit);
                }
                else if (name.equals("price")){
                    System.out.println(jsonReader.nextLong());
                }
                else if (name.equals("color")) {
                    System.out.println(jsonReader.nextString());
                }
                else if (name.equals("organic")) {
                    System.out.println(jsonReader.nextBoolean());
                }
            }

            jsonReader.endObject();

        } catch (IOException e) {
            System.out.println("Could not read from file");
        }
    }

    /** Shows a way to read a JSON that contains a JSON array
     * a
     * @param filePath
     */
    public void parseJSONObjectWithArray(String filePath) {

        // Reads a JSON encoded value as a stream of tokens.
        try (JsonReader jsonReader = new JsonReader(new FileReader(filePath))) {

            // Consumes the next token from the JSON stream and asserts that it is the
            // beginning of a new object.
            jsonReader.beginObject();

            List<Fruit> fruits = new ArrayList<Fruit>();

            // Returns true if the current array or object has another element.
            if (jsonReader.hasNext()) {
                /* --- In Main Object --- */

                // Returns the next token, property name, and consumes it.
                // Initially it might be pointing null - not sure
                String name = jsonReader.nextName();
                if (name.equals("fruits")) {
                    /* --- In fruits JSON Array --- */

                    // Read Json Array
                    // Consumes the next token from the JSON stream and
                    // asserts that it is the beginning of a new array.
                    jsonReader.beginArray();

                    // Local Variable that will be given values from JSON
                    String nameOfFruit = "";
                    double price = 0;
                    String color = "";
                    boolean isOrganic = true;

                    // Returns the next token, property name, and consumes it.
                    while (jsonReader.hasNext()) {
                        /* --- In individual fruit JSON --- */

                        // Consume token, assume it is beginning
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            /* --- Going throught fruit JSON key-value pair --- */

                            String name1 = jsonReader.nextName();
                            if (name1.equals("name")) {
                                nameOfFruit = jsonReader.nextString();
                                System.out.print(nameOfFruit + ", ");
                            } else if (name1.equals("price")) {
                                price = jsonReader.nextDouble();
                                System.out.print(price + ", ");
                            } else if (name1.equals("color")) {
                                color = jsonReader.nextString();
                                System.out.print(color + ", ");
                            } else if (name1.equals("organic")) {
                                isOrganic = jsonReader.nextBoolean();
                                System.out.println(isOrganic);
                            }
                        }

                        Fruit f = new Fruit(nameOfFruit, color, price, isOrganic);

                        // The final List where we have to collect data
                        fruits.add(f);

                        // Consumes the next token from the JSON stream and asserts that
                        // it is the end of the current object.
                        jsonReader.endObject();

                    }

                    // Consumes the next token from the JSON stream and asserts
                    // that it is the end of the current array.
                    jsonReader.endArray();

                }

            }
            jsonReader.endObject();
        }
        catch (IOException e) {
            System.out.println("Could not read from file: " + e);
        }
    }
}
