# Comps - Playful / Neo-Brutalist Jetpack Compose Component Library 🎨

`comps` is an Android Jetpack Compose UI component library built with a modern **Playful Brutalist / Neo-Brutalist** design aesthetic. It features bold dark outlines, hard drop shadows, tactile press animations, high-contrast color palettes, and title word-highlight banners.

---

## 🚀 Quick Setup & Installation

### Option A: Local Project Dependency (Multi-module)
Add the `:comps` module to your project's `settings.gradle.kts`:

```kotlin
include(":comps")
```

Then in your app module's `build.gradle.kts`:

```kotlin
dependencies {
    implementation(project(":comps"))
}
```

---

### Option B: Publish & Import via Maven / JitPack

To publish `:comps` to your local Maven repository:

```bash
./gradlew :comps:publishToMavenLocal
```

Then add to your `build.gradle.kts`:

```kotlin
repositories {
    mavenLocal()
    // or maven { url = URI("https://jitpack.io") }
}

dependencies {
    implementation("com.github.brine:comps:1.0.0")
}
```

---

## 🎨 Integrating `comps` with Existing Projects & Themes

If a developer already has their own existing project theme (e.g. `MyProjectTheme` in `Theme.kt`), they have **3 flexible ways** to use `comps`:

### Method 1: Wrap Existing Theme with `ProvideCompsTheme` (Recommended)
Add `ProvideCompsTheme` inside their app's existing theme function. This injects the Neo-Brutalist design tokens without modifying or overriding their app's current `MaterialTheme` colors or fonts:

```kotlin
// In the user's existing Theme.kt
@Composable
fun MyProjectTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = myColorScheme,
        typography = myTypography
    ) {
        // Inject Comps tokens seamlessly
        ProvideCompsTheme {
            content()
        }
    }
}
```

Now, any `NeoButton`, `NeoCard`, `NeoTextField`, etc. used anywhere in their app will automatically pick up the Neo-Brutalist styles while keeping their app's MaterialTheme intact!

---

### Method 2: Scope `CompsTheme` / `ProvideCompsTheme` locally around specific screens
If a developer only wants Neo-Brutalist styling on a specific screen or section:

```kotlin
@Composable
fun MySpecialFeatureScreen() {
    CompsTheme {
        // Only components inside this block inherit the full Neo-Brutalist look
        Column {
            NeoHighlightTitle(normalText = "Special", highlightText = "Offer")
            NeoButton(text = "Claim Now", onClick = { })
        }
    }
}
```

---

### Method 3: Direct Parameter Customization
Every `comps` component accepts explicit color and style overrides (`containerColor`, `borderColor`, `shadowColor`, `shape`), allowing developers to use them standalone anywhere:

```kotlin
NeoButton(
    text = "Custom Neo Button",
    onClick = { },
    containerColor = Color(0xFFE53935),
    borderColor = Color.Black
)
```

---

## 📦 Component Overview

`comps` provides custom styled Neo-Brutalist implementations across 10 categories:

| Category | Available Components |
|---|---|
| **Text & Display** | `NeoText`, `NeoHighlightTitle`, `NeoBasicText`, `NeoIcon`, `NeoImage`, `NeoAsyncImage`, `NeoDivider` |
| **Buttons** | `NeoButton`, `NeoOutlinedButton`, `NeoTextButton`, `NeoIconButton`, `NeoFilledTonalButton`, `NeoElevatedButton`, `NeoFloatingActionButton`, `NeoExtendedFloatingActionButton` |
| **Input** | `NeoTextField`, `NeoOutlinedTextField`, `NeoBasicTextField`, `NeoCheckbox`, `NeoTriStateCheckbox`, `NeoRadioButton`, `NeoSwitch`, `NeoSlider`, `NeoRangeSlider`, `NeoDropdownMenu` |
| **Selection & Chips** | `NeoFilterChip`, `NeoAssistChip`, `NeoInputChip`, `NeoSuggestionChip`, `NeoSingleChoiceSegmentedButtonRow`, `NeoMultiChoiceSegmentedButtonRow` |
| **Cards & Surfaces** | `NeoCard`, `NeoElevatedCard`, `NeoOutlinedCard`, `NeoSurface`, `NeoListItem` |
| **Navigation** | `NeoScaffold`, `NeoTopAppBar`, `NeoCenterAlignedTopAppBar`, `NeoNavigationBar`, `NeoNavigationBarItem`, `NeoTabRow`, `NeoScrollableTabRow`, `NeoBottomAppBar`, `NeoNavigationRail` |
| **Dialogs & Popups** | `NeoAlertDialog`, `NeoBasicAlertDialog`, `NeoDialog`, `NeoPopup`, `NeoModalBottomSheet` |
| **Progress** | `NeoCircularProgressIndicator`, `NeoLinearProgressIndicator`, `NeoPullToRefreshContainer` |
| **Layouts** | `NeoRow`, `NeoColumn`, `NeoBox`, `NeoFlowRow`, `NeoFlowColumn`, `NeoLazyColumn`, `NeoLazyRow` |
