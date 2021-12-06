package testgroup.CRUD_prilozhenie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import testgroup.CRUD_prilozhenie.model.User;
import testgroup.CRUD_prilozhenie.service.UserService;

@Controller
@RequestMapping
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String allUsers(ModelMap modelMap) {
        modelMap.addAttribute("usersList", userService.allUsers());
        return "users";
    }

    @GetMapping(value = "/edit/{id}")
    public String editPage(ModelMap modelMap, @PathVariable("id") int id) {
        modelMap.addAttribute("user", userService.getById(id));
        return "editPage";
    }

    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/";
    }

    @GetMapping(value = "/add")
    public String addPage() {
        return "editPage";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(userService.getById(id));
        return "redirect:/";
    }
}
