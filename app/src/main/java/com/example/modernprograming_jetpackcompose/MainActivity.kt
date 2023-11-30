package com.example.modernprograming_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen(viewModel: MainViewModel = viewModel()) {
    val text3: State<String> = viewModel.liveData.observeAsState("")

    Column {
        Text(text = text3.value)
        TextField(value = text3.value, onValueChange = { viewModel.changeValue(it) })
//        Button(onClick = {
//            viewModel.changeValue(text3.value)
//        }) {
//            Text(text = "클릭")
//        }
    }
}

class MainViewModel : ViewModel() {
    private val _value = mutableStateOf("Hello World")
    val value: State<String> = _value

    // LiveData 사용하기
    private val _liveData = MutableLiveData<String>()
    val liveData: LiveData<String> get() = _liveData

    fun changeValue(value: String) {
        _liveData.value = value
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}
