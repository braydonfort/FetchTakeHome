package com.example.fetchtakehome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.data.Item

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = hiltViewModel()){
    val itemList by viewModel._itemList.collectAsState()
    viewModel.getList()
    val sortedItems = remember(itemList) {
        itemList
            .filter { it.name?.isNotBlank() ?: false }
            .groupBy { it.listId }
            .toList()
            .sortedBy { it.first }
            .flatMap { (_, items) ->
                items.sortedBy { it.name }
            }
    }
    HomeScreenContent(sortedItems)

}

@Composable
fun HomeScreenContent(itemList: List<Item>){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Item List",
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp, bottom = 20.dp)
        )
        LazyColumn {
            items(items = itemList) { item ->
                ItemCard(item = item)
            }
        }

    }
}

@Composable
fun ItemCard(item: Item){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            item.name?.let { Text(text = "Name: $it") }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Id: ${item.id.toString()}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "ListId: ${item.listId.toString()}")
        }
}