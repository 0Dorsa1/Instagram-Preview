package com.example.instagrampage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun PreviewPage() {
    Surface {
        InstagramPage()
    }
}

@Composable
fun InstagramPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
    ) {
        ProfileSection()

        Highlights()

        TopBar()

        Posts(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.Start)
        ) {
            BottomBar()
        }
    }
}

@Composable
fun Posts(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        val imageResId = R.drawable.feed_sample_image

        LazyVerticalGrid(columns = GridCells.Adaptive(100.dp), content = {
            items(30) {
                PostRow(images = List(3) { imageResId })
            }
        })
    }
}

@Composable
fun PostRow(images: List<Int>) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (imageResId in images) {
            SquareShape(imageResId = imageResId,
                modifier = Modifier
                    .size(120.dp)
                    .padding(4.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .clickable { })
        }
    }
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
    ) {

        Row {
            CircleShape(imageResId = R.drawable.profile_sample_image,
                modifier = Modifier
                    .size(80.dp)
                    .clip(shape = RoundedCornerShape(500.dp))
                    .clickable { })

            Spacer(modifier = Modifier.width(20.dp))

            Column {
                Row {
                    BoldText(
                        text = "30",
                        fontSize = 16,
                        modifier = Modifier.padding(start = 10.dp, top = 15.dp)
                    )
                    Spacer(modifier = Modifier.width(60.dp))
                    BoldText(text = "12K", fontSize = 16, modifier = Modifier.padding(top = 15.dp))
                    Spacer(modifier = Modifier.width(70.dp))
                    BoldText(text = "8", fontSize = 16, modifier = Modifier.padding(top = 15.dp))

                }
                Row {
                    DefaultText(
                        text = "Posts", fontSize = 16, modifier = Modifier.padding(top = 10.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    DefaultText(
                        text = "Followers",
                        fontSize = 16,
                        modifier = Modifier.padding(top = 10.dp, start = 5.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    DefaultText(
                        text = "Following",
                        fontSize = 16,
                        modifier = Modifier.padding(top = 10.dp, start = 5.dp)
                    )

                }

            }

        }


        Column {
            BoldText(text = "Username", fontSize = 18, modifier = Modifier)
            DefaultText(
                text = "Bio: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed commodo ante quis ultrices bibendum.",
                fontSize = 14,
                modifier = Modifier
            )
            LinkText(text = "https://google.com", fontSize = 16, modifier = modifier)
        }
    }
}

@Composable
fun SquareShape(modifier: Modifier = Modifier, imageResId: Int) {
    Image(
        painter = painterResource(id = imageResId), contentDescription = null, modifier = modifier
    )
}

@Composable
fun CircleShape(imageResId: Int, modifier: Modifier) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = "Profile Pic",
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Composable
fun BoldText(text: String, fontSize: Int, modifier: Modifier) {
    androidx.compose.material.Text(
        text = text,
        color = Color.Black,
        style = androidx.compose.ui.text.TextStyle(fontSize = fontSize.sp),
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun DefaultText(text: String, fontSize: Int, modifier: Modifier) {
    androidx.compose.material.Text(
        text = text,
        color = Color.Black,
        style = androidx.compose.ui.text.TextStyle(fontSize = fontSize.sp),
        modifier = modifier
    )
}

@Composable
fun LinkText(text: String, fontSize: Int, modifier: Modifier) {
    androidx.compose.material.Text(
        text = text,
        color = Color.Blue,
        style = androidx.compose.ui.text.TextStyle(fontSize = fontSize.sp),
        modifier = modifier.clickable { },
    )
}


@Composable
fun TopBar() {
    Surface(modifier = Modifier.fillMaxWidth()) {
        Row {
            Image(painter = painterResource(id = R.drawable.arrow_button),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 40.dp)
                    .size(40.dp)

                    .clickable { })
            Image(painter = painterResource(id = R.drawable.home_button),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 100.dp, top = 3.dp)
                    .size(35.dp)

                    .clickable { })
            Image(painter = painterResource(id = R.drawable.profile_icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 100.dp, top = 5.dp)
                    .size(35.dp)

                    .clickable { })
        }
    }
}

@Composable
fun BottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.LightGray)
    ) {
        Image(painter = painterResource(id = R.drawable.search_button),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 45.dp, top = 5.dp)
                .size(40.dp)
                .clickable { })
        Image(painter = painterResource(id = R.drawable.plus_icon),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 90.dp, top = 5.dp)
                .size(40.dp)
                .clickable { })
        Image(painter = painterResource(id = R.drawable.home_button),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 100.dp, top = 5.dp)
                .size(35.dp)
                .clickable { })

    }
}

@Composable
fun Highlights() {
    Column {
        Row {
            CircleShape(imageResId = R.drawable.highlights_sample,
                modifier = Modifier
                    .padding(start = 30.dp)
                    .size(70.dp)
                    .clip(shape = RoundedCornerShape(500.dp))
                    .clickable { })
            CircleShape(imageResId = R.drawable.highlights_sample,
                modifier = Modifier
                    .padding(start = 30.dp)
                    .size(70.dp)
                    .clip(shape = RoundedCornerShape(500.dp))
                    .clickable { })

        }
        Row {
            DefaultText(text = "h1", fontSize = 16, modifier = Modifier.padding(start = 60.dp))
            DefaultText(text = "h2", fontSize = 16, modifier = Modifier.padding(start = 85.dp))

        }
    }

}