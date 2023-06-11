package com.example.moviesapp.presentation.ui.screen.main

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.moviesapp.R
import com.example.moviesapp.domain.models.Movie
import com.example.moviesapp.presentation.utils.URLConstants.MOVIE_BASE_IMAGE_URL
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieItem(item: Movie) {
    val context = LocalContext.current
    Card(
        onClick = {
            Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
        },
        colors = CardDefaults.cardColors(Color.Gray),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Center
        ) {

            Row(
                verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Image(
                    modifier = Modifier
                        .height(170.dp)
                        .width(110.dp),
                    painter = rememberAsyncImagePainter(
                        MOVIE_BASE_IMAGE_URL + item.posterPath
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier.padding(
                            start = 5.dp, top = 10.dp, end = 5.dp, bottom = 0.dp
                        ),
                        text = item.title.uppercase(Locale.getDefault()),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        maxLines = 2,
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Spacer(modifier = Modifier.padding(top = 5.dp))

                    Row(
                        modifier = Modifier.padding(
                            start = 5.dp, top = 5.dp, end = 5.dp, bottom = 0.dp
                        ), horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = stringResource(id = R.string.text_release_date),
                            textAlign = TextAlign.Start,
                            fontSize = 16.sp,
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text = item.releaseDate,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 16.sp,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                    Row(
                        modifier = Modifier.padding(
                            start = 5.dp, top = 8.dp, end = 5.dp, bottom = 0.dp
                        ), horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = stringResource(id = R.string.text_popularity),
                            textAlign = TextAlign.Start,
                            fontSize = 16.sp,
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text = "%.2f".format(item.popularity),
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 16.sp,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                    Row(
                        modifier = Modifier.padding(
                            start = 5.dp, top = 8.dp, end = 5.dp, bottom = 10.dp
                        ), horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = stringResource(id = R.string.text_rating),
                            textAlign = TextAlign.Start,
                            fontSize = 16.sp,
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text = item.voteAverage.toString(),
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontSize = 16.sp,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

        }

    }
}