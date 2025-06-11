package me.justiced.customarmour.crafting;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class GolemArmorCrafting extends ArmorCrafter {

    public GolemArmorCrafting(Plugin plugin){
        super(plugin,Material.IRON_BLOCK,"golem");
    }

    @Override
    public ItemStack getChest(){
        ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta itemMeta = chest.getItemMeta();
        itemMeta.setDisplayName(ChatColor.WHITE + "Golem Chestplate");
        itemMeta.setUnbreakable(true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "");
        itemMeta.setLore(lore);
        chest.setItemMeta(itemMeta);
        chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        return chest;
    }
    @Override
    public ItemStack getBoots(){
        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemMeta itemMeta = boots.getItemMeta();
        itemMeta.setDisplayName(ChatColor.WHITE + "Golem Boots");
        itemMeta.setUnbreakable(true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "");
        itemMeta.setLore(lore);
        boots.setItemMeta(itemMeta);
        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        return boots;
    }
    @Override
    public ItemStack getLegs(){
        ItemStack legs = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta itemMeta = legs.getItemMeta();
        itemMeta.setDisplayName(ChatColor.WHITE + "Golem Leggings");
        itemMeta.setUnbreakable(true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "");
        itemMeta.setLore(lore);
        legs.setItemMeta(itemMeta);
        legs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        return legs;
    }
    @Override
    public ItemStack getHelmet(){
        ItemStack helmet = new ItemStack(Material.IRON_HELMET);
        ItemMeta itemMeta = helmet.getItemMeta();
        itemMeta.setDisplayName(ChatColor.WHITE + "Golem Helmet");
        itemMeta.setUnbreakable(true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "");
        itemMeta.setLore(lore);
        helmet.setItemMeta(itemMeta);
        helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        return helmet;
    }
}