package com.proto.demo.inventory;

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
@RequestMapping("/inventory")
public class InventoryItemController {
        
    @Autowired
    InventoryService inventoryItemService;
    
    @GetMapping("/all")
    public String getInventoryItems(Model model) {
        model.addAttribute("inventoryItemList", inventoryItemService.getAllInventoryItems());
        return "inventoryItem/list-inventoryItems";
    }

    @GetMapping("/id={InventoryItemId}")
    public String getInventoryItem(@PathVariable long inventoryItemId, Model model) {
        model.addAttribute("inventoryItem", inventoryItemService.getInventoryItem(inventoryItemId));
        return "inventoryItem/inventoryItem-detail";
    }

    @GetMapping("/delete/id={InventoryItemId}")
    public String deleteInventoryItem(@PathVariable long inventoryItemId, Model model) {
        inventoryItemService.deleteInventoryItem(inventoryItemId);
        return "redirect:/inventoryItem/all";
    }

    @PostMapping("/create")
    public String createInventoryItem(InventoryItem inventoryItem) {

        inventoryItemService.saveInventoryItem(inventoryItem);
        return "redirect:/inventoryItem/all";
    }

    @PostMapping("/update")
    public String upateInventoryItem(InventoryItem inventoryItem) {
        inventoryItemService.saveInventoryItem(inventoryItem);
        return "redirect:/inventoryItem/all";
    }

    @GetMapping("/new-inventoryItem")
    public String newInventoryItemForm(Model model) {
        return "inventoryItem/new-inventoryItem";
    }

    @GetMapping("/update/id={inventoryItemId}")
    public String updateInventoryItemForm(@PathVariable long inventoryItemId, Model model) {
        model.addAttribute("inventoryItem", inventoryItemService.getInventoryItem(inventoryItemId));
        return "inventoryItem/update-inventoryItem";
    }
}