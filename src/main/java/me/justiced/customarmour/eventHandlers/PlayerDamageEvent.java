package me.justiced.customarmour.eventHandlers;

import me.justiced.customarmour.DataClass;
import me.justiced.customarmour.crafting.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class PlayerDamageEvent implements Listener {
    DataClass dc = DataClass.get_instance();

    ItemStack TNTchest = dc.tntArmorCrafting.getChest();
    ItemStack TNTboots = dc.tntArmorCrafting.getBoots();

    ItemStack cactusLegs = dc.cactusArmorCrafting.getLegs();
    ItemStack featherBoots = dc.featherArmorCrafting.getBoots();
    ItemStack brewingBoots = dc.brewingArmorCrafting.getBoots();
    ItemStack woodBoots = dc.woodArmorCrafting.getBoots();
    ItemStack blazeBoots = dc.blazeArmorCrafting.getBoots();
    ItemStack golemBoots = dc.golemArmorCrafting.getBoots();


    @EventHandler
    void onPlayerTakeDamage(EntityDamageEvent e){
        if (e.getEntity() instanceof Player p){
            EntityDamageEvent.DamageCause cause = e.getCause();
            PlayerInventory pInv = p.getInventory();
            ItemStack pChest = pInv.getChestplate();
            ItemStack pBoots = pInv.getBoots();
            ItemStack pLegs = pInv.getLeggings();

            if (pChest != null) {
                if (cause.equals(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) && pChest.isSimilar(TNTchest)) {
                    e.setDamage(1);
                }
            }
            if (pBoots != null) {
                if (cause.equals(EntityDamageEvent.DamageCause.FALL) ) {
                    if (pBoots.isSimilar(TNTboots)) {
                        p.getWorld().createExplosion(p.getLocation(), (clamp((float) e.getDamage() * 2f, 0, 100f)));
                        e.setDamage(e.getDamage() / 5);
                        if (e.getEntity() instanceof Player player)
                            player.setFoodLevel(player.getFoodLevel() + 10);
                    }
                    else if (pBoots.isSimilar(featherBoots))
                        e.setCancelled(true);
                }
                if (pBoots.isSimilar(brewingBoots)){
                    e.setDamage(e.getDamage() * 0.6);
                }
                if (pBoots.isSimilar(woodBoots)) {
                    if (cause.equals(EntityDamageEvent.DamageCause.SUFFOCATION)) {
                        e.setCancelled(true);
                    }
                }
                if (pBoots.isSimilar(blazeBoots)){
                    if (cause.equals(EntityDamageEvent.DamageCause.FIRE_TICK) || cause.equals(EntityDamageEvent.DamageCause.FIRE)
                            || cause.equals(EntityDamageEvent.DamageCause.LAVA) || cause.equals(EntityDamageEvent.DamageCause.HOT_FLOOR)) {
                        p.setFireTicks(0);
                        e.setCancelled(true);
                    }
                }
                if (pBoots.isSimilar(golemBoots)){
                    e.setDamage(e.getDamage() / 3);
                    if (cause.equals(EntityDamageEvent.DamageCause.FALL))
                        e.setCancelled(true);
                }
            }
            if (pLegs != null){
                if (cause.equals(EntityDamageEvent.DamageCause.CONTACT) && pLegs.isSimilar(cactusLegs)){
                    e.setCancelled(true);
                }
            }
        }
    }
    public static float clamp(float val, float min, float max) {return Math.max(min, Math.min(max, val));}
}
