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
    fill("#word-input").with("Aardvark");
    submit(".btn");
    assertThat(pageSource()).contains("Aardvark");
  }

  @Test
  public void listsDefinitionTest() {
    goTo("http://localhost:4567");
    fill("#word-input").with("Abase");
    fill("#define-new").with("To lower in position, estimation, or the like");
    submit("addBoth");
    assertThat(pageSource().contains("To lower in position, estimation, or the like"));
  }
}
