import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void definition_initializesUserInputWord_true() {
    Definition myDefinition = new Definition("An animal which is the first word in most dictionaries.");
    assertEquals(true, myDefinition instanceof Definition);
  }
}
