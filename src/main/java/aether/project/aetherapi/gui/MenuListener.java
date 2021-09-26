package aether.project.aetherapi.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class MenuListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Inventory inventory = event.getClickedInventory();

        if (inventory == null)
            return;

        InventoryHolder inventoryHolder = inventory.getHolder();

        if (!(inventoryHolder instanceof Menu))
            return;

        Menu menu = (Menu) inventoryHolder;
        menu.handleClickAction(event);
    }

    @EventHandler
    public void onOpen(InventoryOpenEvent event) {
        InventoryHolder inventoryHolder = event.getInventory().getHolder();

        if (!(inventoryHolder instanceof Menu))
            return;

        Menu menu = (Menu) inventoryHolder;
        menu.handleOpenAction(event);
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        InventoryHolder inventoryHolder = event.getInventory().getHolder();

        if (!(inventoryHolder instanceof Menu))
            return;

        Menu menu = (Menu) inventoryHolder;
        menu.handleCloseAction(event);
    }
}
