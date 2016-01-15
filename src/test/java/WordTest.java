import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void word_initializesUserInputWord_true() {
    Word myWord = new Word("Apple");
    assertEquals(true, myWord instanceof Word);
  }

  @Test
  public void word_hasUserInputWord_Aardvark() {
    Word myWord = new Word("Aardvark");
    String expected = "Aardvark";
    assertEquals(expected, myWord.getInputWord());
  }

  @Test
  public void all_returnsAllUserInputWords_true() {
    Word myWordOne = new Word("Aardvark");
    Word myWordTwo = new Word("Aardwolf");
    assertEquals(Word.all().contains(myWordOne));
    assertEquals(Word.all().contains(myWordTwo));
  }
}
