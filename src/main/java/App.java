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

      String wordInput = request.queryParams("inputfromhomepage");
      String definitionInput = request.queryParams("inputfromdefinepage");

      Word newWord = new Word(wordInput);
      Definition newDefinition = new Definition(definitionInput, newWord);

      model.put("definitions", Definition.all());
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/adddefinition", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.queryParams("wordSelection")));

      String definitionInput = request.queryParams("inputfromdefinepage");
      Definition newDefinition = new Definition(definitionInput, word);
      response.redirect("/");
      return null;
    });

    get("/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("definitions", Definition.find(Integer.parseInt(request.params("id"))));
      
      model.put("template", "templates/definition.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
