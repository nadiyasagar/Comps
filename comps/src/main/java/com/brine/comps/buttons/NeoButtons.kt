package com.brine.comps.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brine.comps.foundation.neoContainer
import com.brine.comps.theme.NeoTheme

@Composable
fun NeoButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = NeoTheme.colors.red,
    contentColor: Color = NeoTheme.colors.textOnRed,
    borderColor: Color = NeoTheme.colors.border,
    shadowColor: Color = NeoTheme.colors.shadow,
    shape: Shape = RoundedCornerShape(12.dp),
    shadowOffset: Dp = 4.dp,
    contentPadding: PaddingValues = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
    content: @Composable RowScope.() -> Unit
) {
    Box(
        modifier = modifier
            .neoContainer(
                backgroundColor = containerColor,
                borderColor = borderColor,
                shadowColor = shadowColor,
                shadowOffset = shadowOffset,
                shape = shape,
                onClick = onClick
            )
            .padding(contentPadding),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            content()
        }
    }
}

@Composable
fun NeoButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = NeoTheme.colors.red,
    contentColor: Color = NeoTheme.colors.textOnRed,
    shape: Shape = RoundedCornerShape(12.dp)
) {
    NeoButton(
        onClick = onClick,
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        shape = shape
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = contentColor
        )
    }
}

@Composable
fun NeoOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = NeoTheme.colors.surface,
    contentColor: Color = NeoTheme.colors.textPrimary,
    shape: Shape = RoundedCornerShape(12.dp),
    content: @Composable RowScope.() -> Unit
) {
    NeoButton(
        onClick = onClick,
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        shape = shape,
        shadowOffset = 2.dp,
        content = content
    )
}

@Composable
fun NeoTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentColor: Color = NeoTheme.colors.textPrimary,
    content: @Composable RowScope.() -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.textButtonColors(contentColor = contentColor)
    ) {
        content()
    }
}

@Composable
fun NeoIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = NeoTheme.colors.surface,
    borderColor: Color = NeoTheme.colors.border,
    shape: Shape = CircleShape,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .neoContainer(
                backgroundColor = containerColor,
                borderColor = borderColor,
                shadowOffset = 3.dp,
                shape = shape,
                onClick = onClick
            )
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Composable
fun NeoFilledTonalButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = NeoTheme.colors.greenLight,
    contentColor: Color = NeoTheme.colors.textPrimary,
    content: @Composable RowScope.() -> Unit
) {
    NeoButton(
        onClick = onClick,
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        shadowOffset = 3.dp,
        content = content
    )
}

@Composable
fun NeoElevatedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = NeoTheme.colors.surface,
    contentColor: Color = NeoTheme.colors.textPrimary,
    content: @Composable RowScope.() -> Unit
) {
    NeoButton(
        onClick = onClick,
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        shadowOffset = 6.dp,
        content = content
    )
}

@Composable
fun NeoFloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = NeoTheme.colors.red,
    contentColor: Color = NeoTheme.colors.textOnRed,
    shape: Shape = RoundedCornerShape(16.dp),
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .neoContainer(
                backgroundColor = containerColor,
                borderColor = NeoTheme.colors.border,
                shadowOffset = 5.dp,
                shape = shape,
                onClick = onClick
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Composable
fun NeoExtendedFloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)? = null,
    text: @Composable () -> Unit,
    containerColor: Color = NeoTheme.colors.red,
    contentColor: Color = NeoTheme.colors.textOnRed,
    shape: Shape = RoundedCornerShape(16.dp)
) {
    Box(
        modifier = modifier
            .neoContainer(
                backgroundColor = containerColor,
                borderColor = NeoTheme.colors.border,
                shadowOffset = 5.dp,
                shape = shape,
                onClick = onClick
            )
            .padding(horizontal = 20.dp, vertical = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon?.invoke()
            text()
        }
    }
}
