package com.example.visprog_week4_assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visprog_week4_assignment.ui.theme.VisProg_Week4_AssignmentTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.res.painterResource

class Soal1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisProg_Week4_AssignmentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    View1(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

val red = Color(0xffff5c35)
val background = Color(0xFFf6f4f0)
val gray = Color(0xFFb0b8c3)
val SpaceBetweenCars = 16

@Composable
fun View1(modifier: Modifier = Modifier) {
    var currentPage by rememberSaveable() { mutableStateOf(Pages1.MAIN) }
    var selectedCar by rememberSaveable() { mutableIntStateOf(0) }


    val carList = listOf(
        Car(
            Name = "Daihatsu Ayla",
            ImageResId = R.drawable.ayla,
            Value = 145000000,
            City = "Jakarta",
            Year = 2023,
            Mileage = 12000,
            Transmition = Transmission.Auto,
            FuelType = FuelType.Petrol,
            Description = "A compact city car that is easy to drive and practical for everyday use. Its small size makes it convenient for navigating busy streets and parking in tight spaces.",
            Favorite = false
        ),
        Car(
            Name = "Honda CR-V",
            ImageResId = R.drawable.crv,
            Value = 520000000,
            City = "Jakarta",
            Year = 2024,
            Mileage = 8000,
            Transmition = Transmission.Auto,
            FuelType = FuelType.Petrol,
            Description = "A spacious SUV designed for comfortable daily driving and longer journeys. It offers a refined interior with plenty of room for passengers and luggage.",
            Favorite = false
        ),
        Car(
            Name = "Honda HR-V",
            ImageResId = R.drawable.hrv,
            Value = 385000000,
            City = "Bandung",
            Year = 2024,
            Mileage = 6500,
            Transmition = Transmission.Auto,
            FuelType = FuelType.Petrol,
            Description = "A stylish compact SUV with a practical interior and comfortable driving position. It is well suited for both city driving and weekend trips.",
            Favorite = false
        ),
        Car(
            Name = "JAC J5",
            ImageResId = R.drawable.j5,
            Value = 125000000,
            City = "Surabaya",
            Year = 2015,
            Mileage = 48000,
            Transmition = Transmission.Manual,
            FuelType = FuelType.Petrol,
            Description = "A practical sedan with a comfortable cabin and straightforward driving experience. Its sedan body provides useful passenger and luggage space for everyday transportation.",
            Favorite = false
        ),
        Car(
            Name = "MG 4",
            ImageResId = R.drawable.mg4,
            Value = 430000000,
            City = "Jakarta",
            Year = 2024,
            Mileage = 7000,
            Transmition = Transmission.Auto,
            FuelType = FuelType.Electric,
            Description = "A modern electric hatchback with a distinctive design and quiet driving experience. Its electric powertrain makes it well suited for efficient urban transportation.",
            Favorite = false
        ),
        Car(
            Name = "Wuling Almaz",
            ImageResId = R.drawable.reborn,
            Value = 275000000,
            City = "Jakarta",
            Year = 2024,
            Mileage = 9000,
            Transmition = Transmission.Auto,
            FuelType = FuelType.Petrol,
            Description = "A modern SUV with a comfortable interior and practical features for everyday driving. Its spacious cabin makes it suitable for both daily commutes and longer family trips.",
            Favorite = false
        ),
        Car(
            Name = "Chery Tiggo 9 CSH",
            ImageResId = R.drawable.tiggo,
            Value = 245000000,
            City = "Jakarta",
            Year = 2024,
            Mileage = 5000,
            Transmition = Transmission.Auto,
            FuelType = FuelType.PHEV,
            Description = "A modern hybrid SUV with a comfortable interior and advanced features. Its plug-in hybrid powertrain provides a balance between electric driving and longer-distance flexibility.",
            Favorite = false
        ),
        Car(
            Name = "Daihatsu Xenia",
            ImageResId = R.drawable.xenia,
            Value = 220000000,
            City = "Surabaya",
            Year = 2023,
            Mileage = 15000,
            Transmition = Transmission.Auto,
            FuelType = FuelType.Petrol,
            Description = "A practical family MPV with seating space for everyday family transportation. Its versatile interior makes it useful for both passengers and carrying larger amounts of luggage.",
            Favorite = false
        ),
        Car(
            Name = "Toyota Yaris",
            ImageResId = R.drawable.yaris,
            Value = 285000000,
            City = "Bandung",
            Year = 2023,
            Mileage = 11000,
            Transmition = Transmission.Auto,
            FuelType = FuelType.Petrol,
            Description = "A compact hatchback with a sporty appearance and convenient dimensions for city driving. It offers a comfortable cabin while remaining easy to maneuver through urban traffic.",
            Favorite = false
        ),
        Car(
            Name = "Toyota Yaris Cross",
            ImageResId = R.drawable.yariscross,
            Value = 365000000,
            City = "Jakarta",
            Year = 2024,
            Mileage = 6000,
            Transmition = Transmission.Auto,
            FuelType = FuelType.Hybrid,
            Description = "A compact crossover combining the practicality of an SUV with efficient hybrid technology. It provides a comfortable interior and enough versatility for both daily commuting and longer trips.",
            Favorite = false
        )
    )


    var favorites by rememberSaveable {
        mutableStateOf(
            List(10) { index -> carList[index].Favorite }
        )
    }
    val saved = favorites.count { it }


    when (currentPage) {
        Pages1.MAIN -> {
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .background(background)
                    .padding(top = 38.dp)
            ) {
                item {
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .height(110.dp)
                            .padding(all = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom
                    ) {//Top part
                        Column(
                            modifier = modifier
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.SpaceBetween

                        ) {//Left side
                            Box(
                                modifier = modifier
                                    .width(52.dp)
                                    .height(6.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(red)
                            ) {}//Orange Line
                            Text(
                                text = "On Sale",
                                fontSize = 32.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xff000000)
                            )//On Sale
                            Text(
                                text = "Find your perfect ride",
                                fontSize = 14.sp,
                                color = Color(0xFF88939e)
                            )//Find your perfect ride
                        }
                        Row(
                            modifier = modifier
                                .width(82.dp)
                                .height(32.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .border(
                                    width = 2.dp,
                                    color = Color(0xFFfecbbe),
                                    shape = RoundedCornerShape(50.dp)
                                )
                                .background(Color(0xFFfff0ec)),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {//Oval thingy
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "Saved",
                                tint = red,
                                modifier = Modifier.size(12.dp)
                            )//Heart
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "${saved} saved",
                                color = red,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.ExtraBold
                            )//Saved
                        }
                    }
                }
                item {
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = Color.LightGray

                    )//Random Divider
                    Spacer(Modifier.height(SpaceBetweenCars.dp))
                }
                itemsIndexed(carList) { index, car ->
                    CarList(
                        car = car,
                        favorite = favorites[index],
                        onFavoriteClick = {
                            favorites = favorites.toMutableList().also {
                                it[index] = !it[index]
                            }
                        },
                        onClick = {
                            selectedCar = index
                            currentPage = Pages1.DETAILS
                        }
                    )
                }
            }
        }

        Pages1.DETAILS -> {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(background)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    Image(
                        painter = painterResource(carList[selectedCar].ImageResId),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(310.dp),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(top = 282.dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = 26.dp,
                                    topEnd = 26.dp
                                )
                            )
                            .background(
                                color = background
                            )
                            .padding(all = 24.dp)
                    ) {
                        Row(
                            modifier = modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${carList[selectedCar].Name}",
                                fontSize = 26.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF172333)
                            )//Name
                            Icon(
                                imageVector = if (favorites[selectedCar]) {
                                    Icons.Default.Favorite
                                } else {
                                    Icons.Default.FavoriteBorder
                                },
                                contentDescription = "Favorite",
                                tint = if (favorites[selectedCar]) {
                                    red
                                } else {
                                    gray
                                },
                                modifier = Modifier
                                    .size(34.dp)
                                    .clickable {
                                        favorites = favorites.toMutableList().also {
                                            it[selectedCar] = !it[selectedCar]
                                        }
                                    }
                            )//Heart
                        }
                        Spacer(modifier = modifier.height(2.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(7.dp)
                                    .background(
                                        Color(0xFFFF563F),
                                        CircleShape
                                    )
                            )//Random Circle
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "${carList[selectedCar].City}",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF88939e)
                            )//City
                        }
                        Spacer(modifier = modifier.height(16.dp))
                        Box(
                            modifier = modifier
                                .clip(RoundedCornerShape(10.dp))
                                .border(
                                    width = 2.dp,
                                    color = Color(0xFFfecbbe),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .background(Color(0xFFfff0ec)),
                            contentAlignment = Alignment.Center
                        ) {//Oval thingy
                            Text(
                                text = "Rp %,d".format(carList[selectedCar].Value)
                                    .replace(",", "."),
                                color = red,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = modifier.padding(all = 10.dp)
                            )//Cost
                        }
                        Spacer(modifier = modifier.height(22.dp))
                        Text(
                            text = "SPECIFICATIONS",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = gray
                        )//Specifications
                        Spacer(modifier = modifier.height(8.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {//Card thingy
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {//Row1
                                SpecificationCard(
                                    title = "YEAR",
                                    value = "${carList[selectedCar].Year}",
                                    modifier = Modifier.weight(1f)
                                )//Year
                                SpecificationCard(
                                    title = "MILEAGE",
                                    value = "${"%,d".format(carList[selectedCar].Mileage)} km",
                                    modifier = Modifier.weight(1f)
                                )//Mileage
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {//Row2
                                SpecificationCard(
                                    title = "TRANSMISSION",
                                    value = "${carList[selectedCar].Transmition}",
                                    modifier = Modifier.weight(1f)
                                )//Transmission
                                SpecificationCard(
                                    title = "FUEL TYPE",
                                    value = "${carList[selectedCar].FuelType}",
                                    modifier = Modifier.weight(1f)
                                )//Fuel Type
                            }
                        }
                        Spacer(modifier = modifier.height(22.dp))
                        Text(
                            text = "ABOUT THIS CAR",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = gray
                        )//About this car
                        Text(
                            text = carList[selectedCar].Description,
                            fontSize = 13.sp,
                            lineHeight = 17.sp,
                            color = Color(0xFF9ba3ac)
                        )//Description
                    }
                    Box(
                        modifier = Modifier
                            .padding(
                                top = 48.dp,
                                start = 16.dp
                            )
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.9f))
                            .clickable {
                                currentPage = Pages1.MAIN
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(0xFF172333),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Box(
                        modifier = modifier
                            .padding(top = 252.dp, start = 16.dp)
                    ) {
                        FuelBadge(carList[selectedCar].FuelType)
                    }
                }
                Row(
                    modifier = modifier
                        .height(82.dp)
                        .padding(all = 16.dp)
                ) {
                    Box(
                        modifier = modifier
                            .fillMaxHeight()
                            .width(50.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .border(
                                width = 2.dp,
                                color = if (favorites[selectedCar]) {
                                    Color(0xFFfea894)
                                } else {
                                    gray
                                },
                                shape = RoundedCornerShape(16.dp)
                            )
                            .background(
                                if (favorites[selectedCar]) {
                                    Color(0xFFfff0ec)
                                } else {
                                    background
                                },
                            )
                            .clickable {
                                favorites = favorites.toMutableList().also {
                                    it[selectedCar] = !it[selectedCar]
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {//Another Heart
                        Icon(
                            imageVector = if (favorites[selectedCar]) {
                                Icons.Default.Favorite
                            } else {
                                Icons.Default.FavoriteBorder
                            },
                            contentDescription = "Favorite",
                            tint = if (favorites[selectedCar]) {
                                red
                            } else {
                                gray
                            },
                            modifier = Modifier
                                .size(28.dp)
                                .padding(all = 4.dp)

                        )//Heart
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(58.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = red,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(14.dp)
                    ) {//Orange Button
                        Text(
                            text = "Contact Seller",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )//Contact Seller
                    }
                }
            }
        }
    }
}

@Composable
fun CarList(
    car: Car,
    favorite: Boolean,
    onFavoriteClick: () -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(136.dp)
            .padding(
                bottom = SpaceBetweenCars.dp,
                start = 16.dp,
                end = 16.dp
            )
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFffffff)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(width = 112.dp, height = 92.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(background)
            ) {
                Image(
                    painter = painterResource(car.ImageResId),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(
                            horizontal = 7.dp,
                            vertical = 4.dp
                        )
                ) {
                    FuelBadge(car.FuelType)
                }
            }

            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${car.Name}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF172333)
                    )//Name
                    Icon(
                        imageVector = if (favorite) {
                            Icons.Default.Favorite
                        } else {
                            Icons.Default.FavoriteBorder
                        },
                        contentDescription = "Favorite",
                        tint = if (favorite) {
                            red
                        } else {
                            gray
                        },
                        modifier = Modifier
                            .size(21.dp)
                            .clickable {
                                onFavoriteClick()
                            }
                    )//Heart
                }
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = background,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = Color(0xffebe9e5),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(
                            horizontal = 7.dp,
                            vertical = 5.dp
                        )

                ) {//Auto or Manual
                    Text(
                        text = "${car.Transmition}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF7b8795)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .background(
                                Color(0xFFFF563F),
                                CircleShape
                            )
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "${car.Year}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF394656)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "${"%,d".format(car.Mileage)} km",
                        fontSize = 12.sp,
                        color = Color(0xFF7C8794)
                    )
                }
            }
        }
    }
}

