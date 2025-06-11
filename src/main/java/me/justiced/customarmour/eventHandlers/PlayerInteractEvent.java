package me.justiced.customarmour.eventHandlers;

import me.justiced.customarmour.DataClass;
import me.justiced.customarmour.crafting.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import javax.xml.datatype.DatatypeConstants;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerInteractEvent implements Listener {
    void fireballRing(int fireballs, Player player){
        for (int i = 0; i <= fireballs; i++) {
            double angle = (Math.PI * 2) / fireballs * i;
            Vector dir = new Vector(1, 0, 0).rotateAroundY(angle);
            Fireball fireball = (Fireball) player.getWorld().spawn(player.getEyeLocation().add(dir), Fireball.class);
            fireball.setDirection(dir);
        }
    }

    @EventHandler
    void onPlayerInteract(org.bukkit.event.player.PlayerInteractEvent e){
        Player player = e.getPlayer();
        ItemStack item = e.getItem();
        ItemStack pChest = player.getInventory().getChestplate();
        ItemStack pHelm = player.getInventory().getHelmet();

        DataClass dc = DataClass.get_instance();

        ItemStack tntChest = dc.tntArmorCrafting.getChest();
        ItemStack tntHelmet = dc.tntArmorCrafting.getHelmet();

        ItemStack cactusChest = dc.cactusArmorCrafting.getChest();
        ItemStack cactusHelmet = dc.cactusArmorCrafting.getHelmet();

        ItemStack featherChestplate = dc.featherArmorCrafting.getChest();
        ItemStack featherHelmet = dc.featherArmorCrafting.getHelmet();

        ItemStack brewingChestplate = dc.brewingArmorCrafting.getChest();
        ItemStack brewingHelmet = dc.brewingArmorCrafting.getHelmet();

        ItemStack woodChestplate = dc.woodArmorCrafting.getChest();
        ItemStack woodHelmet = dc.woodArmorCrafting.getHelmet();

        ItemStack blazeHelmet = dc.blazeArmorCrafting.getHelmet();
        ItemStack blazeChestplate = dc.blazeArmorCrafting.getChest();

        ItemStack golemHelmet = dc.golemArmorCrafting.getHelmet();
        ItemStack golemChestplate = dc.golemArmorCrafting.getChest();

        World world = player.getWorld();
        float explosionAmt = 100f;
        int fireballs = 8;

        if (pChest != null && item == null && (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR))){
            if (pChest.isSimilar(tntChest)) {
                world.createExplosion(player.getLocation(), explosionAmt / 30);
            }
            else if (pChest.isSimilar(cactusChest)){
                for (Entity ent:
                        player.getWorld().getNearbyEntities(player.getLocation(),8,3,8)) {
                    if (ent instanceof LivingEntity && ent != player)
                        ent.getWorld().spawnEntity(ent.getLocation(), EntityType.EVOKER_FANGS);
                }
            }
            else if (pChest.isSimilar(featherChestplate)){
                for (Entity ent:
                        player.getWorld().getNearbyEntities(player.getLocation(),16,16,16)) {
                    if (ent instanceof LivingEntity && ent.getType() != EntityType.CHICKEN ) {
                        Chicken ch = (Chicken) ent.getWorld().spawnEntity(ent.getLocation(), EntityType.CHICKEN);
                        ch.setCustomName(ChatColor.GREEN + "Friend");
                    }
                }
            }
            else if (pChest.isSimilar(brewingChestplate)){
                for (Entity ent:
                        player.getWorld().getNearbyEntities(player.getLocation(),16,16,16)) {
                    if (ent instanceof LivingEntity livingEntity && ent != player) {
                        for (PotionEffect potionEffect:
                                livingEntity.getActivePotionEffects()){
                            livingEntity.removePotionEffect(potionEffect.getType());
                        }
                        int rnd = ThreadLocalRandom.current().nextInt(PotionEffectType.values().length);
                        livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.values()[rnd], 200, 1));
                    }
                }
            }
            else if (pChest.isSimilar(woodChestplate)){
                int rnd = ThreadLocalRandom.current().nextInt(TreeType.values().length);
                player.getWorld().generateTree(player.getLocation(), TreeType.values()[rnd]);
            }
            else if (pChest.isSimilar(blazeChestplate)){
                if (!dc.blazeCooldown.containsKey(player.getUniqueId())){
                    dc.blazeCooldown.put(player.getUniqueId(), System.currentTimeMillis());
                    fireballRing(fireballs, player);
                }else {
                    long timeElapsed = System.currentTimeMillis() - dc.blazeCooldown.get(player.getUniqueId());
                    if (timeElapsed >= 500){
                        fireballRing(fireballs, player);
                        dc.blazeCooldown.put(player.getUniqueId(),System.currentTimeMillis());
                    }
                }
            }
            else if (pChest.isSimilar(golemChestplate)){
                if (!dc.golemLaunchCooldown.containsKey(player.getUniqueId())){
                    for (Entity ent:
                            player.getWorld().getNearbyEntities(player.getLocation(),8,10,8)) {
                        if (ent != player) {
                            ent.setVelocity(new Vector(0, 2, 0));
                            dc.golemLaunchCooldown.put(player.getUniqueId(),System.currentTimeMillis());
                        }
                    }
                }else {
                    long timeElapsed = System.currentTimeMillis() - dc.golemLaunchCooldown.get(player.getUniqueId());
                    if (timeElapsed >= 20000){
                        for (Entity ent:
                                player.getWorld().getNearbyEntities(player.getLocation(),8,10,8)) {
                            if (ent != player) {
                                ent.setVelocity(new Vector(0, 2, 0));
                                dc.golemLaunchCooldown.put(player.getUniqueId(),System.currentTimeMillis());
                            }
                        }

                    }
                }

            }
        }

        if (pHelm != null && (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK))){
            if (pHelm.isSimilar(tntHelmet)){
                RayTraceResult hit = world.rayTraceBlocks(player.getEyeLocation(),player.getEyeLocation().getDirection(), 200, FluidCollisionMode.NEVER,true);
                if (hit != null) {
                    if (!dc.tntCooldown.containsKey(player.getUniqueId())) {
                        dc.tntCooldown.put(player.getUniqueId(), System.currentTimeMillis());
                        world.createExplosion(hit.getHitPosition().toLocation(world), explosionAmt / 50);
                    } else {
                        long timeElapsed = System.currentTimeMillis() - dc.tntCooldown.get(player.getUniqueId());
                        if (timeElapsed >= 750) {
                            world.createExplosion(hit.getHitPosition().toLocation(world), explosionAmt / 50);
                            dc.tntCooldown.put(player.getUniqueId(), System.currentTimeMillis());
                        }
                    }
                }
            }
            if (pHelm.isSimilar(cactusHelmet)){
                RayTraceResult hit = world.rayTraceEntities(player.getEyeLocation(),player.getEyeLocation().getDirection(),100,-0.2);

                if (hit != null){
                    if (hit.getHitEntity() instanceof LivingEntity ent && ent != player) {
                        ent.damage(0.5,player);
                        if (ent instanceof Player p) {
                            p.sendTitle(ChatColor.GREEN + "You've been pricked", "by: " + player.getName(), 0, 5, 0);
                            player.setFoodLevel(p.getFoodLevel() + 1);
                        }
                    }
                }
            }
            if (pHelm.isSimilar(featherHelmet)){
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,100,1,false,false,false));
            }
            if (pHelm.isSimilar(brewingHelmet)){
                ItemStack potion = new ItemStack(Material.LINGERING_POTION);
                if (potion.getItemMeta() instanceof PotionMeta potMeta) {
                    PotionEffectType rnd = dc.negativePots().get(ThreadLocalRandom.current().nextInt(dc.negativePots().size()));
                    potMeta.addCustomEffect(rnd.createEffect(100, 1),true);
                    potion.setItemMeta(potMeta);
                    ThrownPotion thrownPotion = player.launchProjectile(ThrownPotion.class);
                    thrownPotion.setItem(potion);
                }
            }
            if (pHelm.isSimilar(woodHelmet)){
                if (dc.getRandomNumber(1,40) == 11) {
                    player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
                }
                else {
                    player.getInventory().addItem(new ItemStack(Material.APPLE));
                }
            }
            if (pHelm.isSimilar(blazeHelmet)){
                player.launchProjectile(Fireball.class);
            }
            else if (pHelm.isSimilar(golemHelmet)){
                RayTraceResult hit = world.rayTraceEntities(player.getEyeLocation(),player.getEyeLocation().getDirection(),100,-0.2);
                if (!dc.golemCreateCooldown.containsKey(player.getUniqueId())) {
                    if (hit != null && hit.getHitEntity() != player && hit.getHitEntity() instanceof LivingEntity livingEntity) {
                        IronGolem ironGolem = world.spawn(player.getLocation(), IronGolem.class);
                        ironGolem.setHealth(ironGolem.getHealth() / 4);
                        ironGolem.setTarget(livingEntity);
                        dc.golemCreateCooldown.put(player.getUniqueId(), System.currentTimeMillis());
                    }
                } else {
                    long timeElapsed = System.currentTimeMillis() - dc.golemCreateCooldown.get(player.getUniqueId());
                    if (timeElapsed >= 25000) {
                        if (hit != null && hit.getHitEntity() != player && hit.getHitEntity() instanceof LivingEntity livingEntity) {
                            IronGolem ironGolem = world.spawn(player.getLocation(), IronGolem.class);
                            ironGolem.setHealth(ironGolem.getHealth() / 4);
                            ironGolem.setTarget(livingEntity);
                            dc.golemCreateCooldown.put(player.getUniqueId(), System.currentTimeMillis());
                        }
                    }
                }



            }

        }

    }

}
