package aether.project.aetherapi.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public abstract class Menu implements InventoryHolder {
    protected final Inventory inventory;
    private final String title;
    private final int size;

    public Menu(String title) {
        this(title, 3);
    }

    public Menu(String title, int rows) {
        this.title = title;
        this.size = rows * 9;
        this.inventory = Bukkit.createInventory(this, size, title);
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

    public void open(Player player) {
        setContents();
        player.openInventory(this.inventory);
    }

    public abstract void setContents();

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    protected void fillInventory(ItemStack air) {
        Arrays.fill(inventory.getContents(), air);
    }

    protected void fillSpacesInInventory(ItemStack air) {
        for (int i = 0; i < inventory.getContents().length; i++) {
            if (inventory.getContents()[i].getType() != Material.AIR) {
                inventory.getContents()[i] = air;
            }
        }
    }

    protected void fillInventory(Material air) {
        ItemStack airItem = new ItemStack(air);
        ItemMeta meta = airItem.getItemMeta();
        meta.setDisplayName("");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        airItem.setItemMeta(meta);
        Arrays.fill(inventory.getContents(), airItem);
    }

    protected void fillSpacesInInventory(Material air) {
        ItemStack airItem = new ItemStack(air);
        ItemMeta meta = airItem.getItemMeta();
        meta.setDisplayName("");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        airItem.setItemMeta(meta);
        ItemStack[] content = inventory.getContents();
        for (int i = 0; i < content.length; i++) {
            if (content[i].getType() != Material.AIR) {
                content[i] = airItem;
            }
        }
    }

    public void handleClickAction(InventoryClickEvent event) {
        event.setCancelled(true);
    }

    public void handleCloseAction(InventoryCloseEvent event) {}

    public void handleOpenAction(InventoryOpenEvent event) {}
}
