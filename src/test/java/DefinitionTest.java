import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void definition_initializesUserInputWord_true() {
    Definition myDefinition = new Definition("A large, nocturnal, burrowing mammal, Orycteropus afer, of central and southern Africa.");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void all_returnsAllDefinitions_true() {
    Definition myDefinitionOne = new Definition("A large, nocturnal, burrowing mammal, Orycteropus afer, of central and southern Africa.");
    Definition myDefinitionTwo = new Definition("A maned striped nocturnal mammal of southern and eastern Africa that resembles the related hyenas.");
    assertTrue(Definition.all().contains(myDefinitionOne));
    assertTrue(Definition.all().contains(myDefinitionTwo));
  }

  @Test
  public void find_returnsDefinitionWithCorrectID_definitionTwo() {
    Definition myDefinitionOne = new Definition("A large, nocturnal, burrowing mammal, Orycteropus afer, of central and southern Africa.");
    Definition myDefinitionTwo = new Definition("A maned striped nocturnal mammal of southern and eastern Africa that resembles the related hyenas.");
    assertEquals(Definition.find(myDefinitionTwo.getId()), myDefinitionTwo);
  }

  @Test
  public void clear_empitesDefinitionFromArrayList() {
    Definition myDefinition = new Definition("A large, nocturnal, burrowing mammal, Orycteropus afer, of central and southern Africa.");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }
}
