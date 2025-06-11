package me.justiced.customarmour;

import me.justiced.customarmour.crafting.*;
import me.justiced.customarmour.eventHandlers.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomArmour extends JavaPlugin{
    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            DataClass.get_instance().setCrafting(this);
            getServer().getPluginManager().registerEvents(new PlayerInteractEvent(), this);
            getServer().getPluginManager().registerEvents(new PlayerDamageEvent(), this);
            getServer().getPluginManager().registerEvents(new PlayerCrouchEvent(), this);
            getServer().getPluginManager().registerEvents(new TntExplosionEvent(), this);
            getServer().getPluginManager().registerEvents(new PlayerAttackEvent(), this);
        } catch (Throwable t) {
            System.out.println("Failed to work :(");
            throw t;
        }

    }
}



