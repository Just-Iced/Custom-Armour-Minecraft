package me.justiced.customarmour.crafting;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class WoodArmorCrafting extends ArmorCrafter {

    public WoodArmorCrafting(Plugin plugin){
        super(plugin,Material.OAK_LOG,"wood");
    }

    @Override
    public ItemStack getChest(){
        ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta itemMeta = chest.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_GRAY + "Wood Chestplate");
        itemMeta.setUnbreakable(true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Use to spawn some trees");
        itemMeta.setLore(lore);
        chest.setItemMeta(itemMeta);
        chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        return chest;
    }
    @Override
    public ItemStack getBoots(){
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta itemMeta = boots.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_GRAY + "Wood Boots");
        itemMeta.setUnbreakable(true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "");
        itemMeta.setLore(lore);
        boots.setItemMeta(itemMeta);
        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        return boots;
    }
    @Override
    public ItemStack getLegs(){
        ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta itemMeta = legs.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_GRAY + "Wood Leggings");
        itemMeta.setUnbreakable(true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Crouch to mine wood");
        itemMeta.setLore(lore);
        legs.setItemMeta(itemMeta);
        legs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        return legs;
    }
    @Override
    public ItemStack getHelmet(){
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta itemMeta = helmet.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_GRAY + "Wood Helmet");
        itemMeta.setUnbreakable(true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "");
        itemMeta.setLore(lore);
        helmet.setItemMeta(itemMeta);
        helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        return helmet;
    }
}