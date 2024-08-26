package com.example.lab03_p2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            FlowRowExample()

        }
    }
}

@Composable
fun LazyColumnExample() {
    LazyColumn {
        items(100) { index ->
            Text("Item #$index")
        }
    }
}


@Composable
fun LazyRowExample() {
    LazyRow {
        items(100) { index ->
            Text("Item #$index")
        }
    }
}

@Composable
fun GridExample() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2) // 2 columnas
    ) {
        items(100) { index ->
            Text("Item #$index")
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Scaffold Example") })
        },
        content = { padding ->
            Text("Content", modifier = Modifier.padding(padding))
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        }
    )
}


@Composable
fun SurfaceExample() {
    Box {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background,
            shape = MaterialTheme.shapes.medium
        ) {
            Text("This is inside a Surface", modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun ChipExample() {
    Surface(
        modifier = Modifier.padding(8.dp),
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.primary
    ) {
        Text("Chip Example", modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun BackdropScaffoldExample() {
    BackdropScaffoldExample(
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowRowExample() {
    Box {
        Column {
            Box {
                FlowRow(
                ) {
                    repeat(10) {
                        Text("Item $it", Modifier.padding(8.dp))
                    }
                }
            }
        }
    }
}



@Composable
fun AlertDialogExample() {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text("Alert Dialog Title") },
            text = { Text("This is a simple alert dialog.") },
            confirmButton = {
                TextButton(onClick = { openDialog.value = false }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { openDialog.value = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun CardExample() {
    Card(
        modifier = Modifier.padding(8.dp),
    ) {
        Text("This is a card", modifier = Modifier.padding(16.dp))
    }
}


@Composable
fun CheckboxExample() {
    val checked = remember { mutableStateOf(false) }

    Checkbox(
        checked = checked.value,
        onCheckedChange = { checked.value = it }
    )
}

@Composable
fun FloatingActionButtonExample() {
    FloatingActionButton(onClick = { /* Handle click */ }) {
        Icon(Icons.Filled.Add, contentDescription = "Add")
    }
}


@Composable
fun IconExample() {
    Icon(Icons.Filled.Home, contentDescription = "Home Icon")
}


@Composable
fun ImageExample() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Example Image"
    )
}

@Composable
fun ProgressBarExample() {
    CircularProgressIndicator()
}


@Composable
fun RadioButtonExample() {
    val selected = remember { mutableStateOf(false) }

    RadioButton(
        selected = selected.value,
        onClick = { selected.value = !selected.value }
    )
}

@Composable
fun SliderExample() {
    val value = remember { mutableStateOf(0f) }

    Slider(
        value = value.value,
        onValueChange = { value.value = it }
    )
}


@Composable
fun SpacerExample() {
    Column {
        Text("Text above spacer")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Text below spacer")
    }
}


@Composable
fun SwitchExample() {
    val checked = remember { mutableStateOf(false) }

    Switch(
        checked = checked.value,
        onCheckedChange = { checked.value = it }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample() {
    TopAppBar(
        title = { Text("Top App Bar") },
        navigationIcon = {
            IconButton(onClick = { /* Handle click */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
            }
        }
    )
}




@Composable
fun DialogExample() {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        Dialog(onDismissRequest = { openDialog.value = false }) {
            Surface(shape = MaterialTheme.shapes.medium) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Dialog Title")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "This is a dialog.")
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = { openDialog.value = false }) {
                        Text("Dismiss")
                    }
                }
            }
        }
    }
}

@Composable
fun DividerExample() {
    Column {
        Text("Text above divider")
        Text("Text below divider")
    }
}


@Composable
fun DropDownMenuExample() {
    Box {

    }
}

@Composable
fun LazyVerticalGridExample() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(100) { index ->
            Text("Item #$index", modifier = Modifier.padding(8.dp))
        }
    }
}


@Composable
fun NavigationRailExample() {
    NavigationRail {
        NavigationRailItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = false,
            onClick = { /* Handle click */ }
        )
        NavigationRailItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorites") },
            label = { Text("Favorites") },
            selected = true,
            onClick = { /* Handle click */ }
        )
    }
}

@Composable
fun OutlinedTextFieldExample() {
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerExample() {
}


@Composable
fun TabRowExample() {
}


