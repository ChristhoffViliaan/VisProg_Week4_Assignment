package com.example.visprog_week4_assignment

import android.os.Bundle
import androidx.compose.ui.graphics.Color
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCut
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visprog_week4_assignment.ui.theme.VisProg_Week4_AssignmentTheme

class Soal2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisProg_Week4_AssignmentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    View2(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

class Hero(
    val Name: String,
    val Rarity: Rarity,
    val Title: String,
    val TitleColour1: Color,
    val TitleColour2: Color,
    val HeroClass: Class,
    val ClassColour: Color,
    val CP: Int,
    val HP: Int,
    val MaxHP: Int,
    val MP: Int,
    val MaxMp: Int,
    val Level: Int,
    val ATK: Int,
    val DEF: Int,
    val CRIT: Int,
    val SPD: Int,
    val Ability: String,
    val AbilityDescription: String,
)

val MainBackground = Color(0xff0c0d14)
val ButtonBackground = Color(0xff161826)
val ButtonBackground2 = Color(0xff1f2236)
val ButtonBackgroundBoarder = Color(0xff272a41)
val Gold = Color(0xffffb300)
val GoldBackground = Color(0xff302611)
val TextColor = Color(0xff9095aa)

val Mythic = Color(0xffd6173d)
val MythicBackground = Color(0xff3c172a)
val Legendary = Color(0xffffb300)
val LegendaryBackground = Color(0xff302611)
val DemiGod = Color(0xff31ff0d)
val DemiGodBackground = Color(0xff0a3b02)

@Composable
fun View2(modifier: Modifier = Modifier) {
    val heroes = listOf(
        Hero(
            Name = "Alistair",
            Rarity = Rarity.MYTHIC,
            Title = "High Templar",
            TitleColour1 = Color(0xffffb300),
            TitleColour2 = Color(0xff302611),
            HeroClass = Class.Paladin,
            ClassColour = Color(0xffdf3d67),
            CP = 5600,
            HP = 1650,
            MaxHP = 1800,
            MP = 650,
            MaxMp = 800,
            Level = 50,
            ATK = 380,
            DEF = 540,
            CRIT = 22,
            SPD = 105,
            Ability = "Wrath of the Heavens",
            AbilityDescription = "Calls down a celestial hammer, stunning all enemies for 3 seconds and taunting survivors."
        ),

        Hero(
            Name = "Theresa",
            Rarity = Rarity.MYTHIC,
            Title = "Divine Oracle",
            TitleColour1 = Color(0xff31ff0d),
            TitleColour2 = Color(0xff0a3b02),
            HeroClass = Class.Cleric,
            ClassColour = Color(0xff31ff0d),
            CP = 5480,
            HP = 1100,
            MaxHP = 1200,
            MP = 2100,
            MaxMp = 2400,
            Level = 49,
            ATK = 290,
            DEF = 410,
            CRIT = 18,
            SPD = 112,
            Ability = "Divine Restoration",
            AbilityDescription = "Restores health of an ally by 50% your mana max hp and removes all of their negative effects."
        ),

        Hero(
            Name = "Vespera",
            Rarity = Rarity.MYTHIC,
            Title = "Shadowblade",
            TitleColour1 = Color(0xffd617ff),
            TitleColour2 = Color(0xff2e0938),
            HeroClass = Class.Rogue,
            ClassColour = Color(0xffff20e8),
            CP = 5350,
            HP = 890,
            MaxHP = 950,
            MP = 410,
            MaxMp = 600,
            Level = 48,
            ATK = 510,
            DEF = 280,
            CRIT = 35,
            SPD = 145,
            Ability = "Nightfall",
            AbilityDescription = "Vanishes into the shadows and increase movement speed by 100%. If an enemy see's you, gain a burst of speed by 300% for 3 seconds"
        ),

        Hero(
            Name = "Elaria",
            Rarity = Rarity.MYTHIC,
            Title = "Archmage",
            TitleColour1 = Color(0xff03cee7),
            TitleColour2 = Color(0xff062f38),
            HeroClass = Class.Archmage,
            ClassColour = Color(0xff03cee7),
            CP = 5120,
            HP = 450,
            MaxHP = 600,
            MP = 1050,
            MaxMp = 1200,
            Level = 47,
            ATK = 570,
            DEF = 220,
            CRIT = 28,
            SPD = 118,
            Ability = "Arcane Tempest",
            AbilityDescription = "Unleashes a storm of arcane energy that damages all enemies and reduces their speed by 25%."
        ),

        Hero(
            Name = "Draven",
            Rarity = Rarity.MYTHIC,
            Title = "Blood Reaver",
            TitleColour1 = Color(0xffff334b),
            TitleColour2 = Color(0xff3c172a),
            HeroClass = Class.Berserker,
            ClassColour = Color(0xffff334b),
            CP = 5050,
            HP = 1750,
            MaxHP = 1900,
            MP = 380,
            MaxMp = 500,
            Level = 47,
            ATK = 590,
            DEF = 360,
            CRIT = 27,
            SPD = 108,
            Ability = "Crimson Fury",
            AbilityDescription = "Enters a berserk state, greatly increasing attack power and speed both by 75% in exchange for a defence reduction by 50%."
        ),

        Hero(
            Name = "Seraphine",
            Rarity = Rarity.MYTHIC,
            Title = "Star Seer",
            TitleColour1 = Color(0xff9c7cff),
            TitleColour2 = Color(0xff21194a),
            HeroClass = Class.Archmage,
            ClassColour = Color(0xff9c7cff),
            CP = 4970,
            HP = 620,
            MaxHP = 750,
            MP = 980,
            MaxMp = 1100,
            Level = 46,
            ATK = 535,
            DEF = 250,
            CRIT = 31,
            SPD = 125,
            Ability = "Astral Comet",
            AbilityDescription = "Summons a falling comet that deals heavy AOE damage and stuns the main target for a period between 6-24 seconds based on distance"
        ),

        Hero(
            Name = "Kael",
            Rarity = Rarity.MYTHIC,
            Title = "Iron Vanguard",
            TitleColour1 = Color(0xff5ddcff),
            TitleColour2 = Color(0xff102d3a),
            HeroClass = Class.Paladin,
            ClassColour = Color(0xffdf3d67),
            CP = 4860,
            HP = 1580,
            MaxHP = 1750,
            MP = 540,
            MaxMp = 700,
            Level = 46,
            ATK = 350,
            DEF = 570,
            CRIT = 16,
            SPD = 92,
            Ability = "Iron Bastion",
            AbilityDescription = "Raises an impenetrable barrier that redirects damage all to the user and reduces damage by 30% in exchange for being immobile."
        ),

        Hero(
            Name = "Nyx",
            Rarity = Rarity.MYTHIC,
            Title = "Night Stalker",
            TitleColour1 = Color(0xffd85cff),
            TitleColour2 = Color(0xff291335),
            HeroClass = Class.Rogue,
            ClassColour = Color(0xffff20e8),
            CP = 4740,
            HP = 820,
            MaxHP = 900,
            MP = 470,
            MaxMp = 650,
            Level = 45,
            ATK = 480,
            DEF = 260,
            CRIT = 38,
            SPD = 152,
            Ability = "Phantom Strike",
            AbilityDescription = "Teleports behind an enemy and delivers a devastating attack with an increased crit change of 300%."
        ),

        Hero(
            Name = "Brom",
            Rarity = Rarity.MYTHIC,
            Title = "Mountain King",
            TitleColour1 = Color(0xffffa726),
            TitleColour2 = Color(0xff3d2810),
            HeroClass = Class.Berserker,
            ClassColour = Color(0xffff7043),
            CP = 4610,
            HP = 1820,
            MaxHP = 2000,
            MP = 300,
            MaxMp = 450,
            Level = 44,
            ATK = 525,
            DEF = 420,
            CRIT = 20,
            SPD = 84,
            Ability = "Mountain Breaker",
            AbilityDescription = "Smashes the ground with tremendous force, damaging nearby enemies and stunning them for 6 seconds."
        ),

        Hero(
            Name = "Liora",
            Rarity = Rarity.MYTHIC,
            Title = "Dawnkeeper",
            TitleColour1 = Color(0xffffe066),
            TitleColour2 = Color(0xff3b3211),
            HeroClass = Class.Cleric,
            ClassColour = Color(0xff31ff0d),
            CP = 4520,
            HP = 980,
            MaxHP = 1100,
            MP = 1750,
            MaxMp = 2000,
            Level = 44,
            ATK = 310,
            DEF = 380,
            CRIT = 21,
            SPD = 110,
            Ability = "Radiant Dawn",
            AbilityDescription = "Bathes allies in holy light, healing them over time by 10% the users max mana every 6 seconds as long as they don't get hit for a full minute."
        ),

        Hero(
            Name = "Ragnar",
            Rarity = Rarity.LEGENDARY,
            Title = "Stormbreaker",
            TitleColour1 = Color(0xff03cee7),
            TitleColour2 = Color(0xff062f38),
            HeroClass = Class.Berserker,
            ClassColour = Color(0xffff7043),
            CP = 6380,
            HP = 1450,
            MaxHP = 1600,
            MP = 350,
            MaxMp = 500,
            Level = 43,
            ATK = 470,
            DEF = 340,
            CRIT = 24,
            SPD = 101,
            Ability = "Thunder Crash",
            AbilityDescription = "Slams the battlefield with lightning, dealing heavy damage and briefly stunning the main target for 24 seconds and other affected creatures for 12 seconds as well as electrifying the battlefield."
        ),

        Hero(
            Name = "Celeste",
            Rarity = Rarity.LEGENDARY,
            Title = "Moon Priestess",
            TitleColour1 = Color(0xffbba8ff),
            TitleColour2 = Color(0xff29203f),
            HeroClass = Class.Cleric,
            ClassColour = Color(0xff31ff0d),
            CP = 6210,
            HP = 900,
            MaxHP = 1050,
            MP = 1600,
            MaxMp = 1850,
            Level = 42,
            ATK = 280,
            DEF = 350,
            CRIT = 19,
            SPD = 108,
            Ability = "Lunar Blessing",
            AbilityDescription = "Calls upon the moon to heal every ally in a 30 ft radius by 35% of the user's mana and removes all status conditions."
        ),

        Hero(
            Name = "Darius",
            Rarity = Rarity.LEGENDARY,
            Title = "Golden Champion",
            TitleColour1 = Color(0xffffd54f),
            TitleColour2 = Color(0xff4a3810),
            HeroClass = Class.Paladin,
            ClassColour = Color(0xffdf3d67),
            CP = 6150,
            HP = 1400,
            MaxHP = 1550,
            MP = 500,
            MaxMp = 650,
            Level = 41,
            ATK = 360,
            DEF = 490,
            CRIT = 17,
            SPD = 96,
            Ability = "Golden Aegis",
            AbilityDescription = "Creates a radiant shield that absorbs all energy attacks and reflects them back in the form of an energy bullet at 300% damage. After using this, the user is stunned for 12 seconds."
        ),

        Hero(
            Name = "Aurelia",
            Rarity = Rarity.DEMIGOD,
            Title = "Celestial Empress",
            TitleColour1 = Color(0xffffffff),
            TitleColour2 = Color(0xff303040),
            HeroClass = Class.Archmage,
            ClassColour = Color(0xff03cee7),
            CP = 7999,
            HP = 1350,
            MaxHP = 1600,
            MP = 2400,
            MaxMp = 2600,
            Level = 55,
            ATK = 680,
            DEF = 510,
            CRIT = 35,
            SPD = 135,
            Ability = "Judgment of the Stars",
            AbilityDescription = "Calls upon divine celestial power to devastate all enemies by damaging and blinding them for 18 seconds and empower every ally within a 60ft radius by increasing both attack, defense, crit chance by 50% as well as removing all status conditions and refilling 50% of mana from allies."
        )
    )
    var Filter by rememberSaveable { mutableIntStateOf(0) }
    val filteredHeroes = if (Filter == 0) {
        heroes
    } else {
        heroes.filter {
            it.HeroClass == Class.entries[Filter - 1]
        }
    }
    val classCounts = Class.entries.associateWith { heroClass ->
        heroes.count { it.HeroClass == heroClass }
    }
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MainBackground)
            .padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            )
    ) {
        item {
            Spacer(Modifier.height(56.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Party Roster",
                        color = Color(0xffffffff),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )//Party Roster
                    Text(
                        text = if (heroes.size == 1) {
                            "Guild Vanguard • ${heroes.size} Hero Available"
                        } else {
                            "Guild Vanguard • ${heroes.size} Heroes Available"
                        },
                        color = TextColor,
                        fontSize = 12.sp
                    )//Guild Vanguard
                }
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(GoldBackground)
                        .border(
                            width = 1.dp,
                            color = Gold,
                            shape = RoundedCornerShape(50)
                        )
                        .padding(
                            horizontal = 8.dp,
                            vertical = 2.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {//Expedition box thingy (I hope it's just a box and not a button)
                    Text(
                        text = "★ Expedition",
                        color = Gold,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )//Expedition
                }
            }
            Spacer(modifier.height(12.dp))
        }
        item {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFF1f1c33))
                    .border(
                        1.dp,
                        Color(0xFF9A7200),
                        RoundedCornerShape(16.dp)
                    )
                    .padding(12.dp)
            ) {//Expedition squad card thingy that does nothing
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(7.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF00D084))
                        )//Green Circle
                        Spacer(Modifier.width(7.dp))
                        Text(
                            "EXPEDITION SQUAD (3/4)",
                            color = Color(0xFFA8A8B5),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )//Expedition Squad
                        Spacer(Modifier.weight(1f))
                        Row() {//CP bar
                            Text(
                                text = "⚔️",
                                fontSize = 12.sp
                            )//Sword thingy
                            Spacer(Modifier.width(2.dp))
                            Text(
                                text = "14750 CP",
                                color = Gold,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )//CP
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(RoundedCornerShape(9.dp))
                                .background(Color(0xffffffff))
                                .border(
                                    1.dp,
                                    Color(0xFFdf3d67),
                                    RoundedCornerShape(9.dp)
                                )
                                .clickable {

                                }
                        ) {//Left box
                            Image(
                                painter = painterResource(id = R.drawable.berserker),
                                contentDescription = "",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )//Sword dude
                        }
                        Spacer(Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(RoundedCornerShape(9.dp))
                                .background(Color(0xffffffff))
                                .border(
                                    1.dp,
                                    Color(0xFF03cee7),
                                    RoundedCornerShape(9.dp)
                                )
                                .clickable {

                                }
                        ) {//Middle box
                            Image(
                                painter = painterResource(id = R.drawable.archmage),
                                contentDescription = "",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )//Staff person
                        }
                        Spacer(Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .size(43.dp)
                                .clip(RoundedCornerShape(9.dp))
                                .background(Color(0xffffffff))
                                .border(
                                    1.dp,
                                    Color(0xFFffbc20),
                                    RoundedCornerShape(9.dp)
                                )
                                .clickable { }
                        ) {//Right box
                            Image(
                                painter = painterResource(id = R.drawable.paladin),
                                contentDescription = "",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )//Totally rich and spoiled sword guy
                        }
                        Spacer(Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .size(43.dp)
                                .clip(RoundedCornerShape(9.dp))
                                .background(Color(0xFF1b192e))
                                .border(
                                    1.dp,
                                    Color(0xFF282844),
                                    RoundedCornerShape(9.dp)
                                )
                                .clickable {

                                },
                            contentAlignment = Alignment.Center
                        ) {//Extra box
                            Text(
                                "+",
                                color = Color(0xFF77778A),
                                fontSize = 18.sp
                            )//Random [+]
                        }
                        Spacer(Modifier.weight(1f))
                        Box(
                            modifier = Modifier
                                .width(78.dp)
                                .height(38.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Gold)
                                .clickable {

                                },
                            contentAlignment = Alignment.Center
                        ) {//Deploy box thingy
                            Text(
                                "Deploy ⚡",
                                color = Color(0xFF000000),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )//Deploy and fun lightning bolt
                        }
                    }
                }
            }
            Spacer(modifier.height(12.dp))
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(38.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(ButtonBackground)
                    .border(
                        1.dp,
                        ButtonBackgroundBoarder,
                        RoundedCornerShape(12.dp)
                    )
                    .padding(horizontal = 12.dp),
                contentAlignment = Alignment.CenterStart
            ) {//Useless search bar
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = TextColor,
                        modifier = Modifier.size(17.dp)
                    )//Iconic Search icon
                    Spacer(Modifier.width(10.dp))
                    Text(
                        text = "Search by hero name, class, or rarity...",
                        color = TextColor,
                        fontSize = 12.sp
                    )
                }
            }
            Spacer(modifier.height(12.dp))
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(40))
                            .background(
                                if (Filter == 0) GoldBackground
                                else ButtonBackground
                            )
                            .clickable {
                                Filter = 0
                            }
                            .border(
                                1.dp,
                                if (Filter == 0) Gold
                                else ButtonBackgroundBoarder,
                                RoundedCornerShape(40.dp)
                            )
                            .padding(
                                horizontal = 10.dp,
                                vertical = 2.dp
                            )
                    ) {//All button, actually usable
                        Text(
                            text = "All (${heroes.size})",
                            color = if (Filter == 0) Gold else TextColor,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )//All
                    }
                    Class.entries.forEachIndexed { index, heroClass ->
                        val filterIndex = index + 1
                        val count = classCounts[heroClass] ?: 0
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(40))
                                .background(
                                    if (Filter == filterIndex) GoldBackground
                                    else ButtonBackground
                                )
                                .border(
                                    1.dp,
                                    if (Filter == filterIndex) Gold
                                    else ButtonBackgroundBoarder,
                                    RoundedCornerShape(40.dp)
                                )
                                .clickable {
                                    Filter = filterIndex
                                }
                                .padding(
                                    horizontal = 10.dp,
                                    vertical = 2.dp
                                )
                        ) {//Buttons, actually usable
                            Text(
                                text = "${heroClass.name} ($count)",
                                color = if (Filter == filterIndex)
                                    Gold
                                else TextColor,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )//Changeable Text
                        }
                    }
                }
                Spacer(Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(40.dp))
                        .background(ButtonBackground)
                        .border(
                            1.dp,
                            ButtonBackgroundBoarder,
                            RoundedCornerShape(40.dp)
                        )
                        .clickable {

                        }
                        .padding(
                            horizontal = 10.dp,
                            vertical = 2.dp
                        )
                ) {//Sort by button. Also useless
                    Text(
                        text = "Sort: Power",
                        color = Gold,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )//Sort: Power
                }
            }
            Spacer(modifier.height(12.dp))
        }
        itemsIndexed(filteredHeroes) { index, hero ->
            HeroCard(hero)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun HeroCard(hero: Hero) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                expanded = !expanded
            }
            .background(ButtonBackground)
            .border(
                1.dp,
                ButtonBackgroundBoarder,
                RoundedCornerShape(16.dp)
            )
            .padding(10.dp)
            .animateContentSize()
    ) {
        if (expanded) {
            HeroDetails(hero)
        } else {
            HeroCardContent(hero)
        }
    }
}

