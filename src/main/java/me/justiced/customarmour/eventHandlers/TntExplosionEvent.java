package me.justiced.customarmour.eventHandlers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Explosive;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.util.Vector;

public class TntExplosionEvent implements Listener {
    @EventHandler
    void onTntExplosion(EntityExplodeEvent e){
        if (e.getEntity() instanceof TNTPrimed tnt){
            if (tnt.getCustomName() != null) {
                for (Entity ent:
                        tnt.getWorld().getNearbyEntities(tnt.getLocation(),8,8,8)) {
                    ent.setVelocity(ent.getLocation().toVector().subtract(tnt.getLocation().toVector()).divide(new Vector(10,1,10)));
                }
            }
        }
    }
}
