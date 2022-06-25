package makaota.app.recipeappui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import makaota.app.recipeappui.ui.theme.Linen
import makaota.app.recipeappui.ui.theme.RecipeAppUITheme

class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Box(
                modifier = Modifier
                    .background(color = Linen)
                    .fillMaxSize()
            ) {

                Column {
                    TopSection()
                    ImageSection()
                    IngredientsAndServingSection()
                    IngredientsSection()
                    ButtonSection()

                }

            }


        }
    }
}

@Composable
fun TopSection() {

    var title = "Salmon Sushi"

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = "back arrow",
            modifier = Modifier.clickable {

            }
        )
        Column(verticalArrangement = Arrangement.Center) {

            Text(
                text = title,
                style = MaterialTheme.typography.body1
            )

        }

        Image(
            painter = painterResource(id = R.drawable.ic_more_horiz),
            contentDescription = "more horizon",
            modifier = Modifier.clickable {

            }
        )
    }
}

@Composable
fun ImageSection() {

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {

        Card(
            shape = RoundedCornerShape(10.dp),
            elevation = 5.dp
        ) {

            Image(
                painter = painterResource(id = R.drawable.grilled_salmon_sushi_roll_sauce),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )


            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(15.dp)
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
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.clickable {

                        }
                    )

                }
            }
        }

    }

}

@Composable
fun IngredientsAndServingSection() {


    var title = "Ingredients (12)"

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {

        Column(verticalArrangement = Arrangement.Center) {

            Text(
                text = title,
                style = MaterialTheme.typography.body1
            )

        }

        ///////////////////////

        var expanded by remember { mutableStateOf(false) }
        val suggestions = listOf("Item1", "Item2", "Item3")

        Box {
            Button(onClick = { expanded = !expanded }) {
                Text("DropDown")
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                suggestions.forEach { label ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        //do something ...
                    }) {
                        Text(text = label)
                    }
                }
            }
        }
    }


}

@Composable
fun IngredientsSection() {

    var title = "Matcha"
    var item = "1 teaspoon"

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.matcha),
            contentDescription = "matcha",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(50.dp)
                .height(40.dp)
                .clickable {

                }
        )
        Column(verticalArrangement = Arrangement.Center) {

            Text(
                text = title,
                style = MaterialTheme.typography.body1
            )

        }
        Text(
            text = item,
            style = MaterialTheme.typography.body1
        )

    }

    title = "Rice Bowl"
    item = "200 gr"

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.rice),
            contentDescription = "rice bowl",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(50.dp)
                .height(40.dp)
                .clickable {

                }
        )
        Column(verticalArrangement = Arrangement.Center) {

            Text(
                text = title,
                style = MaterialTheme.typography.body1
            )

        }


        Text(
            text = item,
            style = MaterialTheme.typography.body1
        )


    }

    title = "Salmon"
    item = "400 gr"

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.salmon),
            contentDescription = "salmon",
            modifier = Modifier
                .width(50.dp)
                .height(40.dp)
        )
        Column(verticalArrangement = Arrangement.Center) {

            Text(
                text = title,
                style = MaterialTheme.typography.body1
            )

        }

        Text(
            text = item,
            style = MaterialTheme.typography.body1
        )
    }

}

@Composable
fun ButtonSection(){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = {

        }) {
            Text(text = "Navigate", fontSize = 18.sp)

        }
    }
}

