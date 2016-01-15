import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> instances = new ArrayList<Word>();

  private final String mUserInputWord;
  private int mId;

  public Word(String inputWord) {
    mUserInputWord = inputWord;
    instances.add(this);
    mId = instances.size();
  }

  public String getInputWord() {
    return mUserInputWord;
  }

  public static ArrayList<Word> all() {
    return instances;
  }

  public static Word find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException abc) {
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }

  public String getName() {
    return mUserInputWord;
  }

  public int getId() {
    return mId;
  }
}
