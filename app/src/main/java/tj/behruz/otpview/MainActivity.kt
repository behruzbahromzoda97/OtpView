package tj.behruz.otpview

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tj.behruz.otpview.ui.theme.OtpViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OtpViewTheme {
                var isNextBtnStatus by remember {
                    mutableStateOf(false)
                }
                var smsCodeNumber by remember {
                    mutableStateOf("")
                }
                // A surface container using the 'background' color from the theme
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 40.dp),
                        text = "Otp was send",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.primary
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp)
                    ) {
                        SmsCodeView(
                            smsCodeLength = 4,
                            textFieldColors = TextFieldDefaults.textFieldColors(),
                            textStyle = MaterialTheme.typography.h6,
                            smsFulled = {
                                smsCodeNumber = it
                                isNextBtnStatus = it.length == 4
                            }
                        )
                    }

                    Text(
                        text = smsCodeNumber,
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.Center
                    )

                    if (isNextBtnStatus) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp)
                        ) {
                            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth().height(50.dp)) {
                                Text(text = "Next", style = MaterialTheme.typography.button)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OtpViewTheme {
        Greeting("Android")
    }
}