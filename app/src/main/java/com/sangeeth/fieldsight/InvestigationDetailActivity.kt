package com.sangeeth.fieldsight

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sangeeth.fieldsight.ui.theme.FieldSightTheme

class InvestigationDetailActivity : AppCompatActivity() {
 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            FieldSightTheme {
                NavHost(navController, startDestination = "investigation_detail"){
                    composable("investigation_detail") {
                        TopBarNavigationOnBack(
                            navigationBack = { finish() },
                            topBarTitle = "Investigation Detail",
                            content = { innerPadding ->
                                val investigation = intent.getStringExtra("investigation")
                                Text("Investigation Detail Screen new, $investigation", modifier = Modifier.padding(innerPadding))
                            }
                        )
                    }
                }
            }
        }
    }
}