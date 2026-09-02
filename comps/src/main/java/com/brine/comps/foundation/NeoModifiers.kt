package com.brine.comps.foundation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brine.comps.theme.NeoTheme

/**
  Draws a hard, un-blurred offset drop shadow underneath the component shape,
  giving it the signature Neo-Brutalist 3D pop.
 */
fun Modifier.neoShadow(
    offset: Dp = 4.dp,
    color: Color = Color(0xFF1A1A1A),
    shape: Shape = RoundedCornerShape(16.dp)
): Modifier = this.drawBehind {
    val shadowOffsetPx = offset.toPx()
    if (shadowOffsetPx > 0f) {
        val outline = shape.createOutline(size, layoutDirection, this)
        drawIntoCanvas { canvas ->
            canvas.save()
            canvas.translate(shadowOffsetPx, shadowOffsetPx)
            val paint = Paint().apply {
                this.color = color
                this.isAntiAlias = true
            }
            canvas.drawOutline(outline, paint)
            canvas.restore()
        }
    }
}

/**
  Applies a solid bold dark border to any shape.
 */
fun Modifier.neoBorder(
    width: Dp = 2.dp,
    color: Color = Color(0xFF1A1A1A),
    shape: Shape = RoundedCornerShape(16.dp)
): Modifier = this.border(width = width, color = color, shape = shape)

/**
  Combines background color, thick dark border, hard offset shadow, clipping, and immediate
  tactile click press animation on touch down.
 */
@Composable
fun Modifier.neoContainer(
    backgroundColor: Color = NeoTheme.colors.surface,
    borderColor: Color = NeoTheme.colors.border,
    shadowColor: Color = NeoTheme.colors.shadow,
    borderWidth: Dp = NeoTheme.elevation.defaultBorderWidth,
    shadowOffset: Dp = NeoTheme.elevation.defaultShadowOffset,
    shape: Shape = RoundedCornerShape(16.dp),
    onClick: (() -> Unit)? = null
): Modifier {
    val isPressedState = remember { mutableStateOf(false) }

    val currentOffset by animateDpAsState(
        targetValue = if (isPressedState.value && onClick != null) 1.dp else shadowOffset,
        label = "neo_press_offset"
    )

    var modifier = this
        .neoShadow(offset = currentOffset, color = shadowColor, shape = shape)
        .offset(
            x = if (isPressedState.value && onClick != null) shadowOffset - currentOffset else 0.dp,
            y = if (isPressedState.value && onClick != null) shadowOffset - currentOffset else 0.dp
        )
        .clip(shape)
        .background(backgroundColor, shape)
        .border(borderWidth, borderColor, shape)

    if (onClick != null) {
        modifier = modifier.pointerInput(onClick) {
            detectTapGestures(
                onPress = {
                    isPressedState.value = true
                    val released = tryAwaitRelease()
                    isPressedState.value = false
                    if (released) {
                        onClick()
                    }
                }
            )
        }
    }

    return modifier
}
