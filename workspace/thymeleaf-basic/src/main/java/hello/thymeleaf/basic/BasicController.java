package hello.thymeleaf.basic;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basic")
public class BasicController {

    @GetMapping("text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data", "Hello Spring!");
        return "basic/text-basic";
    }

    @GetMapping("text-unescaped")
    public String textUnescaped(Model model) {
        model.addAttribute("data", "Hello <b>Spring!</b>");
        return "basic/text-unescaped";
    }

    @GetMapping("variable")
    public String variable(Model model) {
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);

        List<User> list = List.of(userA, userB);

        Map<String, User> map = Map.of("userA", userA, "userB", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);
        return "basic/variable";
    }

    @GetMapping("basic-objects")
    public String basicObjects(HttpSession session) {
        session.setAttribute("sessionData","Hello Session");
        return "basic/basic-objects";
    }

    @Component("helloBean")
    static class HelloBean {
        public String hello(String data) {
            return "Hello" + data;
        }
    }

    @GetMapping("date")
    public String date(Model model) {
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "basic/date";
    }

    @GetMapping("link")
    public String link(Model model) {
        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");
        return "basic/link";
    }

    @GetMapping("literal")
    public String literal(Model model){
        model.addAttribute("data","Spring!");
        return "basic/literal";
    }

    @GetMapping("operation")
    public String operation(Model model){
        model.addAttribute("data","Spring!");
        model.addAttribute("nullData",null);
        return "basic/operation";
    }

    @GetMapping("attribute")
    public String attribute(){
        return "basic/attribute";
    }

    @GetMapping("each")
    public void each(Model model){
        addUsers(model);
    }

    @GetMapping("condition")
    public void condition(Model model){
        addUsers(model);
    }

    @GetMapping("comments")
    public void comments(Model model){
        model.addAttribute("data","Spring!");
    }

    @GetMapping("block")
    public void block(Model model){
        addUsers(model);
    }

    @GetMapping("javascript")
    public void javascript(Model model){
        model.addAttribute("user",new User("UserA",10));
        addUsers(model);
    }

    private void addUsers(Model model){
        List<User> list = List.of(
                new User("UserA", 10),
                new User("UserB", 20),
                new User("UserC", 30)
        );
        model.addAttribute("users",list);
    }

    @Data
    @AllArgsConstructor
    static class User {
        private String username;
        private int age;
    }
}
