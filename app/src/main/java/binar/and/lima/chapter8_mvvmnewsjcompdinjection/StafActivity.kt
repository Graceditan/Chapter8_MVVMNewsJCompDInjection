package binar.and.lima.chapter8_mvvmnewsjcompdinjection

import StafViewModel
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.data.ResponseNewsItem
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.data.ResponseStafItem
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.ui.theme.Chapter8_MVVMNewsJCompDInjectionTheme
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.viewmodel.NewsViewModel
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint


class StafActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Chapter8_MVVMNewsJCompDInjectionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val staffViewModel = viewModel(modelClass = StafViewModel::class.java)
                    val datastaf by staffViewModel.dataState.collectAsState()

                    LazyColumn{
                        if (datastaf.isEmpty()){
                            item {

                            }

                        }

                        items(datastaf){
                            Greeting3(staf = it)

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting3 (staf: ResponseStafItem) {

    val mContext = LocalContext.current

    Column(modifier = Modifier.padding(15.dp)) {
        Card(modifier = Modifier
            .clickable {
                val intent = Intent(mContext, DetailStaf::class.java)
                intent.putExtra("detailstaf", staf)
                mContext.startActivity(intent)
            }
            .padding(15.dp)
            .fillMaxWidth()) {


            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                Image(painter = rememberImagePainter(data = staf.image), contentDescription = null,
                    modifier = Modifier.height(50.dp) .width(50.dp))


                Column() {
                    Text(
                        text = "${staf.name}",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 5.dp))

                    Text(
                        text = "${staf.createdAt}",
                        color = Color.Blue,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 5.dp))

                    Text(
                        text = "${staf.email}",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 5.dp))
                }
            }

        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Chapter8_MVVMNewsJCompDInjectionTheme {
       // Greeting3("Android")
    }
}