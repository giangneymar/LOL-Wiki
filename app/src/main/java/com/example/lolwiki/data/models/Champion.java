package com.example.lolwiki.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "champion")
public class Champion implements Serializable {
    @PrimaryKey
    private int id;
    private String name;
    private String image;
    private String legacyName;
    private String positionName;
    private String blueEssence;
    private String riotPoints;
    private String releaseDate;
    private String classes;
    private String adaptiveType;
    private String resource;
    private String health;
    private String healthRegen;
    private String armor;
    private String magicResist;
    private String moveSpeed;
    private String attackDamage;
    private String attackRange;
    private String bonusAS;
    private String description;
    private String tier;

    public Champion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLegacyName() {
        return legacyName;
    }

    public void setLegacyName(String legacyName) {
        this.legacyName = legacyName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getBlueEssence() {
        return blueEssence;
    }

    public void setBlueEssence(String blueEssence) {
        this.blueEssence = blueEssence;
    }

    public String getRiotPoints() {
        return riotPoints;
    }

    public void setRiotPoints(String riotPoints) {
        this.riotPoints = riotPoints;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getAdaptiveType() {
        return adaptiveType;
    }

    public void setAdaptiveType(String adaptiveType) {
        this.adaptiveType = adaptiveType;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getHealthRegen() {
        return healthRegen;
    }

    public void setHealthRegen(String healthRegen) {
        this.healthRegen = healthRegen;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getMagicResist() {
        return magicResist;
    }

    public void setMagicResist(String magicResist) {
        this.magicResist = magicResist;
    }

    public String getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(String moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public String getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(String attackDamage) {
        this.attackDamage = attackDamage;
    }

    public String getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(String attackRange) {
        this.attackRange = attackRange;
    }

    public String getBonusAS() {
        return bonusAS;
    }

    public void setBonusAS(String bonusAS) {
        this.bonusAS = bonusAS;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }
}
