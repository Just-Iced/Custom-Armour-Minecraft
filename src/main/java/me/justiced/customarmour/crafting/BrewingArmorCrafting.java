package me.justiced.customarmour.crafting;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import me.justiced.customarmour.crafting.ArmorCrafter;

import java.util.ArrayList;

public class BrewingArmorCrafting extends ArmorCrafter {

    public BrewingArmorCrafting(Plugin plugin){
        super(plugin,Material.GLASS_BOTTLE,"brewing");
    }

    @Override
    public ItemStack getChest(){
        ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta itemMeta = chest.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_BLUE + "Brewing Chestplate");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Right click to give everyone friends");
        itemMeta.setLore(lore);
        chest.setItemMeta(itemMeta);
        chest.addEnchantment(Enchantment.DURABILITY, 1);
        return chest;
    }
    @Override
    public ItemStack getBoots(){
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta itemMeta = boots.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_BLUE + "Brewing Boots");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Negates all fall damage");
        itemMeta.setLore(lore);
        boots.setItemMeta(itemMeta);
        boots.addEnchantment(Enchantment.DURABILITY, 1);
        return boots;
    }
    @Override
    public ItemStack getLegs(){
        ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta itemMeta = legs.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_BLUE + "Brewing Leggings");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Crouch to remove nearby friends");
        itemMeta.setLore(lore);
        legs.setItemMeta(itemMeta);
        legs.addEnchantment(Enchantment.DURABILITY, 1);
        return legs;
    }
    @Override
    public ItemStack getHelmet(){
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta itemMeta = helmet.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_BLUE + "Brewing Helmet");
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Use with friends!");
        itemMeta.setLore(lore);
        helmet.setItemMeta(itemMeta);
        helmet.addEnchantment(Enchantment.DURABILITY, 1);
        return helmet;
    }
}