package org.launchcode.skillstracker.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("")
public class SkillsController {

    private final String openingHTML = "<html>" +
            "<head>" +
            "<style>" +
            "table {n" +
            "  font-family: arial, sans-serif;" +
            "  border-collapse: collapse;" +
            "  width: 100%;" +
            "}" +

            "td, th {" +
            "  border: 1px solid #dddddd;" +
            "  text-align: left;" +
            "  padding: 8px;" +
            "}" +
            "tr:nth-child(even) {" +
            "  background-color: #dddddd;" +
            "}" +
            "</style>" +
            "</head>" +
            "<body>";
    private final String closingHTML = "</body>" +
            "</html>";

    @GetMapping("")
    public String tracker() {
        return  openingHTML +
                "<h1> Tracker </h1>" +
                "<h2> We have a few skills we would like to learn. Here is the list!" +
                "<ol>" +
                "<li> Java </li>" +
                "<li> JavaScript </li>" +
                "<li> Python </li>" +
                "</ol>" +
                "<a href='http://localhost:8080/form'> Go to Form </a>"  +
                closingHTML;
    }

    @GetMapping("form")
    public String skillsForm() {
        return openingHTML +
                "<form action = '/skills' method = 'post'>" + // submit a request to /hello
                "<label for='name'>Name</label><br>" +
                "<input type = 'text' name = 'name' ><br><br>" +
                "<label for='language'>My Favorite Language</label><br>" +
                "<select name='language1' id='language1'><br>\n" +
                "    <option value=>--Please choose an option--</option>\n" +
                "    <option value='Java'>Java</option>\n" +
                "    <option value='JavaScript'>JavaScript</option>\n" +
                "    <option value='Python'>Python</option>\n" +
                "</select><br><br>" +
                "<label for='language'>My Second Favorite Language</label><br>" +
                "<select name='language2' id='language2'><br><br>\n" +
                "    <option value=>--Please choose an option--</option>\n" +
                "    <option value='Java'>Java</option>\n" +
                "    <option value='JavaScript'>JavaScript</option>\n" +
                "    <option value='Python'>Python</option>\n" +
                "</select><br><br>" +
                "<label for='language'>My Second Favorite Language</label><br>" +
                "<select name='language3' id='language3'><br><br>\n" +
                "    <option value=>--Please choose an option--</option>\n" +
                "    <option value='Java'>Java</option>\n" +
                "    <option value='JavaScript'>JavaScript</option>\n" +
                "    <option value='Python'>Python</option>\n" +
                "</select><br><br>" +
                "<input type = 'submit' value = 'Submit' >" +
                "</form>" +
                closingHTML;
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value = "skills")
    public String showSkillsOrder(@RequestParam String name, String language1, String language2, String language3) {
        return  openingHTML +
                "<h1> "+ name + "</h1>" +
                "<table>" +
                "  <tr>\n" +
                "    <th>Language #1</th>\n" +
                "    <th>Language #2</th>\n" +
                "    <th>Language #3</th>\n" +
                "  </tr>" +
                "<tr>\n" +
                "    <td>"+ language1 + "</td>\n" +
                "    <td>" + language2 + "</td>\n" +
                "    <td>" + language3 + "</td>\n" +
                "  </tr>" +
                "</table>" +
                closingHTML;
    }

}


