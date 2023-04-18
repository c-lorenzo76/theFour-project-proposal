package com.proto.demo.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author CollinHarris
 */
@Controller
@RequestMapping("/menu")
public class MenuItemController{
    
    @Autowired
    MenuService menuItemService;
    
    @GetMapping("/all")
    public String getMenuItems(Model model) {
        model.addAttribute("menuItemList", menuItemService.getAllMenuItems());
        return "chef";
    }

    @GetMapping("/id={MenuItemId}")
    public String getMenuItem(@PathVariable long menuItemId, Model model) {
        model.addAttribute("menuItem", menuItemService.getMenuItem(menuItemId));
        return "menuItem/menuItem-detail";
    }

    @GetMapping("/delete/id={MenuItemId}")
    public String deleteMenuItem(@PathVariable long menuItemId, Model model) {
        menuItemService.deleteMenuItem(menuItemId);
        return "redirect:/menuItem/all";
    }

    @PostMapping("/create")
    public String createMenuItem(MenuItem menuItem) {

        menuItemService.saveMenuItem(menuItem);
        return "redirect:/menuItem/all";
    }

    @PostMapping("/update")
    public String upateMenuItem(MenuItem menuItem) {
        menuItemService.saveMenuItem(menuItem);
        return "redirect:/menuItem/all";
    }

    @GetMapping("/new-menuItem")
    public String newMenuItemForm(Model model) {
        return "menuItem/new-menuItem";
    }

    @GetMapping("/update/id={menuItemId}")
    public String updateMenuItemForm(@PathVariable long menuItemId, Model model) {
        model.addAttribute("menuItem", menuItemService.getMenuItem(menuItemId));
        return "menuItem/update-menuItem";
    }
}
