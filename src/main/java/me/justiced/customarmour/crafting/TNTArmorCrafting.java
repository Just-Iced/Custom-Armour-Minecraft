package me.justiced.customarmour.crafting;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class TNTArmorCrafting extends ArmorCrafter {

    public TNTArmorCrafting(Plugin plugin){
        super(plugin,Material.TNT,"tnt");
    }

    @Override
    public ItemStack getChest(){
        ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta itemMeta = chest.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "TNT Chestplate");
        itemMeta.setUnbreakable(true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Right click with an empty hand for a present!");
        itemMeta.setLore(lore);
        chest.setItemMeta(itemMeta);
        chest.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
        return chest;
    }
    @Override
    public ItemStack getBoots(){
        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemMeta itemMeta = boots.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "TNT Boots");
        itemMeta.setUnbreakable(true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Negates most fall damage with a little bonus :)");
        itemMeta.setLore(lore);
        boots.setItemMeta(itemMeta);
        boots.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
        return boots;
    }
    @Override
    public ItemStack getLegs(){
        ItemStack legs = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta itemMeta = legs.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "TNT Leggings");
        itemMeta.setUnbreakable(true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Crouch for gifts!");
        itemMeta.setLore(lore);
        legs.setItemMeta(itemMeta);
        legs.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
        legs.addEnchantment(Enchantment.SWIFT_SNEAK, 3);
        return legs;
    }
    @Override
    public ItemStack getHelmet(){
        ItemStack helmet = new ItemStack(Material.IRON_HELMET);
        ItemMeta itemMeta = helmet.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "TNT Helmet");
        itemMeta.setUnbreakable(true);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Use with friends!");
        itemMeta.setLore(lore);
        helmet.setItemMeta(itemMeta);
        helmet.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
        return helmet;
    }
}