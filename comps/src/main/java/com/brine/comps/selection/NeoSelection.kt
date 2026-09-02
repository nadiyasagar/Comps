package com.brine.comps.selection

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brine.comps.foundation.neoContainer
import com.brine.comps.theme.NeoTheme

@Composable
fun NeoFilterChip(
    selected: Boolean,
    onClick: () -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    activeColor: Color = NeoTheme.colors.red,
    inactiveColor: Color = NeoTheme.colors.surface
) {
    Box(
        modifier = modifier
            .neoContainer(
                backgroundColor = if (selected) activeColor else inactiveColor,
                borderColor = NeoTheme.colors.border,
                shadowOffset = if (selected) 1.dp else 3.dp,
                shape = RoundedCornerShape(20.dp),
                onClick = onClick
            )
            .padding(horizontal = 14.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = if (selected) Color.White else NeoTheme.colors.textPrimary
        )
    }
}

@Composable
fun NeoAssistChip(
    onClick: () -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .neoContainer(
                backgroundColor = NeoTheme.colors.surface,
                borderColor = NeoTheme.colors.border,
                shadowOffset = 2.dp,
                shape = RoundedCornerShape(20.dp),
                onClick = onClick
            )
            .padding(horizontal = 14.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = NeoTheme.colors.textPrimary
        )
    }
}

@Composable
fun NeoInputChip(
    selected: Boolean,
    onClick: () -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    NeoFilterChip(
        selected = selected,
        onClick = onClick,
        label = label,
        modifier = modifier
    )
}

@Composable
fun NeoSuggestionChip(
    onClick: () -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    NeoAssistChip(
        onClick = onClick,
        label = label,
        modifier = modifier
    )
}

@Composable
fun NeoSingleChoiceSegmentedButtonRow(
    options: List<String>,
    selectedIndex: Int,
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .neoContainer(
                backgroundColor = NeoTheme.colors.surfaceVariant,
                borderColor = NeoTheme.colors.border,
                shadowOffset = 3.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            options.forEachIndexed { index, option ->
                val isSelected = index == selectedIndex
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .neoContainer(
                            backgroundColor = if (isSelected) NeoTheme.colors.darkSurface else Color.Transparent,
                            borderColor = if (isSelected) NeoTheme.colors.border else Color.Transparent,
                            shadowOffset = 0.dp,
                            shape = RoundedCornerShape(12.dp),
                            onClick = { onOptionSelected(index) }
                        )
                        .padding(vertical = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = option,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSelected) NeoTheme.colors.textOnDark else NeoTheme.colors.textPrimary
                    )
                }
            }
        }
    }
}

@Composable
fun NeoMultiChoiceSegmentedButtonRow(
    options: List<String>,
    selectedIndices: Set<Int>,
    onOptionToggled: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .neoContainer(
                backgroundColor = NeoTheme.colors.surfaceVariant,
                borderColor = NeoTheme.colors.border,
                shadowOffset = 3.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            options.forEachIndexed { index, option ->
                val isSelected = selectedIndices.contains(index)
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .neoContainer(
                            backgroundColor = if (isSelected) NeoTheme.colors.red else Color.Transparent,
                            borderColor = if (isSelected) NeoTheme.colors.border else Color.Transparent,
                            shadowOffset = 0.dp,
                            shape = RoundedCornerShape(12.dp),
                            onClick = { onOptionToggled(index) }
                        )
                        .padding(vertical = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = option,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isSelected) Color.White else NeoTheme.colors.textPrimary
                    )
                }
            }
        }
    }
}
