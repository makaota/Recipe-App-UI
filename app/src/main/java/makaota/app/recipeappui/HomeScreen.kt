package makaota.app.recipeappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen(){

    Box(
        modifier = Modifier
            .background(Color(0XE9DCC9))
            .fillMaxSize()
    ){
        Column {
            TopMessageSection()
            SearchSection()
        }
    }


}
@Composable
fun TopMessageSection(
    title: String = "Find Best Recipe for Cooking"
){
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ){
        Column(verticalArrangement = Arrangement.Center) {
            
            Text(
                text = title,
                fontSize = 16.sp
            )
            
        }
    }

}

@Composable
fun SearchSection(){

    val textFieldState = remember {
        mutableStateOf("")
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)) {
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