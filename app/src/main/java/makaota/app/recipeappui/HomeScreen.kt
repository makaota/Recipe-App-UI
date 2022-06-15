package makaota.app.recipeappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import makaota.app.recipeappui.ui.theme.DarkGreen
import makaota.app.recipeappui.ui.theme.Linen


@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .background(color = Linen)
            .fillMaxSize()
    ) {
        Column {
            TopMessageSection()
            SearchSection()
            ChipSection(chips = listOf("All", "Sushi", "Burger"))
            CardSection(
                recipesCads = listOf(
                    RecipeCard(
                        "Grilled Salmon Sushi Roll Sauce",
                        R.drawable.grilled_salmon_sushi_roll_sauce,
                        "12 Ingredients " + "|",
                        "40 min"
                    )
                )
            )
        }
    }


}

@Composable
fun TopMessageSection(
    title: String = "Find Best Recipe For Cooking"
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(240.dp)
            .padding(15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {

            Text(
                text = title,
                style = MaterialTheme.typography.h1
            )

        }
    }

}

@Composable
fun SearchSection() {

    val textFieldState = remember {
        mutableStateOf("")
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(

        ) {

            OutlinedTextField(
                value = textFieldState.value,
                onValueChange = {
                    textFieldState.value = it
                },

                placeholder = {
                    Text(
                        text = "Search, Destination",
                        //style = MaterialTheme.typography.h3,
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "search",
                    )
                },
                //textStyle = MaterialTheme.typography.h3,

                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Magenta,
                    unfocusedBorderColor = Color((0xE9DCC9))// linen
                ),
                shape = RoundedCornerShape(25.dp)

            )
        }

        Image(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = "search",
        )
    }

}

@Composable
fun ChipSection(chips: List<String>) {

    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow() {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (selectedChipIndex == it) DarkGreen else Linen)
                    .padding(15.dp)
                    .width(70.dp)
            ) {
                Text(
                    text = chips[it],
                    color = if (selectedChipIndex == it) Color.White else Color.DarkGray,
                    style = MaterialTheme.typography.body1
                )

            }
        }
    }

}

@Composable
fun CardSection(recipesCads: List<RecipeCard>) {

    BoxWithConstraints(
        //  Modifier.MaxHeight()
    )
    {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        {

            Column(verticalArrangement = Arrangement.SpaceBetween) {
                LazyRow(
                    //  cells = GridCells.Fixed(1),
                    contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(recipesCads.size) {
                        CardSectionItem(recipeCard = recipesCads[it])
                        // Spacer(modifier = Modifier.width(15.dp))

                    }
                }
            }
        }
    }
}

@Composable
fun CardSectionItem(recipeCard: RecipeCard) {

    Box(
        //  modifier = Modifier.fillMaxSize()
    ) {
        Card(
            Modifier.fillMaxHeight().width(350.dp),
            RoundedCornerShape(15.dp),
            elevation = 10.dp
        )

        {
            Image(
                painter = painterResource(id = recipeCard.image),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Box(
                Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ), startY = 300f
                        )
                    )
            )
            Box(contentAlignment = Alignment.BottomStart,
                modifier = Modifier.padding(start = 20.dp ,bottom = 55.dp)) {
                Text(
                    text = recipeCard.title,
                    style = MaterialTheme.typography.h2,
                    textAlign = TextAlign.Center

                )
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
            ) {
                Box(
                    contentAlignment = Alignment.BottomStart,
                    modifier = Modifier.padding(20.dp)

                ) {
                    Text(
                        text = recipeCard.aboutIngredients,
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Center

                    )

                }

                Box(
                    contentAlignment = Alignment.BottomStart,
                    modifier = Modifier.padding(bottom = 20.dp)
                ) {
                    Text(
                        text = recipeCard.timeToCook,
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Center

                    )
                }
            }


            Box(
                contentAlignment = Alignment.TopEnd,
                modifier = Modifier.padding(20.dp)
            ) {


                Card(Modifier.size(50.dp), RoundedCornerShape(10.dp)) {

                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        Color.Black
                                    ), startY = 299f, 30f
                                )
                            )
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ic_turned_in),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )

                }
            }

        }

    }
}