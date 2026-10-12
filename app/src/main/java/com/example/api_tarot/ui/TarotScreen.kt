package com.example.api_tarot.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Brightness3
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Color Palette Mística
val GoldPrimary = Color(0xFFE5C158)
val GoldAccent = Color(0xFFF7E7AD)
val DarkBackgroundStart = Color(0xFF0F0B1E)
val DarkBackgroundEnd = Color(0xFF1A1233)
val CardSurfaceColor = Color(0xFF231942)
val CardBorderGold = Color(0xFFD4AF37)
val TextGold = Color(0xFFF3E5AB)
val TextSecondary = Color(0xFFB3A8D1)

// Modelo UI de datos de ejemplo (sin lógica de negocio)
data class TarotCardUiModel(
    val id: Int,
    val name: String,
    val number: String,
    val positionLabel: String,
    val element: String,
    val description: String,
    val icon: ImageVector
)

// Lista de 5 cartas de Tarot para la tirada
val mockFiveTarotCards = listOf(
    TarotCardUiModel(
        id = 1,
        name = "El Mago",
        number = "I",
        positionLabel = "1. Pasado",
        element = "Aire",
        description = "Simboliza manifestación, habilidad y el potencial latente para iniciar nuevos proyectos.",
        icon = Icons.Default.AutoAwesome
    ),
    TarotCardUiModel(
        id = 2,
        name = "La Sacerdotisa",
        number = "II",
        positionLabel = "2. Presente",
        element = "Agua",
        description = "Representa la intuición, los misterios del inconsciente y la necesidad de escuchar tu voz interior.",
        icon = Icons.Default.Brightness3
    ),
    TarotCardUiModel(
        id = 3,
        name = "La Estrella",
        number = "XVII",
        positionLabel = "3. Futuro",
        element = "Aire",
        description = "Trae esperanza, inspiración divina, renovación espiritual y claridad sobre el camino a seguir.",
        icon = Icons.Default.Star
    ),
    TarotCardUiModel(
        id = 4,
        name = "La Fuerza",
        number = "VIII",
        positionLabel = "4. Desafío",
        element = "Fuego",
        description = "Exige compasión, paciencia y dominio propio para superar los obstáculos con serenidad.",
        icon = Icons.Default.Psychology
    ),
    TarotCardUiModel(
        id = 5,
        name = "El Mundo",
        number = "XXI",
        positionLabel = "5. Resultado",
        element = "Tierra",
        description = "Anuncia la culminación exitosa, el equilibrio total y la realización personal de un gran ciclo.",
        icon = Icons.Default.Explore
    )
)

@Composable
fun TarotScreen(
    cards: List<TarotCardUiModel> = mockFiveTarotCards,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        DarkBackgroundStart,
                        DarkBackgroundEnd,
                        Color(0xFF0D0817)
                    )
                )
            )
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            // Encabezado
            item {
                TarotHeaderSection()
            }

            // Carrusel horizontal de las 5 cartas
            item {
                Text(
                    text = "Tirada de 5 Cartas",
                    color = TextGold,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)
                )

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    items(cards) { card ->
                        TarotCardItem(card = card)
                    }
                }
            }

            // Separador con título de interpretación
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.WbSunny,
                        contentDescription = null,
                        tint = GoldPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Significado de la Tirada",
                        color = TextGold,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
            }

            // Lista detallada de la interpretación de cada una de las 5 cartas
            items(cards) { card ->
                TarotCardDetailItem(
                    card = card,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 6.dp)
                )
            }

            // Botones de Acción (Solo UI)
            item {
                Spacer(modifier = Modifier.height(24.dp))
                TarotActionButtonsSection(
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
        }
    }
}

@Composable
fun TarotHeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, start = 20.dp, end = 20.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.AutoAwesome,
                contentDescription = null,
                tint = GoldPrimary,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "ORÁCULO Y TAROT",
                color = GoldPrimary,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 2.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.AutoAwesome,
                contentDescription = null,
                tint = GoldPrimary,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Lectura del Destino",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Explora el pasado, presente, futuro, desafío y resultado de tu consulta.",
            color = TextSecondary,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun TarotCardItem(
    card: TarotCardUiModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(160.dp)
            .height(260.dp)
            .border(
                width = 1.5.dp,
                brush = Brush.linearGradient(
                    colors = listOf(CardBorderGold, GoldAccent, CardBorderGold)
                ),
                shape = RoundedCornerShape(16.dp)
            ),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardSurfaceColor
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            // Marco interior decorativo
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        width = 1.dp,
                        color = GoldPrimary.copy(alpha = 0.4f),
                        shape = RoundedCornerShape(10.dp)
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Etiqueta de posición (e.g. 1. Pasado)
                Surface(
                    color = GoldPrimary.copy(alpha = 0.2f),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, GoldPrimary.copy(alpha = 0.5f))
                ) {
                    Text(
                        text = card.positionLabel,
                        color = GoldAccent,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                }

                // Número Romano
                Text(
                    text = card.number,
                    color = GoldPrimary,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )

                // Ilustración Mística / Icono central
                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                        .background(
                            brush = Brush.radialGradient(
                                colors = listOf(
                                    GoldPrimary.copy(alpha = 0.25f),
                                    Color.Transparent
                                )
                            )
                        )
                        .border(1.dp, GoldPrimary.copy(alpha = 0.6f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = card.icon,
                        contentDescription = card.name,
                        tint = GoldAccent,
                        modifier = Modifier.size(36.dp)
                    )
                }

                // Nombre de la carta
                Text(
                    text = card.name,
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center
                )

                // Elemento
                Text(
                    text = "Elemento: ${card.element}",
                    color = TextSecondary,
                    fontSize = 10.sp
                )
            }
        }
    }
}

@Composable
fun TarotCardDetailItem(
    card: TarotCardUiModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardSurfaceColor.copy(alpha = 0.7f)
        ),
        border = BorderStroke(
            width = 1.dp,
            color = CardBorderGold.copy(alpha = 0.3f)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icono / Círculo de la carta
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(GoldPrimary.copy(alpha = 0.15f))
                    .border(1.dp, GoldPrimary.copy(alpha = 0.5f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = card.icon,
                    contentDescription = null,
                    tint = GoldPrimary,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = card.name,
                        color = GoldAccent,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif
                    )

                    Text(
                        text = card.positionLabel,
                        color = TextSecondary,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = card.description,
                    color = Color.White.copy(alpha = 0.85f),
                    fontSize = 13.sp,
                    lineHeight = 18.sp
                )
            }
        }
    }
}

@Composable
fun TarotActionButtonsSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(
            onClick = { /* Solo UI */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = GoldPrimary,
                contentColor = Color(0xFF100B1E)
            ),
            shape = RoundedCornerShape(25.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Nueva Tirada (5 Cartas)",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        OutlinedButton(
            onClick = { /* Solo UI */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            border = BorderStroke(1.dp, GoldPrimary),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = GoldAccent
            ),
            shape = RoundedCornerShape(25.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Bookmark,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Guardar Lectura en Favoritos",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 844)
@Composable
fun TarotScreenPreview() {
    TarotScreen()
}
