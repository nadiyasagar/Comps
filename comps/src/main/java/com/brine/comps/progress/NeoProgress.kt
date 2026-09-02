package com.brine.comps.progress

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brine.comps.theme.NeoTheme

@Composable
fun NeoCircularProgressIndicator(
    modifier: Modifier = Modifier,
    color: Color = NeoTheme.colors.red,
    trackColor: Color = NeoTheme.colors.surfaceVariant,
    strokeWidth: Dp = 4.dp
) {
    CircularProgressIndicator(
        modifier = modifier,
        color = color,
        trackColor = trackColor,
        strokeWidth = strokeWidth,
        strokeCap = StrokeCap.Round
    )
}

@Composable
fun NeoLinearProgressIndicator(
    progress: () -> Float,
    modifier: Modifier = Modifier,
    color: Color = NeoTheme.colors.red,
    trackColor: Color = NeoTheme.colors.surfaceVariant
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(14.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(trackColor)
            .border(2.dp, NeoTheme.colors.border, RoundedCornerShape(10.dp))
    ) {
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier.fillMaxWidth().height(14.dp),
            color = color,
            trackColor = Color.Transparent
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NeoPullToRefreshContainer(
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val state = rememberPullToRefreshState()
    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        state = state,
        modifier = modifier,
        indicator = {
            Indicator(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .border(2.dp, NeoTheme.colors.border, CircleShape),
                isRefreshing = isRefreshing,
                containerColor = NeoTheme.colors.surface,
                color = NeoTheme.colors.red,
                state = state
            )
        }
    ) {
        content()
    }
}
