import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void word_initializesUserInputWord_true() {
    Word myWord = new Word();
    assertEquals(true, myWord instanceof Word);
  }
}
