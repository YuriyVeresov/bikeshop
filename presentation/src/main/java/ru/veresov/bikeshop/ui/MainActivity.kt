package ru.veresov.bikeshop.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import ru.veresov.bikeshop.ui.screen.CatalogScreen
import ru.veresov.bikeshop.ui.theme.BikeShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            BikeShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BikeShopTheme.colorScheme.backgroundColor
                ) {

                    val gradient = BikeShopTheme.colorScheme.secondaryBackgroundGradientColors

                    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
                        val path = Path().apply {
                            moveTo(0f, size.height)
                            lineTo(size.width * 0.8f, size.height * 0.1f)
                            lineTo(size.width, size.height * 0.2f)
                            lineTo(size.width, size.height)
                            close()
                        }

                        drawPath(
                            path,
                            brush = Brush.linearGradient(colors = gradient),
                            alpha = .9f
                        )
                    })

                    CatalogScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp),
                    )
                }
            }
        }
    }
}