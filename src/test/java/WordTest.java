import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void word_initializesUserInputWord_true() {
    Word myWord = new Word("Aardvark");
    assertEquals(true, myWord instanceof Word);
  }

  @Test
  public void word_hasUserInputWord_Aardvark() {
    Word myWord = new Word("Aardvark");
    String expected = "Aardvark";
    assertEquals(expected, myWord.getName());
  }

  @Test
  public void all_returnsAllUserInputWords_true() {
    Word myWordOne = new Word("Aardvark");
    Word myWordTwo = new Word("Aardwolf");
    assertTrue(Word.all().contains(myWordOne));
    assertTrue(Word.all().contains(myWordTwo));
  }

  @Test
  public void clear_emptiesWordFromArrayList() {
    Word word = new Word("Aardvark");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }
}
