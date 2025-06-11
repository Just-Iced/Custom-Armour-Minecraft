package me.justiced.customarmour.crafting;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class CactusArmorCrafting extends ArmorCrafter {

    public CactusArmorCrafting(Plugin plugin){
        super(plugin,Material.CACTUS,"cactus");
    }

    @Override
    public ItemStack getChest(){
        ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta itemMeta = chest.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_GREEN + "Cactus Chestplate");
        itemMeta.setUnbreakable(true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Use to give friends some happiness!");
        itemMeta.setLore(lore);
        chest.setItemMeta(itemMeta);
        chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        return chest;
    }
    @Override
    public ItemStack getBoots(){
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta itemMeta = boots.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_GREEN + "Cactus Boots");
        itemMeta.setUnbreakable(true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Gives a large amount of thorns");
        itemMeta.setLore(lore);
        boots.setItemMeta(itemMeta);
        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        return boots;
    }
    @Override
    public ItemStack getLegs(){
        ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta itemMeta = legs.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_GREEN + "Cactus Leggings");
        itemMeta.setUnbreakable(true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Crouch for cactus");
        itemMeta.setLore(lore);
        legs.setItemMeta(itemMeta);
        legs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        return legs;
    }
    @Override
    public ItemStack getHelmet(){
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta itemMeta = helmet.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_GREEN + "Cactus Helmet");
        itemMeta.setUnbreakable(true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Use for pricking");
        itemMeta.setLore(lore);
        helmet.setItemMeta(itemMeta);
        helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        return helmet;
    }
}