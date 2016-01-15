import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void definition_initializesUserInputWord_true() {
    Definition myDefinition = new Definition("A large, nocturnal, burrowing mammal, Orycteropus afer, of central and southern Africa.", new Word("Aardvark"));
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void definition_hasDefinitionForAardvark() {
    Definition myDefinition = new Definition("A large, nocturnal, burrowing mammal, Orycteropus afer, of central and southern Africa.", new Word("Aardvark"));
    String expected = "A large, nocturnal, burrowing mammal, Orycteropus afer, of central and southern Africa.";
    assertEquals(expected, myDefinition.getDefinition());
  }

  @Test
  public void definition_hasWord_Aardvark() {
    Word expected = new Word("Aardvark");
    Definition myDefinition = new Definition("A large, nocturnal, burrowing mammal, Orycteropus afer, of central and southern Africa.", expected);
    assertEquals(expected, myDefinition.getWord());
  }

  @Test
  public void all_returnsAllDefinitions_true() {
    Definition myDefinitionOne = new Definition("A large, nocturnal, burrowing mammal, Orycteropus afer, of central and southern Africa.", new Word("Aardvark"));
    Definition myDefinitionTwo = new Definition("a maned striped nocturnal mammal of southern and eastern Africa that resembles the related hyenas.", new Word("Aardwolf"));
    assertTrue(Definition.all().contains(myDefinitionOne));
    assertTrue(Definition.all().contains(myDefinitionTwo));
  }

  @Test
  public void find_returnsDefinitionWithCorrectID_definitionTwo() {
    Definition myDefinitionOne = new Definition("A large, nocturnal, burrowing mammal, Orycteropus afer, of central and southern Africa.", new Word("Aardvark"));
    Definition myDefinitionTwo = new Definition("a maned striped nocturnal mammal of southern and eastern Africa that resembles the related hyenas.", new Word("Aardwolf"));
    assertEquals(Definition.find(myDefinitionTwo.getId()), myDefinitionTwo);
  }
}