@Composable
private fun HeroCardContent(hero: Hero) {
    Card(
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        when (hero.Rarity) {
                            Rarity.MYTHIC -> MythicBackground
                            Rarity.LEGENDARY -> LegendaryBackground
                            Rarity.DEMIGOD -> DemiGodBackground
                        }
                    )
                    .border(
                        width = 1.dp,
                        color = when (hero.Rarity) {
                            Rarity.MYTHIC -> Mythic
                            Rarity.LEGENDARY -> Legendary
                            Rarity.DEMIGOD -> DemiGod
                        },
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(
                        top = 3.dp,
                        bottom = 3.dp,
                        start = 6.dp,
                        end = 6.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = hero.Rarity.name,
                    color = when (hero.Rarity) {
                        Rarity.MYTHIC -> Mythic
                        Rarity.LEGENDARY -> Legendary
                        Rarity.DEMIGOD -> DemiGod
                    },
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 9.sp
                )
            }
            Spacer(Modifier.width(8.dp))
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(hero.TitleColour2)
                    .border(
                        width = 1.dp,
                        color = hero.TitleColour1,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(
                        top = 3.dp,
                        bottom = 3.dp,
                        start = 6.dp,
                        end = 6.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = hero.Title,
                    color = hero.TitleColour1,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 9.sp
                )
            }
            Spacer(Modifier.weight(1f))
            Row {
                Text(
                    text = "⚔️",
                    fontSize = 12.sp
                )

                Spacer(Modifier.width(2.dp))

                Text(
                    text = "${hero.CP} CP",
                    color = Gold,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(9.dp))
                    .background(Color.White)
                    .border(
                        1.dp,
                        hero.ClassColour,
                        RoundedCornerShape(9.dp)
                    )
            ) {
                Image(
                    painter = painterResource(
                        id = when (hero.HeroClass) {
                            Class.Berserker -> R.drawable.berserker
                            Class.Archmage -> R.drawable.archmage
                            Class.Paladin -> R.drawable.paladin
                            Class.Rogue -> R.drawable.rogue
                            Class.Cleric -> R.drawable.cleric
                        }
                    ),
                    contentDescription = hero.Name,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(Modifier.width(12.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = hero.Name,
                        color = Color(0xffffffff),
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "﹀ ",
                        color = TextColor,
                        fontSize = 17.sp
                    )
                }
                Spacer(Modifier.height(5.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "HP",
                        color = TextColor,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(28.dp)
                    )

                    StatBar(
                        current = hero.HP,
                        max = hero.MaxHP,
                        color = Color(0xFFff334b)
                    )

                    Spacer(Modifier.weight(1f))

                    Text(
                        text = "${hero.HP} / ${hero.MaxHP}",
                        color = TextColor,
                        fontSize = 9.sp
                    )
                }

                Spacer(Modifier.height(5.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "MP",
                        color = TextColor,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(28.dp)
                    )

                    StatBar(
                        current = hero.MP,
                        max = hero.MaxMp,
                        color = Color(0xFF1d85e0)
                    )

                    Spacer(Modifier.weight(1f))

                    Text(
                        text = "${hero.MP} / ${hero.MaxMp}",
                        color = TextColor,
                        fontSize = 9.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun HeroDetails(hero: Hero) {
    Card(
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        when (hero.Rarity) {
                            Rarity.MYTHIC -> MythicBackground
                            Rarity.LEGENDARY -> LegendaryBackground
                            Rarity.DEMIGOD -> DemiGodBackground
                        }
                    )
                    .border(
                        width = 1.dp,
                        color = when (hero.Rarity) {
                            Rarity.MYTHIC -> Mythic
                            Rarity.LEGENDARY -> Legendary
                            Rarity.DEMIGOD -> DemiGod
                        },
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(
                        top = 3.dp,
                        bottom = 3.dp,
                        start = 6.dp,
                        end = 6.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = hero.Rarity.name,
                    color = when (hero.Rarity) {
                        Rarity.MYTHIC -> Mythic
                        Rarity.LEGENDARY -> Legendary
                        Rarity.DEMIGOD -> DemiGod
                    },
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 9.sp
                )
            }
            Spacer(Modifier.width(8.dp))
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(hero.TitleColour2)
                    .border(
                        width = 1.dp,
                        color = hero.TitleColour1,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(
                        top = 3.dp,
                        bottom = 3.dp,
                        start = 6.dp,
                        end = 6.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = hero.Title,
                    color = hero.TitleColour1,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 9.sp
                )
            }
            Spacer(Modifier.weight(1f))
            Row {
                Text(
                    text = "⚔️",
                    fontSize = 12.sp
                )
                Spacer(Modifier.width(2.dp))
                Text(
                    text = "${hero.CP} CP",
                    color = Gold,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(9.dp))
                    .background(Color.White)
                    .border(
                        1.dp,
                        hero.ClassColour,
                        RoundedCornerShape(9.dp)
                    )
            ) {
                Image(
                    painter = painterResource(
                        id = when (hero.HeroClass) {
                            Class.Berserker -> R.drawable.berserker
                            Class.Archmage -> R.drawable.archmage
                            Class.Paladin -> R.drawable.paladin
                            Class.Rogue -> R.drawable.rogue
                            Class.Cleric -> R.drawable.cleric
                        }
                    ),
                    contentDescription = hero.Name,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(Modifier.width(12.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = hero.Name,
                        color = Color(0xffffffff),
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "︿ ",
                        color = TextColor,
                        fontSize = 17.sp
                    )
                }
                Spacer(Modifier.height(5.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "HP",
                        color = TextColor,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(28.dp)
                    )
                    StatBar(
                        current = hero.HP,
                        max = hero.MaxHP,
                        color = Color(0xFFff334b)
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = "${hero.HP} / ${hero.MaxHP}",
                        color = TextColor,
                        fontSize = 9.sp
                    )
                }
                Spacer(Modifier.height(5.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "MP",
                        color = TextColor,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(28.dp)
                    )
                    StatBar(
                        current = hero.MP,
                        max = hero.MaxMp,
                        color = Color(0xFF1d85e0)
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = "${hero.MP} / ${hero.MaxMp}",
                        color = TextColor,
                        fontSize = 9.sp
                    )
                }
            }
        }
        Spacer(Modifier.height(10.dp))
        HorizontalDivider(
            thickness = 1.dp,
            color = ButtonBackgroundBoarder
        )
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            StatBox(hero, StatType.ATK)
            StatBox(hero, StatType.DEF)
            StatBox(hero, StatType.CRIT)
            StatBox(hero, StatType.SPD)
        }
        Spacer(Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(ButtonBackground2)
                .border(
                    1.dp,
                    ButtonBackgroundBoarder,
                    RoundedCornerShape(8.dp)
                )
                .padding(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "★",
                    color = Gold,
                    fontSize = 13.sp
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    text = hero.Ability,
                    color = Gold,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = hero.AbilityDescription,
                color = TextColor,
                fontSize = 10.sp,
                lineHeight = 14.sp
            )
        }
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ActionButton(
                text = "Heal (+250 HP)",
                icon = "🧪",
                color = Color(0xFF4aa94e),
                backgroundColor = Color(0xFF1d2c2c),
                onClick = {

                }
            )
            ActionButton(
                text = "Add to Squad",
                icon = "⚔️",
                color = Color(0xFFe5a102),
                backgroundColor = Color(0xFF45371e),
                onClick = {

                }
            )
        }
    }
}

@Composable
private fun RowScope.ActionButton(
    text: String,
    icon: String,
    color: Color,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .weight(1f)
            .height(34.dp)
            .clip(RoundedCornerShape(9.dp))
            .background(backgroundColor)
            .border(
                1.dp,
                color,
                RoundedCornerShape(9.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = icon,
                fontSize = 16.sp
            )
            Spacer(Modifier.width(5.dp))
            Text(
                text = text,
                color = color,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun RowScope.StatBox(
    hero: Hero,
    type: StatType
) {
    val value = when (type) {
        StatType.ATK -> hero.ATK
        StatType.DEF -> hero.DEF
        StatType.CRIT -> hero.CRIT
        StatType.SPD -> hero.SPD
    }
    Box(
        modifier = Modifier
            .weight(1f)
            .height(38.dp)
            .clip(RoundedCornerShape(7.dp))
            .background(ButtonBackground2)
            .border(
                1.dp,
                ButtonBackgroundBoarder,
                RoundedCornerShape(7.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = type.label,
                color = type.color,
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = if (type == StatType.CRIT) {
                    "$value%"
                } else {
                    value.toString()
                },
                color = Color(0xFFffffff),
                fontSize = 14.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun StatBar(
    current: Int,
    max: Int,
    color: Color
) {
    val percentage1 = (current.toFloat() / max.toFloat()).coerceIn(0f, 1f)
    val percentage2 = ((max.toFloat() - current.toFloat()) / max.toFloat()).coerceIn(0f, 1f)
    Row(
        modifier = Modifier.width(162.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width((160 * percentage1).dp)
                .height(6.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(color)
        )
        Spacer(modifier = Modifier.width(2.dp))
        Box(
            modifier = Modifier
                .width((160 * percentage2).dp)
                .height(6.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Color(0xff0c0d14))
                .padding(end = 1.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Box(
                modifier = Modifier
                    .size(4.dp)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview2() {
    VisProg_Week4_AssignmentTheme {
        View2()
    }
}

enum class Rarity {
    MYTHIC,
    LEGENDARY,
    DEMIGOD
}

enum class Class {
    Berserker,
    Archmage,
    Paladin,
    Rogue,
    Cleric
}

enum class StatType(
    val label: String,
    val color: Color
) {
    ATK("ATK", Color(0xFFf95522)),
    DEF("DEF", Color(0xFF48a34d)),
    CRIT("CRIT", Color(0xFFff9800)),
    SPD("SPD", Color(0xFF02d6ef))
}