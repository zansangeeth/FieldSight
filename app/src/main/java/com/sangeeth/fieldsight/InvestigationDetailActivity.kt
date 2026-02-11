package com.sangeeth.fieldsight

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.sangeeth.fieldsight.ui.theme.FieldSightTheme

class InvestigationDetailActivity : AppCompatActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            FieldSightTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                    Text("Field Sight")
                                }
                            },
                            navigationIcon = {
                                IconButton(onClick = { navController.popBackStack() }){
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
        }
    }

}

