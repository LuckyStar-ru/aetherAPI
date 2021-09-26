package aether.project.example;

import aether.project.aetherapi.gui.ItemStackWrapper;
import aether.project.aetherapi.gui.Menu;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Arrays;

public class TestMenu extends Menu {
    public TestMenu() {
        super("§2Меню для теста!", 3);
    }

    @Override
    public void setContents() {
        fillInventory(Material.BLACK_STAINED_GLASS_PANE);
        ItemStackWrapper item = new ItemStackWrapper(Material.RED_WOOL);
        item.getMeta().setDisplayName("Привет! Ты заглянул в тестовое меню!");
        item.getItem().setLore(Arrays.asList("§7По нажатию в чате появится сообщение:", "§aМолодец!"));
        this.inventory.setItem(14, item.getItem());
    }

    @Override
    public void handleClickAction(InventoryClickEvent event) {
        if (event.getSlot() == 14) {
            event.getWhoClicked().sendMessage("§aМолодец!");
        }
        event.setCancelled(true);
    }
}
