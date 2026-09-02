package com.brine.comps.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brine.comps.foundation.neoContainer
import com.brine.comps.theme.NeoTheme

@Composable
fun NeoScaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    containerColor: Color = NeoTheme.colors.background,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = topBar,
        bottomBar = bottomBar,
        floatingActionButton = floatingActionButton,
        containerColor = containerColor,
        content = content
    )
}

@Composable
fun NeoNavigationBar(
    modifier: Modifier = Modifier,
    containerColor: Color = NeoTheme.colors.surface,
    borderColor: Color = NeoTheme.colors.border,
    borderWidth: Dp = NeoTheme.elevation.defaultBorderWidth,
    shadowOffset: Dp = 4.dp,
    shape: Shape = RoundedCornerShape(20.dp),
    content: @Composable RowScope.() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .neoContainer(
                backgroundColor = containerColor,
                borderColor = borderColor,
                borderWidth = borderWidth,
                shadowOffset = shadowOffset,
                shape = shape
            )
            .padding(2.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            content = content
        )
    }
}

@Composable
fun RowScope.NeoNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .weight(1f)
            .padding(horizontal = 4.dp, vertical = 6.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(if (selected) NeoTheme.colors.red else Color.Transparent)
            .border(
                width = if (selected) 2.dp else 0.dp,
                color = if (selected) NeoTheme.colors.border else Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() }
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            icon()
            if (label != null) {
                label()
            }
        }
    }
}

@Composable
fun NeoNavigationRail(
    modifier: Modifier = Modifier,
    containerColor: Color = NeoTheme.colors.surface,
    header: @Composable (ColumnScope.() -> Unit)? = null,
    content: @Composable (ColumnScope.() -> Unit)
) {
    NavigationRail(
        modifier = modifier.border(width = 2.dp, color = NeoTheme.colors.border),
        containerColor = containerColor,
        header = header,
        content = content
    )
}

@Composable
fun NeoNavigationRailItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null
) {
    NavigationRailItem(
        selected = selected,
        onClick = onClick,
        icon = icon,
        label = label,
        modifier = modifier
    )
}

@Composable
fun NeoModalNavigationDrawer(
    drawerContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    drawerState: DrawerState,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerContent = drawerContent,
        modifier = modifier,
        drawerState = drawerState,
        content = content
    )
}

@Composable
fun NeoModalDrawerSheet(
    modifier: Modifier = Modifier,
    drawerContainerColor: Color = NeoTheme.colors.surface,
    content: @Composable (ColumnScope.() -> Unit)
) {
    ModalDrawerSheet(
        modifier = modifier.border(width = 2.dp, color = NeoTheme.colors.border),
        drawerContainerColor = drawerContainerColor,
        content = content
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NeoTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    containerColor: Color = NeoTheme.colors.surface,
    borderColor: Color = NeoTheme.colors.border,
    borderWidth: Dp = NeoTheme.elevation.defaultBorderWidth,
    shadowOffset: Dp = 3.dp,
    shape: Shape = RoundedCornerShape(16.dp)
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .neoContainer(
                backgroundColor = containerColor,
                borderColor = borderColor,
                borderWidth = borderWidth,
                shadowOffset = shadowOffset,
                shape = shape
            )
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            navigationIcon()
            Box(modifier = Modifier.weight(1f)) { title() }
            actions()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NeoCenterAlignedTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {
    NeoTopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = actions
    )
}

@Composable
fun NeoBottomAppBar(
    modifier: Modifier = Modifier,
    containerColor: Color = NeoTheme.colors.surface,
    content: @Composable RowScope.() -> Unit
) {
    BottomAppBar(
        modifier = modifier.border(width = 2.dp, color = NeoTheme.colors.border),
        containerColor = containerColor,
        content = content
    )
}

@Composable
fun NeoTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = NeoTheme.colors.surface,
    tabs: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .neoContainer(
                backgroundColor = containerColor,
                borderColor = NeoTheme.colors.border,
                shadowOffset = 2.dp,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(4.dp)
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.Transparent,
            contentColor = NeoTheme.colors.textPrimary,
            indicator = { tabPositions ->
                if (selectedTabIndex < tabPositions.size) {
                    Box(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[selectedTabIndex])
                            .fillMaxWidth()
                            .padding(4.dp)
                            .neoContainer(
                                backgroundColor = NeoTheme.colors.red,
                                borderColor = NeoTheme.colors.border,
                                shadowOffset = 0.dp,
                                shape = RoundedCornerShape(8.dp)
                            )
                    )
                }
            },
            divider = {},
            tabs = tabs
        )
    }
}

@Composable
fun NeoScrollableTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = NeoTheme.colors.surface,
    tabs: @Composable () -> Unit
) {
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier.border(width = 2.dp, color = NeoTheme.colors.border, shape = RoundedCornerShape(12.dp)),
        containerColor = containerColor,
        tabs = tabs
    )
}
