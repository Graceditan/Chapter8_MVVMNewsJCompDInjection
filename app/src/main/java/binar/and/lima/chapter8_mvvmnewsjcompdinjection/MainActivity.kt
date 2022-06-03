package binar.and.lima.chapter8_mvvmnewsjcompdinjection

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.data.ResponseNewsItem
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.ui.theme.Chapter8_MVVMNewsJCompDInjectionTheme
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.viewmodel.NewsViewModel
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Chapter8_MVVMNewsJCompDInjectionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val newsViewModel = viewModel(modelClass = NewsViewModel::class.java)
                    val datanews by newsViewModel.dataState.collectAsState()

                    LazyColumn{
                        if (datanews.isEmpty()){
                            item {

                            }

                        }

                        items(datanews){
                            Greeting(news = it)

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(news:ResponseNewsItem) {
//    val mcontext = LocalContext.current
//
//    Column(modifier = Modifier
//        .clickable {
//            val pindah = Intent(mcontext, DetailNews::class.java)
//            pindah.putExtra("detailnews", news)
//            mcontext.startActivity(pindah)
//        }
//        .padding(start = 15.dp, end = 15.dp, bottom = 3.dp, top = 3.dp)) {
//        Card(shape = RoundedCornerShape(10.dp),
//            backgroundColor = Color.White,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(80.dp)) {
//
//            Row(modifier = Modifier
//                .fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically) {
//
//                Image(painter = rememberImagePainter(data = news.image),
//                    contentDescription = "iconfilm",
//                    modifier = Modifier
//                        .width(130.dp)
//                        .height(70.dp)
//                        .padding(end = 10.dp))
//
//                Column() {
//                    Text(
//                        text = "Judul : ${news.title}",
//                        color = Color.Black,
//                        fontSize = 15.sp,
//                        fontWeight = FontWeight.Normal,
//                        modifier = Modifier.padding(start = 5.dp))
//
//                    Text(
//                        text = "Rilis : ${news.createdAt}",
//                        color = Color.Magenta,
//                        fontSize = 10.sp,
//                        fontWeight = FontWeight.Normal,
//                        modifier = Modifier.padding(start = 5.dp))
//
//                    Text(
//                        text = "Author : ${news.author}",
//                        color = Color.Black,
//                        fontSize = 15.sp,
//                        fontWeight = FontWeight.Normal,
//                        modifier = Modifier.padding(start = 5.dp))
//                }
//            }
//        }
//    }
//
//}
    val mContext = LocalContext.current

    Column(modifier = Modifier.padding(15.dp)) {
        Card(modifier = Modifier
            .clickable {
                val intent = Intent(mContext, DetailNews::class.java)
                intent.putExtra("detail", news)
                mContext.startActivity(intent)
            }
            .padding(15.dp)
            .fillMaxWidth()) {


            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                Image(painter = rememberImagePainter(data = news.image), contentDescription = null,
                modifier = Modifier.height(50.dp) .width(50.dp))
//                Image(painter = rememberImagePainter(data = news.image),
//                    contentDescription = film,)
//

                Column() {
                    Text(
                        text = "${news.title}",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 5.dp))

                    Text(
                        text = "${news.createdAt}",
                        color = Color.Blue,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 5.dp))

                    Text(
                        text = "${news.author}",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 5.dp))
                }
            }
//            Row() {
//                Image(painter = rememberImagePainter(data = news.image), contentDescription  = null,
//                modifier = Modifier.height(50.dp)
//                    .padding(10.dp))
//
//                Column(modifier = Modifier.padding(start = 15.dp)
//                    ) {
//                    Text(text = news.title)
//                    Text(text = news.author)
//                    Text(text = news.createdAt)
//
//                }
//            }

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Chapter8_MVVMNewsJCompDInjectionTheme {
//        Greeting("", "", "", "", "", "")
    }
}