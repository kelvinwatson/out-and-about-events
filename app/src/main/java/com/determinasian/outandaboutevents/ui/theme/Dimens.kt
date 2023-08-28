package com.determinasian.outandaboutevents.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.dp

// TODO Use CompositionLocalProvider to provide dimensions as part of [OutAndAboutEventsTheme]

@Immutable
object Dimens {
    val MinToolbarHeight = 96.dp
    val MaxToolbarHeight = 176.dp
    val ToolbarSpacing = 16.dp

    val CardPadding = 16.dp
    val CardContentPadding = 12.dp

    val SuggestionChipSpacing = 4.dp

    val ImageRoundedCorner = 8.dp
    val ImageThumbnailSize = 72.dp

    val PaddingStandard = 16.dp

    val MinInteractionTarget = 24.dp

}


//class Dimensions(
//    val grid_0_25: Dp,
//    val grid_0_5: Dp,
//    val grid_1: Dp,
//    val grid_1_5: Dp,
//    val grid_2: Dp,
//    val grid_2_5: Dp,
//    val grid_3: Dp,
//    val grid_3_5: Dp,
//    val grid_4: Dp,
//    val grid_4_5: Dp,
//    val grid_5: Dp,
//    val grid_5_5: Dp,
//    val grid_6: Dp,
//    val plane_0: Dp,
//    val plane_1: Dp,
//    val plane_2: Dp,
//    val plane_3: Dp,
//    val plane_4: Dp,
//    val plane_5: Dp,
//    val minimum_touch_target: Dp = 48.dp,
//)
//
//val smallDimensions = Dimensions(
//    grid_0_25 = 1.5f.dp,
//    grid_0_5 = 3.dp,
//    grid_1 = 6.dp,
//    grid_1_5 = 9.dp,
//    grid_2 = 12.dp,
//    grid_2_5 = 15.dp,
//    grid_3 = 18.dp,
//    grid_3_5 = 21.dp,
//    grid_4 = 24.dp,
//    grid_4_5 = 27.dp,
//    grid_5 = 30.dp,
//    grid_5_5 = 33.dp,
//    grid_6 = 36.dp,
//    plane_0 = 0.dp,
//    plane_1 = 1.dp,
//    plane_2 = 2.dp,
//    plane_3 = 3.dp,
//    plane_4 = 6.dp,
//    plane_5 = 12.dp,
//)
//
//val sw360Dimensions = Dimensions(
//    grid_0_25 = 2.dp,
//    grid_0_5 = 4.dp,
//    grid_1 = 8.dp,
//    grid_1_5 = 12.dp,
//    grid_2 = 16.dp,
//    grid_2_5 = 20.dp,
//    grid_3 = 24.dp,
//    grid_3_5 = 28.dp,
//    grid_4 = 32.dp,
//    grid_4_5 = 36.dp,
//    grid_5 = 40.dp,
//    grid_5_5 = 44.dp,
//    grid_6 = 48.dp,
//    plane_0 = 0.dp,
//    plane_1 = 1.dp,
//    plane_2 = 2.dp,
//    plane_3 = 4.dp,
//    plane_4 = 8.dp,
//    plane_5 = 16.dp,
//)

//@Composable
//fun ProvideDimens(
//    dimensions: Dimensions,
//    content: @Composable () -> Unit
//) {
//    val dimensionSet = remember { dimensions }
//    CompositionLocalProvider(LocalAppDimens provides dimensionSet, content = content)
//}
//
//private val LocalAppDimens = staticCompositionLocalOf {
//    smallDimensions
//}
//
//@Composable
//fun AppTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    content: @Composable () -> Unit
//) {
//    val colors = if (darkTheme) DarkThemeColors else LightThemeColors
//    val configuration = LocalConfiguration.current
//    val dimensions = if (configuration.screenWidthDp <= 360) smallDimensions else sw360Dimensions
//    val typography = if (configuration.screenWidthDp <= 360) smallTypography else sw360Typography
//
//    ProvideDimens(dimensions = dimensions) {
//        ProvideColors(colors = colors) {
//            MaterialTheme(
//                colors = colors,
//                shapes = Shapes,
//                typography = typography,
//                content = content,
//            )
//        }
//    }
//}
//
//object AppTheme {
//    val colors: Colors
//        @Composable
//        get() = LocalAppColors.current
//
//    val dimens: Dimensions
//        @Composable
//        get() = LocalAppDimens.current
//}
//
//val Dimens: Dimensions
//    @Composable
//    get() = AppTheme.dimens