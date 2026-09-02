package com.brine.comps.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brine.comps.foundation.neoContainer
import com.brine.comps.theme.NeoTheme

@Composable
fun NeoCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = NeoTheme.colors.surface,
    borderColor: Color = NeoTheme.colors.border,
    shadowColor: Color = NeoTheme.colors.shadow,
    shadowOffset: Dp = 4.dp,
    shape: Shape = RoundedCornerShape(16.dp),
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Box(
        modifier = modifier
            .neoContainer(
                backgroundColor = backgroundColor,
                borderColor = borderColor,
                shadowColor = shadowColor,
                shadowOffset = shadowOffset,
                shape = shape,
                onClick = onClick
            )
            .padding(16.dp)
    ) {
        Column {
            content()
        }
    }
}

@Composable
fun NeoElevatedCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = NeoTheme.colors.surface,
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    NeoCard(
        modifier = modifier,
        backgroundColor = backgroundColor,
        shadowOffset = 6.dp,
        onClick = onClick,
        content = content
    )
}

@Composable
fun NeoOutlinedCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = NeoTheme.colors.surface,
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    NeoCard(
        modifier = modifier,
        backgroundColor = backgroundColor,
        shadowOffset = 2.dp,
        onClick = onClick,
        content = content
    )
}

@Composable
fun NeoSurface(
    modifier: Modifier = Modifier,
    color: Color = NeoTheme.colors.surface,
    shape: Shape = RoundedCornerShape(12.dp),
    shadowOffset: Dp = 3.dp,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .neoContainer(
                backgroundColor = color,
                borderColor = NeoTheme.colors.border,
                shadowOffset = shadowOffset,
                shape = shape
            )
            .padding(12.dp)
    ) {
        content()
    }
}

@Composable
fun NeoListItem(
    headlineContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    supportingContent: @Composable (() -> Unit)? = null,
    leadingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null,
    backgroundColor: Color = NeoTheme.colors.surface,
    onClick: (() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .neoContainer(
                backgroundColor = backgroundColor,
                borderColor = NeoTheme.colors.border,
                shadowOffset = 3.dp,
                shape = RoundedCornerShape(14.dp),
                onClick = onClick
            )
            .padding(horizontal = 14.dp, vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            leadingContent?.let {
                Box(modifier = Modifier.padding(end = 12.dp)) { it() }
            }
            Column(modifier = Modifier.weight(1f)) {
                headlineContent()
                supportingContent?.let { it() }
            }
            trailingContent?.let {
                Box(modifier = Modifier.padding(start = 12.dp)) { it() }
            }
        }
    }
}
