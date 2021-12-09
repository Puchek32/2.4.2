package testgroup.CRUD_prilozhenie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import testgroup.CRUD_prilozhenie.model.Role;
import testgroup.CRUD_prilozhenie.model.User;
import testgroup.CRUD_prilozhenie.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/admin")
    public String allUsers(ModelMap modelMap) {
        modelMap.addAttribute("usersList", userService.allUsers());
        return "adminPage";
    }

    @GetMapping(value = "/admin/edit/{id}")
    public String editPage(ModelMap modelMap, @PathVariable("id") int id) {
        modelMap.addAttribute("user", userService.getById(id));
        return "editPage";
    }

    @PostMapping(value = "/admin/edit")
    public String editUser(@ModelAttribute("user") User user,
                           @RequestParam(required = false, name = "ADMIN") String ADMIN,
                           @RequestParam(required = false, name = "USER") String USER) {
        user.setRoles(kysochek(ADMIN, USER));
        userService.edit(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/add")
    public String addPage(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "addPage";
    }

    @PostMapping(value = "/admin/add")
    public String addUser(@ModelAttribute("user") User user,
                          @RequestParam(required = false, name = "ADMIN") String ADMIN,
                          @RequestParam(required = false, name = "USER") String USER) {
        user.setRoles(kysochek(ADMIN, USER));
        userService.add(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(userService.getById(id));
        return "redirect:/admin";
    }


    @GetMapping(value = "/user")
    public String currentUser(ModelMap modelMap) {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByUsername(userDetails.getUsername());
        modelMap.addAttribute("user", user);
        return "user";
    }

    private static Set<Role> kysochek(String ADMIN, String USER) {
        Set<Role> roles = new HashSet<>();
        if (ADMIN != null) {
            roles.add(new Role(1, ADMIN));
        }
        if (USER != null) {
            roles.add(new Role(2, USER));
        }
        if (ADMIN == null && USER == null) {
            roles.add(new Role(2, USER));
        }
        return roles;
    }
}
