package me.justiced.customarmour;

import me.justiced.customarmour.crafting.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;
import org.checkerframework.checker.units.qual.C;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class DataClass {

    public ArrayList<PotionEffectType> positivePots() {
        ArrayList<PotionEffectType> pots = new ArrayList<>();
        for (PotionEffectType pot :
                PotionEffectType.values()) {
            if (pot.equals(PotionEffectType.REGENERATION) || pot.equals(PotionEffectType.SPEED) ||
                    pot.equals(PotionEffectType.FIRE_RESISTANCE) || pot.equals(PotionEffectType.HEAL) ||
                    pot.equals(PotionEffectType.NIGHT_VISION) || pot.equals(PotionEffectType.INCREASE_DAMAGE) ||
                    pot.equals(PotionEffectType.JUMP) || pot.equals(PotionEffectType.WATER_BREATHING ) ||
                    pot.equals(PotionEffectType.INVISIBILITY) || pot.equals(PotionEffectType.DAMAGE_RESISTANCE)) {
                pots.add(pot);
            }
        }
        return pots;
    }
    public ArrayList<PotionEffectType> negativePots() {
        ArrayList<PotionEffectType> pots = new ArrayList<>();
        for (PotionEffectType pot :
                PotionEffectType.values()) {
            if (!positivePots().contains(pot)) {
                pots.add(pot);
            }
        }
        return pots;
    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    private static DataClass instance = null;
    public HashMap<UUID, Long> blazeCooldown;
    public HashMap<UUID, Long> tntCooldown;
    public HashMap<UUID, Long> tntCrouchCooldown;
    public HashMap<UUID, Long> golemLaunchCooldown;
    public HashMap<UUID, Long> golemCreateCooldown;

    public BlazeArmorCrafting blazeArmorCrafting;                                 //peepeepoopoo
    public BrewingArmorCrafting brewingArmorCrafting;
    public CactusArmorCrafting cactusArmorCrafting;
    public FeatherArmorCrafting featherArmorCrafting;
    public TNTArmorCrafting tntArmorCrafting;
    public WoodArmorCrafting woodArmorCrafting;
    public ChainArmorCrafting chainArmorCrafting;
    public GolemArmorCrafting golemArmorCrafting;

    private DataClass(){
        blazeCooldown = new HashMap<>();
        tntCooldown = new HashMap<>();
        tntCrouchCooldown = new HashMap<>();
        golemLaunchCooldown = new HashMap<>();
        golemCreateCooldown = new HashMap<>();
    }
    public void setCrafting(Plugin plugin){
        this.blazeArmorCrafting = new BlazeArmorCrafting(plugin);                                 //peepeepoopoo
        this.brewingArmorCrafting = new BrewingArmorCrafting(plugin);
        this.cactusArmorCrafting = new CactusArmorCrafting(plugin);
        this.featherArmorCrafting = new FeatherArmorCrafting(plugin);
        this.tntArmorCrafting = new TNTArmorCrafting(plugin);
        this.woodArmorCrafting = new WoodArmorCrafting(plugin);
        this.chainArmorCrafting = new ChainArmorCrafting(plugin);
        this.golemArmorCrafting = new GolemArmorCrafting(plugin);
        blazeArmorCrafting.setCraftingRecipes();
        brewingArmorCrafting.setCraftingRecipes();
        cactusArmorCrafting.setCraftingRecipes();
        featherArmorCrafting.setCraftingRecipes();
        tntArmorCrafting.setCraftingRecipes();
        woodArmorCrafting.setCraftingRecipes();
        chainArmorCrafting.setCraftingRecipes();
        golemArmorCrafting.setCraftingRecipes();
    }
    public static DataClass get_instance() {
        if (instance == null) {
            instance = new DataClass();
        }
        return instance;
    }
}
