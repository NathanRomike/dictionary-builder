import java.util.ArrayList;

public class Definition {
  private static ArrayList<Definition> instances = new ArrayList<Definition>();

  private final String mUserInputDefinition;
  private int mId;

  public Definition(String inputDefinition) {
    mUserInputDefinition = inputDefinition;
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

  public int getId() {
    return mId;
  }

}
