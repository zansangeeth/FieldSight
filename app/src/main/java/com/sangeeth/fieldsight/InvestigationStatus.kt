package com.sangeeth.fieldsight

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup

@Composable
fun InvestigationStatusDropdown(
    itemList: List<String>,
    modifier: Modifier = Modifier,
    initialSelectedIndex: Int = 0,
    onItemClick: (Int) -> Unit = {}
) {
    var showDropdown by rememberSaveable { mutableStateOf(false) }
    var selectedIndex by rememberSaveable { mutableStateOf(initialSelectedIndex) }
    val scrollState = rememberScrollState()
    val density = LocalDensity.current

    var boxWidthDp by remember { mutableStateOf(0.dp) }
    var boxHeightDp by remember { mutableStateOf(0.dp) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (showDropdown) {
            var dropdownHeight by remember { mutableStateOf(0) }

            Popup(
                alignment = Alignment.TopCenter,
                offset = IntOffset(0, -dropdownHeight),
                onDismissRequest = { showDropdown = false },
            ) {
                Box(modifier = Modifier.width(boxWidthDp)) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned {
                                dropdownHeight = it.size.height
                            }
                            .background(Color.White, shape = RoundedCornerShape(5.dp))
                            .heightIn(max = 90.dp)
                            .verticalScroll(scrollState)
                            .border(1.dp, Color.Gray)
                    ) {
                        itemList.forEachIndexed { index, item ->
                            if (index != 0) HorizontalDivider()
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        selectedIndex = index
                                        showDropdown = false
                                        onItemClick(index)
                                    }
                                    .padding(8.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = item)
                            }
                        }
                    }
                }
            }
        }

        Box(
            modifier = modifier
                .onGloballyPositioned {
                    boxWidthDp = with(density) { it.size.width.toDp() }
                    boxHeightDp = with(density) { it.size.height.toDp() }
                }
                .background(Color.LightGray, shape = RoundedCornerShape(5.dp))
                .clickable { showDropdown = true }
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = itemList[selectedIndex],
                modifier = Modifier.padding(3.dp)
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun previewInvestigationStatus() {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        InvestigationStatusDropdown(
//            itemList = listOf("Open", "In Progress", "Completed", "Closed"),
//            modifier = Modifier.width(200.dp)
//        )
//    }
//}