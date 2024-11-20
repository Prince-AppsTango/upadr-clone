package com.app.upadrapp.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.upadrapp.MainActivity
import com.app.upadrapp.ui.theme.LightSlateBlue
import kotlinx.coroutines.launch
import  com.app.upadrapp.R
import com.app.upadrapp.store.saveToDataStore
import com.app.upadrapp.utils.Constant

@Composable
fun DrawerContent(drawerState: DrawerState,navController: NavController) {
    val scope = rememberCoroutineScope()
    val context = MainActivity.getAppContext()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightSlateBlue)
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            IconButton(onClick = {
                scope.launch {
                    drawerState.close()
                }
            }) {
                Icon(
                    Icons.Filled.Clear,
                    contentDescription = "Clear",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(50.dp)) {
            DrawerMenuItem("My Procedures", painterResource(id =R.drawable.procedureicon), imageText = "procedureIcon",{
                navController.navigate(Constant.MY_PROCEDURE_SCREEN)
            }, drawerState)
            DrawerMenuItem("Tips", painterResource(id = R.drawable.tipsicon), imageText = "tipsIcon",{
                navController.navigate(Constant.TIPS_SCREEN)
            },drawerState)
            DrawerMenuItem("Surveys", painterResource(id = R.drawable.surveyicon), imageText = "surveyIcon",{
                navController.navigate(Constant.SURVEY_SCREEN)
            },drawerState)
            DrawerMenuItem("Settings", painterResource(id = R.drawable.settingsicon), imageText = "settingsIcon",{
                navController.navigate(Constant.SETTING_SCREEN)
            }, drawerState)
            DrawerMenuItem("Notifications", painterResource(id = R.drawable.notficationiconwhite), imageText = "notficationIconWhite",{
                navController.navigate(Constant.NOTIFICATION_SCREEN)
            },drawerState)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp, 0.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.logout), contentDescription = "logOut",)
            TextButton(onClick = {
              scope.launch {
                  saveToDataStore(context = context, accessToken = "", refreshToken = "")
              }
            }) {
                Text(
                    text = "Log Out",
                    color = Color.White,
                    fontWeight = FontWeight.W400,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
fun DrawerMenuItem(text: String,painter: Painter,imageText:String,onClick:()->Unit,drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(painter = painter, contentDescription = imageText)
        TextButton(onClick = {
            scope.launch {
                drawerState.close()
                onClick()
            }

        }) {
            Text(
                text = text,
                color = Color.White,
                fontWeight = FontWeight.W400,
                fontSize = 20.sp
            )
        }
    }
}
