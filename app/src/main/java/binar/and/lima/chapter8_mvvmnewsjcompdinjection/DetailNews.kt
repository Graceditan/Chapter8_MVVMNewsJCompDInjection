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
import binar.and.lima.chapter8_mvvmnewsjcompdinjection.ui.theme.Chapter8_MVVMNewsJCompDInjectionTheme
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint



class DetailNews : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Chapter8_MVVMNewsJCompDInjectionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val detail = intent.getParcelableExtra<ResponseNewsItem>("detail") as ResponseNewsItem
                    Column() {


                    }
                    Row(modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()) {
                        Image(painter = rememberImagePainter(data = detail.image), contentDescription  = null)

                    }
                    val mContext = LocalContext.current
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(text = detail.title)
                        Text(text = detail.createdAt)
                        Text(text = detail.author)
                        Text(text = detail.description)

                        Button(onClick = { mContext.startActivity(Intent(mContext,StafActivity::class.java))})
                        {
                            Text(text = "Login")

                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Chapter8_MVVMNewsJCompDInjectionTheme {
        Greeting2("Android")
    }
}