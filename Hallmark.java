import java.io.*;
import java.util.*;
import java.lang.ProcessBuilder;

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
  private String[][] data;
  
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


  
  public Hallmark(String filename_in)throws IOException{
    File myFile = new File(filename_in);
    Scanner scan = new Scanner(myFile);
    ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
    int i = 0;
    while (scan.hasNextLine()){
      String line = scan.nextLine();
      
    }
  }


  
  public String generateStory(){
    String rv = "";
    for (int r = 0; r < data.length; r++){
      int c = (int) (Math.random() * data[r].length);
      rv += data[r][c];
      rv += " ";
      
    }
    return rv;
  }


  
  public String generateStory(String filename){
    String rv = "";
    for (int r = 0; r < data.length; r++){
      int c = (int) (Math.random() * data[r].length);
      rv += data[r][c];
      rv += " ";

    }

    FileOutputStream writer = null;
    try{
      writer =new FileOutputStream("/home/runner/Story-Generator-ESD24W-APCSA-CE-2/"+filename);

      writer.write(rv.getBytes());
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


  
  public String[] generateStories(int numStories){
    // String[] rvs = {"Once upon a time...","In a galaxy far far away..."};
    // return rvs;
    String[] retval = new String[numStories];
    for (int ilovestories = 0; ilovestories < retval.length; ilovestories++){
      String rv = "";
      for (int r = 0; r < data.length; r++){
        int c = (int) (Math.random() * data[r].length);
        rv += data[r][c];
        rv += " ";

      }
      retval[ilovestories] = rv;
    }
    return retval;
  }


  
  public String[] generateStories(int numStories, String filename){
    String[] retval = new String[numStories];
    for (int ilovestories = 0; ilovestories < retval.length; ilovestories++){
      String rv = "";
      for (int r = 0; r < data.length; r++){
        int c = (int) (Math.random() * data[r].length);
        rv += data[r][c];
        rv += " ";

      }
      retval[ilovestories] = rv.substring(0,rv.length()-1);
    }
    
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
}