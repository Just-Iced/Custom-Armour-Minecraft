package me.justiced.customarmour.crafting;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

public class ArmorCrafter {

    Plugin plugin;
    Material mat;
    String name;
    public ArmorCrafter(Plugin plugin, Material mat, String name){
        this.plugin = plugin;
        this.mat = mat;
        this.name = name;
    }

    public void setCraftingRecipes(){
        setCraftChest();
        setCraftBoots();
        setCraftLegs();
        setCraftHelmet();
    }
    private void setCraftChest() {
        ItemStack chest = getChest();
        NamespacedKey key = new NamespacedKey(plugin, name.toUpperCase() + "chestplate");
        ShapedRecipe craftChest = new ShapedRecipe(key, chest);
        craftChest.shape("#.#", "###", "###");
        craftChest.setIngredient('#', mat);
        plugin.getServer().addRecipe(craftChest);
    }

    private void setCraftBoots() {
        ItemStack boots = getBoots();
        NamespacedKey key = new NamespacedKey(plugin, name.toUpperCase() + "boots");
        ShapedRecipe craftBoots = new ShapedRecipe(key, boots);
        craftBoots.shape("...","#.#","#.#");
        craftBoots.setIngredient('#', mat);
        plugin.getServer().addRecipe(craftBoots);
    }

    private void setCraftLegs() {
        ItemStack legs = getLegs();
        NamespacedKey key = new NamespacedKey(plugin, name.toUpperCase() + "leggings");
        ShapedRecipe craftLegs = new ShapedRecipe(key, legs);
        craftLegs.shape("###","#.#","#.#");
        craftLegs.setIngredient('#', mat);
        plugin.getServer().addRecipe(craftLegs);
    }
    private void setCraftHelmet() {
        ItemStack helmet = getHelmet();
        NamespacedKey key = new NamespacedKey(plugin, name.toUpperCase() + "helmet");
        ShapedRecipe craftHelmet = new ShapedRecipe(key, helmet);
        craftHelmet.shape("...","###","#.#");
        craftHelmet.setIngredient('#', mat);
        plugin.getServer().addRecipe(craftHelmet);
    }
    public ItemStack getChest(){
        return null;
    }
    public ItemStack getBoots(){
        return null;
    }
    public ItemStack getLegs(){
        return null;
    }
    public ItemStack getHelmet(){
        return null;
    }
}