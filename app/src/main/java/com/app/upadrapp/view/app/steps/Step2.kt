package com.app.upadrapp.view.app.steps

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.app.upadrapp.R
import com.app.upadrapp.shared.DatePickerModal
import com.app.upadrapp.shared.DialTimePicker
import com.app.upadrapp.shared.Subtitle
import com.app.upadrapp.shared.Title
import com.app.upadrapp.ui.theme.BorderColor
import com.app.upadrapp.ui.theme.DarkBlue
import com.app.upadrapp.ui.theme.MediumTurquoise

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Step2(onClick: () -> Unit,onBackButtonClick:()->Unit) {
    val isDatePickerOpen = remember {
        mutableStateOf(false)
    }
    val isTimePickerOpen = remember {
        mutableStateOf(false)
    }
    val selectedDate = remember {
        mutableStateOf("")
    }
    Log.d("selectedDate", selectedDate.value.toString())
    Column {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.applogo),
                contentDescription = "app logo",
                modifier = Modifier.size(190.dp)
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .clip(shape = RoundedCornerShape(50.dp, 50.dp))
            .background(Color.White)
            .padding(20.dp, 15.dp)
    ) {
        Title(text = "Next", color = Color.Black, fontSize = 24)
        Subtitle(
            text = "Let’s determine when your procedure is so we can start your prep on schedule.",
            color = Color(0xFFB9B9B9)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column {
            Text(text = "Date", color = Color(0xFF666666))
            Spacer(modifier = Modifier.height(5.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { isDatePickerOpen.value = true }
                .height(50.dp)
                .border(width = 1.dp, color = BorderColor, shape = MaterialTheme.shapes.medium)
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = if (selectedDate.value != "") selectedDate.value else "mm/dd/yyyy")
                Icon(
                    Icons.Filled.DateRange,
                    contentDescription = "DateRange",
                    tint = MediumTurquoise
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Column {
            Text(text = "Time", color = Color(0xFF666666))
            Spacer(modifier = Modifier.height(5.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { isTimePickerOpen.value = true }
                .height(50.dp)
                .border(width = 1.dp, color = BorderColor, shape = MaterialTheme.shapes.medium)
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = if (selectedDate.value != "") selectedDate.value else "HH:MM")
                Icon(
                    Icons.Filled.DateRange,
                    contentDescription = "DateRange",
                    tint = MediumTurquoise
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, 0.dp, 0.dp, 30.dp)
        ) {
            OutlinedButton(onClick = { onBackButtonClick() }, border = BorderStroke(2.dp, MediumTurquoise) ) {
                Text(text = "Back", color = MediumTurquoise, fontWeight = FontWeight.W600)
            }
            ExtendedFloatingActionButton(
                onClick = { onClick() },
                modifier = Modifier
                    .width(160.dp)
                    .height(45.dp),
                shape = MaterialTheme.shapes.extraLarge,
                content = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Title(text = "Next", color = Color.White, fontSize = 16)
                        Icon(
                            Icons.Filled.KeyboardArrowRight,
                            contentDescription = "Extended floating action button.",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                },
                containerColor = DarkBlue
            )
        }
        if (isDatePickerOpen.value) {
            DatePickerModal(onDismiss = {
                isDatePickerOpen.value = false
            }, onDateSelected = {
                selectedDate.value = it.toString()
            })
        }
        if (isTimePickerOpen.value) {
            DialTimePicker(onDismiss = {
                isTimePickerOpen.value = false
            }, onConfirm = {})
        }
    }
}