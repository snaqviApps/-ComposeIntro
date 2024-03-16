package edu.coding.randomuserApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import edu.coding.randomuserApp.ui.theme.RandomuserAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    private val randomuserViewModel : RandomuserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomuserAppTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
////                    Text(text = "Hi Compose")
//                }

                ShowUi()
            }
        }
    }

    @Preview
    @Composable
    fun ShowUi() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
                .padding(8.dp)
                .clip(RoundedCornerShape(18.dp))
                .background(MaterialTheme.colorScheme.primaryContainer),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically

        ) {

            /**
             * The Text has a 'state' of visibility, that needs a state-holder
             * if that needs to be changed.
             * That is provided by using 'mutableListOf()',
             * It will make the 'Composable' it attaches to, and when state changes
             * the Composable component-associated will be re-drawn.
             * Note: we need to pass this as a lambda-input,  to a remember block, that will remember
             * the 'initial-state'
             */

            val textVisibilityState = remember {
                mutableStateOf(true)
            }

            Text(
                modifier = Modifier.alpha(
                    if(textVisibilityState.value) 0.8f else 0.3f
                ),
                text = "Visible"
            )

            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {
                          textVisibilityState.value = !textVisibilityState.value        // toggle visibility
                },
                modifier = Modifier
                    .padding(4.dp)
            ){
                Text(text  = "Change Text Visibility")
            }
        }
    }
}

