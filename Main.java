
class Main {
  // think: https://wronghands1.files.wordpress.com/2019/11/hallmark-christmas-movie-plot-generator.jpg
  public static void main(String[] args) {
    System.out.println("Hallmark Project");
    System.out.println("");
    final int numStories = 4;
    String[][] exampleData = {
      {"Big city","Career oriented","Recently single","World weary","Family oriented","With the wrong guy"},
      {"lawyer","writer","baker","interior designer","teacher","early 2000 actor you forgot about"},
      {"travels to a new town","returns to her small town during christmas","moves to the big city"},
      {"to inherit something,","to enter a folksy contest,","to stop some corporate closure,","to save the family business,","to start a small store",
      "to appease their sassy friend or widowed parent,"},
      {"and magically falls in love"},
      {"with a sensitive guy in plaid,","with an old flame,","with some guy and his dog,","with a single dad and his precocious child,","The bad buy","with christmas, the town and some guy,"},
      {"and also the only old man in town might actually be the real Santa Claus."}};
    

    Hallmark ChristmasStory = new Hallmark(exampleData);
    exampleData[0][0] = "RUINED YOUR STORY"; // see, if you don't preserve your objects through class
    // constructors, bad things happen.
    System.out.println("Give me that good ole C-list movie plot!\n[1] "+ChristmasStory.generateStory());

    String[] stories = ChristmasStory.generateStories(numStories, "cool.csv");
    System.out.println("Give me several of those good ole C-list movie plot!\n");
    for(int i=0; i<numStories; i++)
    {
      System.out.println();
      System.out.print("[" + (i+1) + "] ");
      System.out.print(stories[i]);
    }
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println(ChristmasStory.generateStory("christmas.csv"));
  }
}