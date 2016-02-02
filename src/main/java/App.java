import java.util.HashMap;

import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    ProcessBuilder process = new ProcessBuilder();
    Integer port;
    if (process.environment().get("PORT") != null) {
       port = Integer.parseInt(process.environment().get("PORT"));
    } else {
       port = 4567;
    }
    setPort(port);
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("words", Word.all());
      model.put("definitions", Definition.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String wordInput = request.queryParams("word-input");
      String definitionInput = request.queryParams("define-new");
      Word newWord = new Word(wordInput);
      Definition newDefinition = new Definition(definitionInput);

      newWord.addDefinition(definitionInput);
      response.redirect("/");
      return null;
    });

    post("/adddefinition", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.queryParams("wordSelection")));

      String definitionInput = request.queryParams("add-definition");
      word.addDefinition(definitionInput);
      response.redirect("/");
      return null;
    });

    get("/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("word", Word.find(Integer.parseInt(request.params("id"))));

      model.put("template", "templates/definition.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
