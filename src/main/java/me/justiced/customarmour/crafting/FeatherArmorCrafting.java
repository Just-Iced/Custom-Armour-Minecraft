package me.justiced.customarmour.crafting;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class FeatherArmorCrafting extends ArmorCrafter {

    public FeatherArmorCrafting(Plugin plugin){
        super(plugin,Material.FEATHER,"feather");
    }

    @Override
    public ItemStack getChest(){
        ItemStack chest = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta itemMeta = chest.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_GREEN + "Feather Chestplate");
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
        ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta itemMeta = boots.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_GREEN + "Feather Boots");
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
        ItemStack legs = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemMeta itemMeta = legs.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_GREEN + "Feather Leggings");
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
        ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemMeta itemMeta = helmet.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_GREEN + "Feather Helmet");
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