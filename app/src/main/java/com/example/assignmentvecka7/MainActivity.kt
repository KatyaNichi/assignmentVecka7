
package com.example.assignmentvecka7

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignmentvecka7.ui.theme.AssignmentVecka7Theme
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentVecka7Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp {
                        BlueSquare()
                    }
                }
            }
        }
    }
}

@Composable
fun BlueSquare() {
    var itemList by remember { mutableStateOf(emptyList<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
             horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BlueSquareButtons(
            onXClick = {
                Log.d("ButtonClick", "X button clicked")
                itemList = itemList + "X"
            },
            onYClick = {
                Log.d("ButtonClick", "Y button clicked")
                itemList = itemList + "Y"
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyList(itemList)
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                Log.d("ButtonClick", "Reset button clicked")
                itemList = emptyList()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Reset")
        }
    }
}

@Composable
fun BlueSquareButtons(
    onXClick: () -> Unit,
    onYClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(260.dp)
            .background(Color.Blue)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                onXClick()
            },
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(80.dp)
        ) {
            Text("X")
        }

        Button(
            onClick = {
                onYClick()
            },
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(80.dp)
        ) {
            Text("Y")
        }
    }
}

@Composable
fun MyList(itemList: List<String>) {
    LazyColumn {
        items(itemList.size) { index ->
            MessageRow(itemList[index])
        }
    }
}

@Composable
fun MessageRow(message: String) {
    Text(
        text = message,
        color = Color.Red,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BlueSquarePreview() {
    MyApp {
        BlueSquare()
    }
}
