package com.brine.comps.text

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brine.comps.foundation.neoContainer
import com.brine.comps.theme.NeoTheme

@Composable
fun NeoText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = NeoTheme.colors.textPrimary,
    fontSize: Int = 16,
    fontWeight: FontWeight = FontWeight.Normal,
    style: TextStyle = TextStyle.Default
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        style = style
    )
}

/**
  Neo-Brutalist Highlight Title Banner as seen in Droplert designs.
  Renders normal text followed by highlighted text in a vibrant red rounded box.
 */
@Composable
fun NeoHighlightTitle(
    normalText: String,
    highlightText: String,
    modifier: Modifier = Modifier,
    highlightColor: Color = NeoTheme.colors.red,
    highlightTextColor: Color = NeoTheme.colors.textOnRed
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (normalText.isNotEmpty()) {
            Text(
                text = normalText,
                fontSize = 32.sp,
                fontWeight = FontWeight.Black,
                color = NeoTheme.colors.textPrimary,
                modifier = Modifier.padding(end = 8.dp)
            )
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(highlightColor)
                .border(2.dp, NeoTheme.colors.border, RoundedCornerShape(8.dp))
                .padding(horizontal = 10.dp, vertical = 2.dp)
        ) {
            Text(
                text = highlightText,
                fontSize = 32.sp,
                fontWeight = FontWeight.Black,
                color = highlightTextColor
            )
        }
    }
}

@Composable
fun NeoBasicText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle.Default
) {
    BasicText(
        text = text,
        modifier = modifier,
        style = style
    )
}

@Composable
fun NeoIcon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun NeoIcon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current
) {
    Icon(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun NeoImage(
    bitmap: ImageBitmap,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    androidx.compose.foundation.Image(
        bitmap = bitmap,
        contentDescription = contentDescription,
        modifier = modifier
            .border(2.dp, NeoTheme.colors.border, RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp)),
        contentScale = contentScale
    )
}

@Composable
fun NeoAsyncImage(
    model: Any?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    // Fallback/placeholder container for AsyncImage in custom library
    Box(
        modifier = modifier
            .neoContainer(
                backgroundColor = NeoTheme.colors.surfaceVariant,
                borderColor = NeoTheme.colors.border,
                shadowOffset = 2.dp,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = contentDescription ?: "AsyncImage",
            fontWeight = FontWeight.Bold,
            color = NeoTheme.colors.textSecondary
        )
    }
}

@Composable
fun NeoSpacer(
    width: Dp = 0.dp,
    height: Dp = 0.dp,
    modifier: Modifier = Modifier
) {
    Spacer(modifier = modifier.width(width).height(height))
}

@Composable
fun NeoDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 2.dp,
    color: Color = NeoTheme.colors.border
) {
    HorizontalDivider(
        modifier = modifier,
        thickness = thickness,
        color = color
    )
}

@Composable
fun NeoHorizontalDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 2.dp,
    color: Color = NeoTheme.colors.border
) {
    HorizontalDivider(
        modifier = modifier,
        thickness = thickness,
        color = color
    )
}

@Composable
fun NeoVerticalDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 2.dp,
    color: Color = NeoTheme.colors.border
) {
    VerticalDivider(
        modifier = modifier,
        thickness = thickness,
        color = color
    )
}