@Composable
fun SpecificationCard(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .height(84.dp)
            .clip(RoundedCornerShape(14.dp))
            .border(
                width = 1.dp,
                color = Color(0xFFE5E3DF),
                shape = RoundedCornerShape(14.dp)
            )
            .background(Color.White)
            .padding(14.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = gray
        )

        Text(
            text = value,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF000000)
        )
    }
}

@Composable
fun FuelBadge(fuelType: FuelType) {//The little box thingy at the bottom left of the images
    val text = when (fuelType) {
        FuelType.Petrol -> "PETROL"
        FuelType.Hybrid -> "HYBRID"
        FuelType.PHEV -> "PHEV"
        FuelType.Electric -> "EV"
    }
    val textColor = when (fuelType) {
        FuelType.Petrol -> Color(0xFFf58a2b)
        FuelType.Hybrid -> Color(0xFF00875A)
        FuelType.PHEV -> Color(0xFF5735aa)
        FuelType.Electric -> Color(0xFF0077CC)
    }
    val backgroundColor = when (fuelType) {
        FuelType.Petrol -> Color(0xFFf0ebd5).copy(alpha = 0.9f)
        FuelType.Hybrid -> Color(0xFFd0e7e7).copy(alpha = 0.9f)
        FuelType.PHEV -> Color(0xFFdbd6e4).copy(alpha = 0.9f)
        FuelType.Electric -> Color(0xFF85e9ff).copy(alpha = 0.9f)
    }

    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(6.dp)
            )
            .padding(
                horizontal = 7.dp,
                vertical = 4.dp
            )
    ) {
        Text(
            text = text,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview1() {
    VisProg_Week4_AssignmentTheme {
        View1()
    }
}

class Car(
    val Name: String,
    val ImageResId: Int,
    val Value: Int,
    val City: String,
    val Year: Int,
    val Mileage: Int,
    val Transmition: Transmission,
    val FuelType: FuelType,
    val Description: String,
    var Favorite: Boolean
)

enum class Pages1 {
    MAIN,
    DETAILS
}

enum class Transmission {
    Auto,
    Manual
}

enum class FuelType {
    Petrol,
    Hybrid,
    PHEV,
    Electric
}