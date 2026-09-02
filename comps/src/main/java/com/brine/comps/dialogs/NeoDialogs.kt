package com.brine.comps.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.brine.comps.buttons.NeoButton
import com.brine.comps.buttons.NeoOutlinedButton
import com.brine.comps.foundation.neoContainer
import com.brine.comps.theme.NeoTheme

@Composable
fun NeoAlertDialog(
    onDismissRequest: () -> Unit,
    confirmButton: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    dismissButton: @Composable (() -> Unit)? = null,
    title: @Composable (() -> Unit)? = null,
    text: @Composable (() -> Unit)? = null,
    containerColor: Color = NeoTheme.colors.surface
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .neoContainer(
                    backgroundColor = containerColor,
                    borderColor = NeoTheme.colors.border,
                    shadowOffset = 6.dp,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(20.dp)
        ) {
            Column {
                title?.let {
                    Box(modifier = Modifier.padding(bottom = 12.dp)) { it() }
                }
                text?.let {
                    Box(modifier = Modifier.padding(bottom = 20.dp)) { it() }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    dismissButton?.let {
                        Box(modifier = Modifier.weight(1f).padding(end = 8.dp)) { it() }
                    }
                    Box(modifier = Modifier.weight(1f)) { confirmButton() }
                }
            }
        }
    }
}

@Composable
fun NeoBasicAlertDialog(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Box(
            modifier = modifier
                .neoContainer(
                    backgroundColor = NeoTheme.colors.surface,
                    borderColor = NeoTheme.colors.border,
                    shadowOffset = 6.dp,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(20.dp)
        ) {
            content()
        }
    }
}

@Composable
fun NeoDialog(
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Box(
            modifier = Modifier
                .neoContainer(
                    backgroundColor = NeoTheme.colors.surface,
                    borderColor = NeoTheme.colors.border,
                    shadowOffset = 6.dp,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(20.dp)
        ) {
            content()
        }
    }
}

@Composable
fun NeoPopup(
    onDismissRequest: (() -> Unit)? = null,
    properties: PopupProperties = PopupProperties(),
    content: @Composable () -> Unit
) {
    Popup(
        onDismissRequest = onDismissRequest,
        properties = properties
    ) {
        Box(
            modifier = Modifier
                .neoContainer(
                    backgroundColor = NeoTheme.colors.surface,
                    borderColor = NeoTheme.colors.border,
                    shadowOffset = 4.dp,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(12.dp)
        ) {
            content()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NeoModalBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = NeoTheme.colors.surface,
    content: @Composable () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        containerColor = containerColor,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(20.dp)
        ) {
            content()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NeoBottomSheetScaffold(
    sheetContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit
) {
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.PartiallyExpanded
        )
    )
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = { sheetContent() },
        modifier = modifier,
        sheetContainerColor = NeoTheme.colors.surface,
        content = content
    )
}
