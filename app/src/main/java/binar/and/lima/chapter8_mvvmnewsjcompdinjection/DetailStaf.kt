package binar.and.lima.chapter8_mvvmnewsjcompdinjection

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.data.ResponseNewsItem
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.data.ResponseStafItem
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.ui.theme.Chapter8_MVVMNewsJCompDInjectionTheme
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint



class DetailStaf : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Chapter8_MVVMNewsJCompDInjectionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val detail = intent.getParcelableExtra<ResponseStafItem>("detailstaf") as ResponseStafItem
                    Column() {


                    }
                    Row(modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()) {
                        Image(painter = rememberImagePainter(data = detail.image), contentDescription  = null)

                    }
                    val mContext = LocalContext.current
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(text = detail.name)
                        Text(text = detail.createdAt)
                        Text(text = detail.email)
                        Text(text = detail.description)


                    }

                }
            }
        }
    }
}

@Composable
fun Greeting4(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    Chapter8_MVVMNewsJCompDInjectionTheme {
        Greeting4("Android")
    }
}