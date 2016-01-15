import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void definition_initializesUserInputWord_true() {
    Definition myDefinition = new Definition("A large, nocturnal, burrowing mammal, Orycteropus afer, of central and southern Africa.");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void definition_hasDefinitionForAardvark() {
    Definition myDefinition = new Definition("A large, nocturnal, burrowing mammal, Orycteropus afer, of central and southern Africa.", new Word("Aardvark"));
    String expected = "A large, nocturnal, burrowing mammal, Orycteropus afer, of central and southern Africa.";
    assertEquals(expected, definition.getDefinition());
  }
}
