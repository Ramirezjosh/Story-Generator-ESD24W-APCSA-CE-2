import java.io.*;
import java.util.*;
import java.lang.ProcessBuilder;
import java.util.Scanner;
/**
*Hallmark holds data to create story variations.
*
*@author Josh Ramirez
*/





/* implement the Hallmark class.
// It should have a constructor that works as used in Main.
Hallmark(data)
// input from csv file | open, read, close
Hallmark(file)

// It should have a generateStory method that creates a random story.
generateStory()
generateStory(file)

// It should have a generateStories method that creates multiple stories. 
generateStories(count)
generateStories(count, file)
*/

public class Hallmark{ 

  /**
   * Text available for story generation.
   */
  private String[][] data;

  /**
   * Constructor with 2D array.
   * @param dain Recieves data in the form of a 2D array and stores it to be mixed up into stories.
   */
  public Hallmark(String[][] dain){
    data = new String[dain.length][];
    for(int i = 0; i < dain.length; i++){
      data[i] = new String[dain[i].length];
    }

    for(int r = 0; r < data.length; r++){
      for (int c = 0; c < data[r].length; c++){
        data[r][c] = dain[r][c];
      }
    }
  }


  /**
   * Constructor with csv file name
   * @param filename_in Recieves a csv file to convert into data.
   * @throws IOException in the case of an error.
   */
  public Hallmark(String filename_in)throws IOException{
    File myFile = new File(filename_in);
    Scanner scan = new Scanner(myFile);
    ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
    int i = 0;
    while (scan.hasNextLine()){
      String line = scan.nextLine();
      
    }
  }


  /**
   * <p>Creates randomized Hallmark story variation from the data array.
   * </p>
   * @return Single Randomized Story
   * @since 1.0
   */
  public String generateStory(){
    String rv = "";
    for (int r = 0; r < data.length; r++){
      int c = (int) (Math.random() * data[r].length);
      rv += data[r][c];
      rv += " ";
      
    }
    return rv;
  }


  /**
   * <p>Creates randomized Hallmark story variation from the data array and outputs it to specified filename.type.
   * </p>
   * @param filename filename.type to write to.
   * @return Single Randomized Story
   * @since 1.0
   */
  public String generateStory(String filename){
    String rv = generateStory();
    FileWriter writer = null;
    try{
      writer = new FileWriter(filename);
      writer.write(rv);
      writer.flush();
    } catch (IOException bad) {
      bad.printStackTrace();
    } finally {
        try{
          if (writer != null){
            writer.close();
          }
        } catch (IOException bad) {
            bad.printStackTrace();
        }
    }
    
    return rv;
  }


  /**
   * <p>Creates an array of randomized Hallmark story variations from the data array.
   * </p>
   * @param numStories Number of stories to generate.
   * @return Array of randomized stories.
   * @since 1.0
   */
  public String[] generateStories(int numStories){
    // String[] rvs = {"Once upon a time...","In a galaxy far far away..."};
    // return rvs;
    String[] retval = new String[numStories];
    for (int ilovestories = 0; ilovestories < retval.length; ilovestories++){
      String rv = generateStory();
      
      retval[ilovestories] = rv;
    }
    return retval;
  }


  /**
   * <p>Creates an array of randomized Hallmark story variations from the data array and writes to the input filename.type.
   * </p>
   * @param numStories Number of stories to generate.
   * @param filename filename.type to write to.
   * @return Array of randomized stories.
   * @since 1.0
   */
  public String[] generateStories(int numStories, String filename){
    String[] retval = generateStories(numStories);
    
    String write = "";
    for (int i = 0; i < retval.length; i++){
      write += "\"" + retval[i] + "\"," + "\n"; 
    }
    write = write.substring(0,write.length()-2);

    FileOutputStream writer = null;
    try{
      writer =new FileOutputStream("/home/runner/Story-Generator-ESD24W-APCSA-CE-2/"+filename);

      writer.write(write.getBytes());
      writer.flush();
    } catch (IOException bad) {
      bad.printStackTrace();
    } finally {
        try{
          if (writer != null){
            writer.close();
          }
        } catch (IOException bad) {
            bad.printStackTrace();
        }
    }

    
    return retval;
  }

  /**
   * <p>Runs main.py that calls OpenRouter api to generate a short story using a LLM.
   * </p>
   * @return Single generated story.
   * @since 1.0
   */
  public String coolMethod() {
    try{
      ProcessBuilder pb = new ProcessBuilder("python", "main.py");
      pb.redirectErrorStream(true);
      Process pro = pb.start();

      Reader reader = new       InputStreamReader(pro.getInputStream());
      BufferedReader bf = new BufferedReader(reader);
      String s;
      while ((s = bf.readLine()) != null){
        return s;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }


  /**
   * <p>Runs main.py that calls OpenRouter api to generate a short story using a LLM and outputs it to specified filename.type.
   * </p>
   * @param filename filename.type to write to.
   * @return Single generated story.
   * @since 1.0
   */
  public String coolMethod(String filename){
    String rv = coolMethod();
    FileWriter writer = null;
    try{
      writer = new FileWriter(filename);
      writer.write(rv);
      writer.flush();
    } catch (IOException bad) {
      bad.printStackTrace();
    } finally {
        try{
          if (writer != null){
            writer.close();
          }
        } catch (IOException bad) {
            bad.printStackTrace();
        }
    }

    return rv;
  }


  /**
   * <p>Creates an array of generated Hallmark story variations by calling an LLM api.
   * </p>
   * @param numStories Number of stories to generate.
   * @return Array of generated stories.
   * @since 1.0
   */
  public String[] coolMethod(int numStories){
    // String[] rvs = {"Once upon a time...","In a galaxy far far away..."};
    // return rvs;
    String[] retval = new String[numStories];
    for (int ilovestories = 0; ilovestories < retval.length; ilovestories++){
      String rv = coolMethod();

      retval[ilovestories] = rv;
    }
    return retval;
  }


  /**
   * <p>Creates an array of generated Hallmark story variations using an LLM api and writes to the input filename.type.
   * </p>
   * @param numStories Number of stories to generate.
   * @param filename filename.type to write to.
   * @return Array of generated stories.
   * @since 1.0
   */
  public String[] coolMethod(int numStories, String filename){
    String[] retval = coolMethod(numStories);

    String write = "";
    for (int i = 0; i < retval.length; i++){
      write += "\"" + retval[i] + "\"," + "\n"; 
    }
    write = write.substring(0,write.length()-2);

    FileOutputStream writer = null;
    try{
      writer =new FileOutputStream("/home/runner/Story-Generator-ESD24W-APCSA-CE-2/"+filename);

      writer.write(write.getBytes());
      writer.flush();
    } catch (IOException bad) {
      bad.printStackTrace();
    } finally {
        try{
          if (writer != null){
            writer.close();
          }
        } catch (IOException bad) {
            bad.printStackTrace();
        }
    }


    return retval;
  }
  /**
   * <p>Scanner Prompt to keep java running until sumbit. Replit webview only runs while project is running?
   * </p>
   * @since 1.0
   */
  // javadoc -d /home/runner/Story-Generator-ESD24W-APCSA-CE-2/doc2 Hallmark.java
  // pushd /home/runner/Story-Generator-ESD24W-APCSA-CE-2/doc2;  python3 -m http.server 9999; pop
  public static void waitHM(){
    Scanner notDone = new Scanner(System.in);  
    System.out.println("Enter to finish:");

    String alldonefornow = notDone.nextLine();
  }
  
}