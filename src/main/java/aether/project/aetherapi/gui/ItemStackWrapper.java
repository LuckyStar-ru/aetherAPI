package aether.project.aetherapi.gui;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemStackWrapper {
    private ItemStack item;
    private ItemMeta meta;

    public ItemStackWrapper(Material material) {
        this.item = new ItemStack(material);
        this.meta = item.getItemMeta();
    }

    public ItemStackWrapper(Material material, int amount) {
        this.item = new ItemStack(material, amount);
        this.meta = item.getItemMeta();
    }

    public ItemStackWrapper(Material material, int amount, short damage) {
        this.item = new ItemStack(material, amount, damage);
        this.meta = item.getItemMeta();
    }

    public ItemMeta getMeta() {
        return meta;
    }

    public ItemStack getItem() {
        this.item.setItemMeta(meta);
        return item;
    }
}
