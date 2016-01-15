import java.util.*;

public class Definition {
  private static ArrayList<Definition> instances = new ArrayList<Definition>();

  private final String mUserInputDefinition;
  private final Word mWord;
  private int mId;

  public Definition(String inputDefinition, Word word) {
    mUserInputDefinition = inputDefinition;
    mWord = word;
    instances.add(this);
    mId = instances.size();
  }

  public static ArrayList<Definition> all() {
    return instances;
  }

  public static Definition find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException abc) {
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }
  
  public String getDefinition() {
    return mUserInputDefinition;
  }

  public Word getWord() {
    return mWord;
  }

  public int getId() {
    return mId;
  }

}
