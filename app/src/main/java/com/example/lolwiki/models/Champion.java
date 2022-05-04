package com.example.lolwiki.models;

import androidx.room.PrimaryKey;

public class Champion {
    @PrimaryKey
    private int id;
    private String name, image, legacyName, positionName, blueEssence, riotPoints, releaseate,
            classes, adaptiveType, resource, health, healthRegen, armor, magiResist, moveSpeed,
            attackDamage, attackRange, bonusAs, description, tier;


}
