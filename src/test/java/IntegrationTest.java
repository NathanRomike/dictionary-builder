import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
    public void rootTest() {
      goTo("http://localhost:4567");
      assertThat(pageSource()).contains("Welcome to a Dictionary...");
  }

  @Test
  public void listsWordPageTest() {
    goTo("http://localhost:4567");
    fill("#inputfromhomepage").with("Aardvark");
    submit(".btn");
    assertThat(pageSource()).contains("Aardvark");
  }

  @Test
  public void listsMultipleWordsPageTest() {
    goTo("http://localhost:4567");
    fill("#inputfromhomepage").with("Aardvark");
    submit(".btn");
    goTo("http://localhost:4567");
    fill("#inputfromhomepage").with("Aardwolf");
    submit(".btn");
    assertThat(pageSource()).contains("Aardvark");
    assertThat(pageSource()).contains("Aardwolf");
  }

  @Test
  public void listsDefinitionTest() {
    goTo("http://localhost:4567");
    fill("#inputfromhomepage").with("Abase");
    fill("#inputfromdefinepage").with("To lower in position, estimation, or the like");
    submit(".btn");
    click("a", withText("Abase"));
    assertThat(pageSource().contains("To lower in position, estimation, or the like"));
  }

  @Test
  public void doesNotListTheIncorrectDefinitionTest() {
    goTo("http://localhost:4567");
    fill("#inputfromhomepage").with("Abyss");
    fill("#inputfromdefinepage").with("Bottomless gulf.");
    submit(".btn");
    click("a", withText("Abyss"));
    assertThat(pageSource()).doesNotContain("To lower in position, estimation, or the like");
  }

  @Test
  public void addsAdditionalDefinitionsTest() {
    goTo("http://localhost:4567");
    fill("#inputfromhomepage").with("Abyss");
    fill("#inputfromdefinepage").with("Bottomless gulf.");
    submit(".btn");
    click("a", withText("Abyss"));
    fill("#inputfromdefinepage").with("Really deep hole.");
    submit(".btn");
    assertThat(pageSource().contains("Really deep hole."));
  }
}
