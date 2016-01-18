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
  public void listsMultipleArtistsPageTest() {
    goTo("http://localhost:4567");
    fill("#inputfromhomepage").with("Aardvark");
    submit(".btn");
    goTo("http://localhost:4567/addword");
    fill("#inputfromhomepage").with("Aardwolf");
    submit(".btn");
    assertThat(pageSource()).contains("Aardvark");
    assertThat(pageSource()).contains("Aardwolf");
  }

  @Test
  public void listsDefinitionTest() {
    goTo("http://localhost:4567");
    fill("#inputfromhomepage").with("Abed");
    fill("#inputfromdefinepage").with("In bed; on a bed.");
    submit(".btn");
    click("a", withText("Abed"));
    assertThat(pageSource()).contains("In bed; on a bed.");
  }

  @Test
  public void listsTheCorrectDefinitionTest() {
    goTo("hhtp://localhost:4567");
    fill("#inputfromhomepage").with("Abase");
    fill("#inputfromdefinpage").with("To lower in position, estimation, or the like");
    submit(".btn");
    click("a", withText("Abase"));
    assertThat(pageSource()).notContains("In bed; on a bed");
  }


}
