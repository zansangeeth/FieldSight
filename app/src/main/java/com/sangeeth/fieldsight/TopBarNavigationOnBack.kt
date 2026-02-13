package com.sangeeth.fieldsight

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.w3c.dom.Text

//class TopBarNavigationOnBack {
//}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBarNavigationOnBack(
    navigationBack: () -> Unit,
    topBarTitle: String
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(topBarTitle)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = navigationBack ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Go Back"
                        )
                    }
                }
            )
        },
        content = { innerPadding->
            Text("Investigation Detail", modifier = Modifier.padding(innerPadding))
        }
    )
}
