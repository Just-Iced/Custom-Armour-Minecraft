package me.justiced.customarmour.eventHandlers;

import me.justiced.customarmour.DataClass;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import me.justiced.customarmour.crafting.CactusArmorCrafting;

public class PlayerAttackEvent implements Listener {
    @EventHandler
    void onPlayerAttack(EntityDamageByEntityEvent e){
        if (e.getEntity() instanceof Player player){
            DataClass dc = DataClass.get_instance();
            ItemStack cactusBoots = dc.cactusArmorCrafting.getBoots();
            ItemStack pBoots = player.getInventory().getBoots();

            if (pBoots != null) {
                    if (pBoots.isSimilar(cactusBoots) && e.getDamager() instanceof Player damager){
                        damager.damage(e.getDamage() / 2, player);
                }
            }
        }
    }
}

