package makaota.app.recipeappui

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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


}

