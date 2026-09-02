package com.brine.comps.input

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brine.comps.foundation.neoContainer
import com.brine.comps.theme.NeoTheme

@Composable
fun NeoTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    label: String? = null,
    singleLine: Boolean = true,
    shape: Shape = RoundedCornerShape(12.dp)
) {
    Column(modifier = modifier) {
        if (label != null) {
            Text(
                text = label,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = NeoTheme.colors.textSecondary,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .neoContainer(
                    backgroundColor = NeoTheme.colors.surface,
                    borderColor = NeoTheme.colors.border,
                    shadowOffset = 3.dp,
                    shape = shape
                )
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            if (value.isEmpty() && placeholder.isNotEmpty()) {
                Text(
                    text = placeholder,
                    color = NeoTheme.colors.textSecondary,
                    fontSize = 15.sp
                )
            }
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = singleLine,
                textStyle = TextStyle(
                    color = NeoTheme.colors.textPrimary,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun NeoOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String = ""
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = label?.let { { Text(it, fontWeight = FontWeight.Bold) } },
        placeholder = { Text(placeholder) },
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = NeoTheme.colors.border,
            unfocusedBorderColor = NeoTheme.colors.border,
            focusedContainerColor = NeoTheme.colors.surface,
            unfocusedContainerColor = NeoTheme.colors.surface,
            focusedLabelColor = NeoTheme.colors.red,
            unfocusedLabelColor = NeoTheme.colors.textSecondary
        )
    )
}

@Composable
fun NeoBasicTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        textStyle = textStyle
    )
}

@Composable
fun NeoCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(24.dp)
            .neoContainer(
                backgroundColor = if (checked) NeoTheme.colors.red else NeoTheme.colors.surface,
                borderColor = NeoTheme.colors.border,
                shadowOffset = 2.dp,
                shape = RoundedCornerShape(6.dp),
                onClick = { onCheckedChange(!checked) }
            ),
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Text(
                text = "✓",
                color = Color.White,
                fontWeight = FontWeight.Black,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun NeoRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(24.dp)
            .neoContainer(
                backgroundColor = NeoTheme.colors.surface,
                borderColor = NeoTheme.colors.border,
                shadowOffset = 2.dp,
                shape = CircleShape,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        if (selected) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(NeoTheme.colors.red)
            )
        }
    }
}

@Composable
fun NeoSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val thumbOffset by animateDpAsState(
        targetValue = if (checked) 24.dp else 2.dp,
        label = "neo_switch_thumb"
    )

    Box(
        modifier = modifier
            .width(52.dp)
            .height(28.dp)
            .neoContainer(
                backgroundColor = if (checked) NeoTheme.colors.red else NeoTheme.colors.surfaceVariant,
                borderColor = NeoTheme.colors.border,
                shadowOffset = 2.dp,
                shape = RoundedCornerShape(20.dp),
                onClick = { onCheckedChange(!checked) }
            )
            .padding(vertical = 2.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .offset(x = thumbOffset)
                .size(22.dp)
                .clip(CircleShape)
                .background(if (checked) Color.White else NeoTheme.colors.darkSurface)
                .border(1.5.dp, NeoTheme.colors.border, CircleShape)
        )
    }
}

@Composable
fun NeoSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f
) {
    Slider(
        value = value,
        onValueChange = onValueChange,
        valueRange = valueRange,
        modifier = modifier,
        colors = SliderDefaults.colors(
            thumbColor = NeoTheme.colors.red,
            activeTrackColor = NeoTheme.colors.red,
            inactiveTrackColor = NeoTheme.colors.surfaceVariant
        )
    )
}

@Composable
fun NeoRangeSlider(
    value: ClosedFloatingPointRange<Float>,
    onValueChange: (ClosedFloatingPointRange<Float>) -> Unit,
    modifier: Modifier = Modifier,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f
) {
    RangeSlider(
        value = value,
        onValueChange = onValueChange,
        valueRange = valueRange,
        modifier = modifier,
        colors = SliderDefaults.colors(
            thumbColor = NeoTheme.colors.red,
            activeTrackColor = NeoTheme.colors.red,
            inactiveTrackColor = NeoTheme.colors.surfaceVariant
        )
    )
}

@Composable
fun NeoDropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        modifier = modifier
            .background(NeoTheme.colors.surface)
            .border(2.dp, NeoTheme.colors.border, RoundedCornerShape(12.dp))
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NeoExposedDropdownMenuBox(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = onExpandedChange,
        modifier = modifier
    ) {
        content()
    }
}

@Composable
fun NeoTriStateCheckbox(
    state: ToggleableState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(24.dp)
            .neoContainer(
                backgroundColor = when (state) {
                    ToggleableState.On -> NeoTheme.colors.red
                    ToggleableState.Indeterminate -> NeoTheme.colors.yellowLight
                    ToggleableState.Off -> NeoTheme.colors.surface
                },
                borderColor = NeoTheme.colors.border,
                shadowOffset = 2.dp,
                shape = RoundedCornerShape(6.dp),
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            ToggleableState.On -> Text("✓", color = Color.White, fontWeight = FontWeight.Black, fontSize = 14.sp)
            ToggleableState.Indeterminate -> Text("-", color = NeoTheme.colors.border, fontWeight = FontWeight.Black, fontSize = 16.sp)
            ToggleableState.Off -> {}
        }
    }
}
