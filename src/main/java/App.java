import java.util.HashMap;

import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          model.put("template", "templates/index.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    get("addword", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/addword.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/dictionary-list", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("words", Word.all());
      model.put("template", "templates/dictionary-list.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/dictionary-list", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String userWordName = request.queryParams("inputfromhomepage");
      Word newWord = new Word(userWordName);

      String newUserDefinition = request.queryParams("inputfromdefinepage");
      Definition newDefinition = new Definition(newUserDefinition, newWord);

      model.put("definition", Definition.all());
      model.put("words", Word.all());
      model.put("template", "templates/dictionary-list.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/adddef/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Definition newDefinition = Definition.find(Integer.parseInt(request.params(":id")));
      // Word newWord = Word.find(Integer.parseInt(request.params(":id")));

      model.put("definition", newDefinition);
      // model.put("definitions", Definition.all());
      model.put("template", "templates/adddef.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
