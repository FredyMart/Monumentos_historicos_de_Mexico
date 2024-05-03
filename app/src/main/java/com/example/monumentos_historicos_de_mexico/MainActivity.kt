// Definición del paquete para la aplicación; se utiliza para identificar de manera única su app en el sistema y organizar los archivos.
package com.example.monumentos_historicos_de_mexico

// Importaciones de las clases y funciones necesarias de Android SDK y Jetpack Compose para la aplicación.
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.monumentos_historicos_de_mexico.data.Datasource
import com.example.monumentos_historicos_de_mexico.model.Monumentos
import com.example.monumentos_historicos_de_mexico.ui.theme.Monumentos_historicos_de_MexicoTheme

// MainActivity es el punto de entrada de la aplicación. Hereda de ComponentActivity que está optimizada para UIs de Compose.
class MainActivity : ComponentActivity() {
    // onCreate se llama cuando la actividad está empezando. Aquí se configura la UI de nuestra aplicación.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el contenido de la actividad utilizando Jetpack Compose.
        setContent {
            // Tema Material personalizado para la aplicación, definido en el paquete ui.theme.
            Monumentos_historicos_de_MexicoTheme {
                // Surface es un contenedor de diseño de Compose que utiliza el color de fondo del tema.
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MonumentosApp()
                }
            }
        }
    }
}

// Una función composable que configura el contenido principal de la aplicación.
@Composable
fun MonumentosApp() {
    // Recupera una lista de monumentos y los pasa a MonumentosList para su visualización.
    MonumentosList(
        monumentosList = Datasource().cargaMonumentos(),
    )
}

// Función composable que muestra una lista de monumentos usando LazyColumn, que es eficiente para listas de elementos.
@Composable
fun MonumentosList(monumentosList: List<Monumentos>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(monumentosList) { monumentos ->
            MonumentoCard(
                monumentos = monumentos,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

// Función composable que define cómo se debe mostrar cada monumento individual dentro de un diseño de tarjeta.
@Composable
fun MonumentoCard(monumentos: Monumentos, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(monumentos.imageResourceId),
                contentDescription = stringResource(monumentos.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(335.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(monumentos.stringResourceId),
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

// La anotación Preview permite previsualizar este componente composable en la herramienta de diseño de Android Studio.
@Preview(showBackground = true)
@Composable
private fun MonumentoCardPreview() {
    MonumentoCard(Monumentos(R.string.monumento1, R.drawable.angel_independencia))
}
