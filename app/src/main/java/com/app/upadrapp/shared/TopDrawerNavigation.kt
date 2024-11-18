package com.app.upadrapp.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerState
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.upadrapp.R
import com.app.upadrapp.ui.theme.LightCyan
import com.app.upadrapp.utils.Constant
import kotlinx.coroutines.launch

@Composable
fun TopDrawerNavigation(elevation: Int = 0,drawerState: DrawerState,navController:NavController) {
    val scope = rememberCoroutineScope()
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.background(
        LightCyan).fillMaxWidth().shadow(elevation = elevation.dp, spotColor = Color.Transparent).padding(5.dp,0.dp)) {
        IconButton(onClick = {
           scope.launch {
               drawerState.apply {
                   if (isClosed) open() else close()
               }
           }
        },modifier = Modifier.size(50.dp) ) {
            Image(painter = painterResource(id = R.drawable.drawermenu), contentDescription = "drawerMenu")
        }
        IconButton(onClick = { /*TODO*/ },modifier = Modifier.size(80.dp) ) {
            Image(painter = painterResource(id = R.drawable.applogo), contentDescription = "appLogo", modifier = Modifier.size(150.dp) )
        }
        IconButton(onClick = {  navController.navigate(Constant.NOTIFICATION_SCREEN) },modifier = Modifier.size(50.dp) ) {
            Image(painter = painterResource(id = R.drawable.notificationicon), contentDescription = "notificationIcon" )
        }
    }
}