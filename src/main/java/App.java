import java.util.HashMap;

import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    // // Home Page Route
    //
    // get("/", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //
    //   model.put("template", "templates/index.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // // From home page to word input page
    //
    // get("/addword", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/addword.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // // Take the input from user to the word list
    //
    // get("/dictionary-list", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   model.put("words", Word.all());
    //   model.put("template", "templates/dictionary-list.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // post("/dictionary-list", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   String userWordInput = request.queryParams("inputfromhomepage");
    //   model.put("word", Word.all());
    //
    //   model.put("template", "templates/dictionary-list.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    get("/", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          model.put("template", "templates/index.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //ROUTES: Identification of Resources

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

        // get("/artists/:id", (request, response) -> {
        //   HashMap<String, Object> model = new HashMap<String, Object>();
        //   Artist artist = Artist.find(Integer.parseInt(request.params(":id")));
        //   model.put("artist", artist);
        //   model.put("albums", Album.all());
        //   model.put("template", "templates/albums.vtl");
        //   return new ModelAndView(model, layout);
        // }, new VelocityTemplateEngine());

        // get("/artists/:id1/:id2", (request, response) -> {
        //   HashMap<String, Object> model = new HashMap<String, Object>();
        //   Album album = Album.find(Integer.parseInt(request.params(":id2")));
        //   model.put("album", album);
        //   model.put("template", "templates/album-details.vtl");
        //   return new ModelAndView(model, layout);
        // }, new VelocityTemplateEngine());

        //ROUTES: Changing Resources

        post("/dictionary-list", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          String userWordName = request.queryParams("inputfromhomepage");
          Word newWord = new Word(userWordName);
          
          model.put("words", Word.all());
          model.put("template", "templates/dictionary-list.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        // post("/artists/:id", (request, response) -> {
        //   HashMap<String, Object> model = new HashMap<String, Object>();
        //   Artist artist = Artist.find(Integer.parseInt(request.params(":id")));
        //
        //   String userAlbumName = request.queryParams("albumname");
        //   boolean alreadyInAlbums = false;
        //
        //   for (Album album : Album.all()) {
        //     String name = album.getName();
        //     if (name.equals(userAlbumName)) {
        //       alreadyInAlbums = true;
        //     }
        //   }
        //
        //   if (!alreadyInAlbums) {
        //     Album newAlbum = new Album(userAlbumName, artist);
        //   }
        //
        //   model.put("artist", artist);
        //   model.put("failedToAdd", alreadyInAlbums);
        //   model.put("albums", Album.all());
        //
        //   model.put("template", "templates/albums.vtl");
        //   return new ModelAndView(model, layout);
        // }, new VelocityTemplateEngine());


  }
}
