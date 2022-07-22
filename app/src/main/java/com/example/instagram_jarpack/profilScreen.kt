package com.example.instagram_jarpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram_jarpack.ui.theme.Instagram_JarpackTheme

@Composable
fun ProfilScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Topbar(name = "ahmetykn52", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
    }
}
@Composable
fun Topbar(
    name:String,
    modifier: Modifier =Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(imageVector = Icons.Default.ArrowBack ,
            contentDescription = "back",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(painter = painterResource(id = R.drawable.bell) ,
            contentDescription = "back",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.dots),
            contentDescription = "back",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )

    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(image = painterResource(id = R.drawable.cat), modifier = Modifier
                .size(100.dp)
                .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
        ProfileDescription(
            displayName = "Ahmet Aykun",
            common_friends = "Common Friends",
            descriptor ="working on Jetpack Compose\n" +
                    " trying to help everyone about Kotlin" ,
            otherCount = 18,


            HyperlinkText = HyperlinkText(fullText = "Bu gün nasılsın benim github sayfamı ziyaret etmek istermisin ",
                linkText = listOf("benim","github")),
            followedBy = listOf("coddingflow","caner "),



        )
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier =Modifier
){
   Image(
       painter = image,
       contentDescription = null,
       modifier = modifier
           .aspectRatio(1f, matchHeightConstraintsFirst = true)
           .border(
               width = 1.dp,
               color = Color.LightGray,
               shape = CircleShape
           )
           .padding(3.dp)
           .clip(CircleShape)

   )
}

@Composable
fun StatSection(modifier: Modifier = Modifier)
{
    Row(
       verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfilStat(numberText = "201", text = "Posts")
        ProfilStat(numberText = "995k", text = "Followers")
        ProfilStat(numberText = "10", text = "Following")
    }
}

@Composable
fun ProfilStat(
    numberText: String,
    text:String,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
           fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text,)
    }
}
@Composable
fun ProfileDescription(
    displayName: String,
    common_friends:String,
    descriptor: String,
    HyperlinkText: Unit = HyperlinkText(
        fullText = "Bu gün nasılsın benim github sayfamı ziyaret etmek istermisin ziyaret",
        linkText = listOf("benim","github")),

   // followedBy1: Unit,
    followedBy: List<String>,
    otherCount: Int
){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = descriptor,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = common_friends,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )


        if (followedBy.isNotEmpty()){
            Text(
                text = buildAnnotatedString {
                val boldStyle = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1 ){

                            append(", ")
                        }
                    }
                    if (otherCount > 2){
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
            },
                letterSpacing = letterSpacing,
                lineHeight=lineHeight
            )

        }

    }
}

@Composable
fun HyperlinkText(
    modifier: Modifier = Modifier,
    fullText: String,
    linkText: List<String>,
    linkTextColor: Color = Color.Blue,
    linkTextFontWeight: FontWeight = FontWeight.Medium,
    linkTextDecoration: TextDecoration = TextDecoration.Underline,
    hyperlinks: List<String> = listOf("https://github.com/Tosam0", "https://www.google.com.tr/"),
    fontSize: TextUnit = TextUnit.Unspecified,
    ) {
    val annotatedString = buildAnnotatedString {
        append(fullText)
        linkText.forEachIndexed { index, link ->
            val startIndex = fullText.indexOf(link)
            val endIndex = startIndex + link.length
            addStyle(
                style = SpanStyle(
                    color = linkTextColor,
                    fontSize = fontSize,
                    fontWeight = linkTextFontWeight,
                    textDecoration = linkTextDecoration,
                    ),
                start = startIndex,
                end = endIndex
            )
           addStringAnnotation(
              tag = "URL",
                annotation = hyperlinks[index],
                start = startIndex,
                end = endIndex
            )
        }
        addStyle(
            style = SpanStyle(
                fontSize = fontSize
            ),
            start = 0,
            end = fullText.length
        )
    }
    val uriHandler = LocalUriHandler.current

    ClickableText(

        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        text = annotatedString,
        onClick = {
            annotatedString
                .getStringAnnotations("URL", it, it)
                .firstOrNull()?.let { stringAnnotation ->
                    uriHandler.openUri(stringAnnotation.item)
                }
        }
    )
}
@Composable
fun ButtonSection(
    modifier: Modifier=Modifier
){
    val minWidth=95.dp
    val height=30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly
        , modifier = modifier
    )
    {
        ActionButton(
            text = "Fallowing",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(

            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .height(height)
        )
    }
}
@Composable
fun ActionButton(
    modifier: Modifier=Modifier,
    text: String?=null,
    icon: ImageVector? = null
) {
    Row (horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically,
    modifier = modifier
        .border(
            width = 1.dp,
            color = Color.LightGray,
            shape = RoundedCornerShape(5.dp)
        )
        .padding(6.dp)
    )

    {
       if (text != null){
           Text(text = text,
           fontWeight = FontWeight.SemiBold,
           fontSize = 14.sp
           )
       }
        if (icon != null){
           Icon(
               imageVector =icon,
               contentDescription = null,
               tint = Color.Black
           )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ProfilScreen2() {
    Instagram_JarpackTheme {
        ProfilScreen()

     HyperlinkText(
            fullText = "",
            linkText = listOf("benim","github"),
            hyperlinks = listOf("https://github.com/Tosam0","https://www.google.com.tr/"),
            fontSize = MaterialTheme.typography.bodyMedium.fontSize
        )

    }
}



































































