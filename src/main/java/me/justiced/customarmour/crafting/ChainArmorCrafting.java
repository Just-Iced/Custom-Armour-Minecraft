package me.justiced.customarmour.crafting;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class ChainArmorCrafting extends ArmorCrafter {

    public ChainArmorCrafting(Plugin plugin){
        super(plugin,Material.CHAIN,"chain");
    }

    @Override
    public ItemStack getChest(){
        return new ItemStack(Material.CHAINMAIL_CHESTPLATE);
    }
    @Override
    public ItemStack getBoots(){
        return new ItemStack(Material.CHAINMAIL_BOOTS);
    }
    @Override
    public ItemStack getLegs(){
        return new ItemStack(Material.CHAINMAIL_LEGGINGS);
    }
    @Override
    public ItemStack getHelmet(){
        return new ItemStack(Material.CHAINMAIL_CHESTPLATE);
    }
}