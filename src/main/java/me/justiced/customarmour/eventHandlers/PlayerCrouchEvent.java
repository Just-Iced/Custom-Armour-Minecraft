package me.justiced.customarmour.eventHandlers;

import me.justiced.customarmour.DataClass;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.inventory.ItemStack;


public class PlayerCrouchEvent implements Listener {
    DataClass dc = DataClass.get_instance();
    ArrayList<PotionEffectType> positivePots = dc.positivePots();
    ItemStack tntLegs = dc.tntArmorCrafting.getLegs();
    ItemStack cactusLegs = dc.cactusArmorCrafting.getLegs();
    ItemStack featherLegs = dc.featherArmorCrafting.getLegs();
    ItemStack brewingLegs = dc.brewingArmorCrafting.getLegs();
    ItemStack woodLegs = dc.woodArmorCrafting.getLegs();
    ItemStack blazeLegs = dc.blazeArmorCrafting.getLegs();
    ItemStack golemLegs = dc.golemArmorCrafting.getLegs();

    @EventHandler
    void onPlayerCrouch(PlayerToggleSneakEvent e){
        Player player = e.getPlayer();
        ItemStack pLegs = player.getInventory().getLeggings();
        if (pLegs != null) {
            if (e.isSneaking()) {
                if (pLegs.isSimilar(tntLegs)) {
                    if (!dc.tntCrouchCooldown.containsKey(player.getUniqueId())) {
                        dc.tntCrouchCooldown.put(player.getUniqueId(), System.currentTimeMillis());
                        Entity tnt = player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT);
                        tnt.setCustomName(ChatColor.DARK_RED + "Big Boom!");
                    } else {
                        long timeElapsed = System.currentTimeMillis() - dc.tntCrouchCooldown.get(player.getUniqueId());
                        if (timeElapsed >= 3000) {
                            Entity tnt = player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT);
                            tnt.setCustomName(ChatColor.DARK_RED + "Big Boom!");
                            dc.tntCrouchCooldown.put(player.getUniqueId(), System.currentTimeMillis());
                        }
                    }
                }
                if (pLegs.isSimilar(brewingLegs)){
                    boolean canAppyPot = true;
                    for (PotionEffect potionEffect:
                            player.getActivePotionEffects()){
                        PotionEffectType potionEffectType = potionEffect.getType();
                        if (positivePots.contains(potionEffectType)){
                            canAppyPot = false;
                        }
                    }
                    if (canAppyPot) {
                        int rnd = ThreadLocalRandom.current().nextInt(positivePots.size());
                        player.addPotionEffect(new PotionEffect(positivePots.get(rnd), 300, 1));
                    }
                }
            }
            if (pLegs.isSimilar(cactusLegs)) {
                player.getLocation().subtract(0, 1, 0).getBlock().setType(Material.CACTUS);
            }
            if (pLegs.isSimilar(featherLegs)){
                for (Entity ent:
                        player.getWorld().getNearbyEntities(player.getLocation(),20,20,20)) {
                    if (ent.getCustomName() != null && ent.getCustomName().equalsIgnoreCase(ChatColor.GREEN + "Friend"))
                        ent.getWorld().createExplosion(ent.getLocation(),2);
                }
            }
            if (pLegs.isSimilar(blazeLegs)){
                for (Entity ent:
                        player.getWorld().getNearbyEntities(player.getLocation(),20,20,20)) {
                    if (ent instanceof LivingEntity living && ent != player)
                        living.setFireTicks(140);
                }
            }
            if (pLegs.isSimilar(woodLegs)){
                for (double x = -10; x <= 10; x++){
                    for (double y = -10; y <= 10; y++){
                        for (double z = -10; z <= 10; z++){
                            Location loc = player.getLocation().add(x,y,z);
                            Block block = loc.getBlock();
                            Material mat = block.getType();
                            if (mat.isFuel())
                                block.breakNaturally();
                        }
                    }
                }
            }
            else if (pLegs.isSimilar(golemLegs)){
                boolean addStrength = true;
                for (PotionEffect potionEffect:
                    player.getActivePotionEffects()){
                    if (potionEffect.getType().equals(PotionEffectType.INCREASE_DAMAGE)) {
                        addStrength = false;
                        break;
                    }
                }
                if (addStrength)
                    player.addPotionEffect(PotionEffectType.INCREASE_DAMAGE.createEffect(200,1));
            }

        }
    }
}
