package org.launchcode.hellospring.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        String greeting = "";

        if (language.contains("English")) {
            greeting = "Hello";
        } else if (language.contains("French")) {
            greeting = "Bonjour";
        } else if (language.contains("German")) {
            greeting = "Tag";
        } else if (language.contains("Spanish")) {
            greeting = "Hola";
        } else if (language.contains("Japanese")) {
            greeting = "こんにちは";
        } else if (language.isEmpty() && name.isEmpty()) {
            greeting = "Hello";
            name = "World";
        }
        return "<html>" +
                "<body>" +
                "<p style='color:red; font-size:26px; font-family:Courier'>" +
                greeting + " " + name + "!" + "</p>" +
                "</body>" +
                "</html>";

    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<br><br>" +
//                "<div style='border:grey; border-width:2px; border-style:inset; display:inline; padding:8px'" +
                "<form  style='border:grey; border-width:2px; border-style:inset; display:inline; padding:8px'action = '/hello' method ='post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select name='language' language = 'language'>" +
                "<option value=''>Language</option>" +
                    "<option value='English'>English</option>" +
                    "<option value='German'>German</option>" +
                    "<option value='French'>French</option>" +
                    "<option value='Spanish'>Spanish</option>" +
                    "<option value='Japanese'>Japanese</option>" +
                "</select>" +
                "<input type='submit'; value='Greet Me!' >" +
                "</form>" +
//                "</div>" +
                "</body>" +
                "</html>";
    }

}