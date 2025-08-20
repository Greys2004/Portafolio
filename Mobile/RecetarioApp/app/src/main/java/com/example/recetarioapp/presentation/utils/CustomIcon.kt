package com.example.recetarioapp.presentation.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Home: ImageVector
    get() {
        if (_Home != null) return _Home!!

        _Home = ImageVector.Builder(
            name = "Home",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(8.36f, 1.37f)
                lineToRelative(6.36f, 5.8f)
                lineToRelative(-0.71f, 0.71f)
                lineTo(13f, 6.964f)
                verticalLineToRelative(6.526f)
                lineToRelative(-0.5f, 0.5f)
                horizontalLineToRelative(-3f)
                lineToRelative(-0.5f, -0.5f)
                verticalLineToRelative(-3.5f)
                horizontalLineTo(7f)
                verticalLineToRelative(3.5f)
                lineToRelative(-0.5f, 0.5f)
                horizontalLineToRelative(-3f)
                lineToRelative(-0.5f, -0.5f)
                verticalLineTo(6.972f)
                lineTo(2f, 7.88f)
                lineToRelative(-0.71f, -0.71f)
                lineToRelative(6.35f, -5.8f)
                horizontalLineToRelative(0.72f)
                close()
                moveTo(4f, 6.063f)
                verticalLineToRelative(6.927f)
                horizontalLineToRelative(2f)
                verticalLineToRelative(-3.5f)
                lineToRelative(0.5f, -0.5f)
                horizontalLineToRelative(3f)
                lineToRelative(0.5f, 0.5f)
                verticalLineToRelative(3.5f)
                horizontalLineToRelative(2f)
                verticalLineTo(6.057f)
                lineTo(8f, 2.43f)
                lineTo(4f, 6.063f)
                close()
            }
        }.build()

        return _Home!!
    }

private var _Home: ImageVector? = null



val Bookmark: ImageVector
    get() {
        if (_Bookmark != null) return _Bookmark!!

        _Bookmark = ImageVector.Builder(
            name = "Bookmark",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(2f, 2f)
                arcToRelative(2f, 2f, 0f, false, true, 2f, -2f)
                horizontalLineToRelative(8f)
                arcToRelative(2f, 2f, 0f, false, true, 2f, 2f)
                verticalLineToRelative(13.5f)
                arcToRelative(0.5f, 0.5f, 0f, false, true, -0.777f, 0.416f)
                lineTo(8f, 13.101f)
                lineToRelative(-5.223f, 2.815f)
                arcTo(0.5f, 0.5f, 0f, false, true, 2f, 15.5f)
                close()
                moveToRelative(2f, -1f)
                arcToRelative(1f, 1f, 0f, false, false, -1f, 1f)
                verticalLineToRelative(12.566f)
                lineToRelative(4.723f, -2.482f)
                arcToRelative(0.5f, 0.5f, 0f, false, true, 0.554f, 0f)
                lineTo(13f, 14.566f)
                verticalLineTo(2f)
                arcToRelative(1f, 1f, 0f, false, false, -1f, -1f)
                close()
            }
        }.build()

        return _Bookmark!!
    }

private var _Bookmark: ImageVector? = null




val Heart: ImageVector
    get() {
        if (_HeartFilled != null) return _HeartFilled!!

        _HeartFilled = ImageVector.Builder(
            name = "HeartFilled",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(14.88f, 4.78079f)
                curveTo(14.7993f, 4.46498f, 14.6748f, 4.16202f, 14.51f, 3.88077f)
                curveTo(14.3518f, 3.58819f, 14.1493f, 3.3217f, 13.91f, 3.09073f)
                curveTo(13.563f, 2.74486f, 13.152f, 2.46982f, 12.7f, 2.28079f)
                curveTo(11.7902f, 1.90738f, 10.7698f, 1.90738f, 9.85999f, 2.28079f)
                curveTo(9.43276f, 2.46163f, 9.04027f, 2.71541f, 8.70002f, 3.03079f)
                lineTo(8.65003f, 3.09073f)
                lineTo(8.00001f, 3.74075f)
                lineTo(7.34999f, 3.09073f)
                lineTo(7.3f, 3.03079f)
                curveTo(6.95975f, 2.71541f, 6.56726f, 2.46163f, 6.14002f, 2.28079f)
                curveTo(5.23018f, 1.90738f, 4.20984f, 1.90738f, 3.3f, 2.28079f)
                curveTo(2.84798f, 2.46982f, 2.43706f, 2.74486f, 2.09004f, 3.09073f)
                curveTo(1.85051f, 3.32402f, 1.64514f, 3.59002f, 1.48002f, 3.88077f)
                curveTo(1.32258f, 4.1644f, 1.20161f, 4.46682f, 1.12f, 4.78079f)
                curveTo(1.03522f, 5.10721f, 0.994861f, 5.44358f, 1.00001f, 5.78079f)
                curveTo(1.00053f, 6.09791f, 1.04084f, 6.41365f, 1.12f, 6.72073f)
                curveTo(1.20384f, 7.03078f, 1.32472f, 7.32961f, 1.48002f, 7.61075f)
                curveTo(1.64774f, 7.89975f, 1.85285f, 8.16542f, 2.09004f, 8.40079f)
                lineTo(8.00001f, 14.3108f)
                lineTo(13.91f, 8.40079f)
                curveTo(14.1471f, 8.16782f, 14.3492f, 7.90169f, 14.51f, 7.61075f)
                curveTo(14.6729f, 7.33211f, 14.7974f, 7.03272f, 14.88f, 6.72073f)
                curveTo(14.9592f, 6.41365f, 14.9995f, 6.09791f, 15f, 5.78079f)
                curveTo(15.0052f, 5.44358f, 14.9648f, 5.10721f, 14.88f, 4.78079f)
                close()
            }
        }.build()

        return _HeartFilled!!
    }

private var _HeartFilled: ImageVector? = null

val Layers: ImageVector
    get() {
        if (_Layers != null) return _Layers!!

        _Layers = ImageVector.Builder(
            name = "Layers",
            defaultWidth = 15.dp,
            defaultHeight = 15.dp,
            viewportWidth = 15f,
            viewportHeight = 15f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(7.75432f, 0.819537f)
                curveTo(7.59742f, 0.726821f, 7.4025f, 0.726821f, 7.24559f, 0.819537f)
                lineTo(1.74559f, 4.06954f)
                curveTo(1.59336f, 4.15949f, 1.49996f, 4.32317f, 1.49996f, 4.5f)
                curveTo(1.49996f, 4.67683f, 1.59336f, 4.84051f, 1.74559f, 4.93046f)
                lineTo(7.24559f, 8.18046f)
                curveTo(7.4025f, 8.27318f, 7.59742f, 8.27318f, 7.75432f, 8.18046f)
                lineTo(13.2543f, 4.93046f)
                curveTo(13.4066f, 4.84051f, 13.5f, 4.67683f, 13.5f, 4.5f)
                curveTo(13.5f, 4.32317f, 13.4066f, 4.15949f, 13.2543f, 4.06954f)
                lineTo(7.75432f, 0.819537f)
                close()
                moveTo(7.49996f, 7.16923f)
                lineTo(2.9828f, 4.5f)
                lineTo(7.49996f, 1.83077f)
                lineTo(12.0171f, 4.5f)
                lineTo(7.49996f, 7.16923f)
                close()
                moveTo(1.5695f, 7.49564f)
                curveTo(1.70998f, 7.2579f, 2.01659f, 7.17906f, 2.25432f, 7.31954f)
                lineTo(7.49996f, 10.4192f)
                lineTo(12.7456f, 7.31954f)
                curveTo(12.9833f, 7.17906f, 13.2899f, 7.2579f, 13.4304f, 7.49564f)
                curveTo(13.5709f, 7.73337f, 13.4921f, 8.03998f, 13.2543f, 8.18046f)
                lineTo(7.75432f, 11.4305f)
                curveTo(7.59742f, 11.5232f, 7.4025f, 11.5232f, 7.24559f, 11.4305f)
                lineTo(1.74559f, 8.18046f)
                curveTo(1.50786f, 8.03998f, 1.42901f, 7.73337f, 1.5695f, 7.49564f)
                close()
                moveTo(1.56949f, 10.4956f)
                curveTo(1.70998f, 10.2579f, 2.01658f, 10.1791f, 2.25432f, 10.3195f)
                lineTo(7.49996f, 13.4192f)
                lineTo(12.7456f, 10.3195f)
                curveTo(12.9833f, 10.1791f, 13.2899f, 10.2579f, 13.4304f, 10.4956f)
                curveTo(13.5709f, 10.7334f, 13.4921f, 11.04f, 13.2543f, 11.1805f)
                lineTo(7.75432f, 14.4305f)
                curveTo(7.59742f, 14.5232f, 7.4025f, 14.5232f, 7.24559f, 14.4305f)
                lineTo(1.74559f, 11.1805f)
                curveTo(1.50785f, 11.04f, 1.42901f, 10.7334f, 1.56949f, 10.4956f)
                close()
            }
        }.build()

        return _Layers!!
    }

private var _Layers: ImageVector? = null










val StarFilled: ImageVector
    get() {
        if (_StarFilled != null) return _StarFilled!!

        _StarFilled = ImageVector.Builder(
            name = "StarFilled",
            defaultWidth = 15.dp,
            defaultHeight = 15.dp,
            viewportWidth = 15f,
            viewportHeight = 15f
        ).apply {
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(7.22303f, 0.665992f)
                curveTo(7.32551f, 0.419604f, 7.67454f, 0.419604f, 7.77702f, 0.665992f)
                lineTo(9.41343f, 4.60039f)
                curveTo(9.45663f, 4.70426f, 9.55432f, 4.77523f, 9.66645f, 4.78422f)
                lineTo(13.914f, 5.12475f)
                curveTo(14.18f, 5.14607f, 14.2878f, 5.47802f, 14.0852f, 5.65162f)
                lineTo(10.849f, 8.42374f)
                curveTo(10.7636f, 8.49692f, 10.7263f, 8.61176f, 10.7524f, 8.72118f)
                lineTo(11.7411f, 12.866f)
                curveTo(11.803f, 13.1256f, 11.5206f, 13.3308f, 11.2929f, 13.1917f)
                lineTo(7.6564f, 10.9705f)
                curveTo(7.5604f, 10.9119f, 7.43965f, 10.9119f, 7.34365f, 10.9705f)
                lineTo(3.70718f, 13.1917f)
                curveTo(3.47945f, 13.3308f, 3.19708f, 13.1256f, 3.25899f, 12.866f)
                lineTo(4.24769f, 8.72118f)
                curveTo(4.2738f, 8.61176f, 4.23648f, 8.49692f, 4.15105f, 8.42374f)
                lineTo(0.914889f, 5.65162f)
                curveTo(0.712228f, 5.47802f, 0.820086f, 5.14607f, 1.08608f, 5.12475f)
                lineTo(5.3336f, 4.78422f)
                curveTo(5.44573f, 4.77523f, 5.54342f, 4.70426f, 5.58662f, 4.60039f)
                lineTo(7.22303f, 0.665992f)
                close()
            }
        }.build()

        return _StarFilled!!
    }

private var _StarFilled: ImageVector? = null



val ClockHistory: ImageVector
    get() {
        if (_ClockHistory != null) return _ClockHistory!!

        _ClockHistory = ImageVector.Builder(
            name = "ClockHistory",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(8.515f, 1.019f)
                arcTo(7f, 7f, 0f, false, false, 8f, 1f)
                verticalLineTo(0f)
                arcToRelative(8f, 8f, 0f, false, true, 0.589f, 0.022f)
                close()
                moveToRelative(2.004f, 0.45f)
                arcToRelative(7f, 7f, 0f, false, false, -0.985f, -0.299f)
                lineToRelative(0.219f, -0.976f)
                quadToRelative(0.576f, 0.129f, 1.126f, 0.342f)
                close()
                moveToRelative(1.37f, 0.71f)
                arcToRelative(7f, 7f, 0f, false, false, -0.439f, -0.27f)
                lineToRelative(0.493f, -0.87f)
                arcToRelative(8f, 8f, 0f, false, true, 0.979f, 0.654f)
                lineToRelative(-0.615f, 0.789f)
                arcToRelative(7f, 7f, 0f, false, false, -0.418f, -0.302f)
                close()
                moveToRelative(1.834f, 1.79f)
                arcToRelative(7f, 7f, 0f, false, false, -0.653f, -0.796f)
                lineToRelative(0.724f, -0.69f)
                quadToRelative(0.406f, 0.429f, 0.747f, 0.91f)
                close()
                moveToRelative(0.744f, 1.352f)
                arcToRelative(7f, 7f, 0f, false, false, -0.214f, -0.468f)
                lineToRelative(0.893f, -0.45f)
                arcToRelative(8f, 8f, 0f, false, true, 0.45f, 1.088f)
                lineToRelative(-0.95f, 0.313f)
                arcToRelative(7f, 7f, 0f, false, false, -0.179f, -0.483f)
                moveToRelative(0.53f, 2.507f)
                arcToRelative(7f, 7f, 0f, false, false, -0.1f, -1.025f)
                lineToRelative(0.985f, -0.17f)
                quadToRelative(0.1f, 0.58f, 0.116f, 1.17f)
                close()
                moveToRelative(-0.131f, 1.538f)
                quadToRelative(0.05f, -0.254f, 0.081f, -0.51f)
                lineToRelative(0.993f, 0.123f)
                arcToRelative(8f, 8f, 0f, false, true, -0.23f, 1.155f)
                lineToRelative(-0.964f, -0.267f)
                quadToRelative(0.069f, -0.247f, 0.12f, -0.501f)
                moveToRelative(-0.952f, 2.379f)
                quadToRelative(0.276f, -0.436f, 0.486f, -0.908f)
                lineToRelative(0.914f, 0.405f)
                quadToRelative(-0.24f, 0.54f, -0.555f, 1.038f)
                close()
                moveToRelative(-0.964f, 1.205f)
                quadToRelative(0.183f, -0.183f, 0.35f, -0.378f)
                lineToRelative(0.758f, 0.653f)
                arcToRelative(8f, 8f, 0f, false, true, -0.401f, 0.432f)
                close()
            }
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(8f, 1f)
                arcToRelative(7f, 7f, 0f, true, false, 4.95f, 11.95f)
                lineToRelative(0.707f, 0.707f)
                arcTo(8.001f, 8.001f, 0f, true, true, 8f, 0f)
                close()
            }
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(7.5f, 3f)
                arcToRelative(0.5f, 0.5f, 0f, false, true, 0.5f, 0.5f)
                verticalLineToRelative(5.21f)
                lineToRelative(3.248f, 1.856f)
                arcToRelative(0.5f, 0.5f, 0f, false, true, -0.496f, 0.868f)
                lineToRelative(-3.5f, -2f)
                arcTo(0.5f, 0.5f, 0f, false, true, 7f, 9f)
                verticalLineTo(3.5f)
                arcToRelative(0.5f, 0.5f, 0f, false, true, 0.5f, -0.5f)
            }
        }.build()

        return _ClockHistory!!
    }

private var _ClockHistory: ImageVector? = null





val PersonHearts: ImageVector
    get() {
        if (_PersonHearts != null) return _PersonHearts!!

        _PersonHearts = ImageVector.Builder(
            name = "PersonHearts",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(11.5f, 1.246f)
                curveToRelative(0.832f, -0.855f, 2.913f, 0.642f, 0f, 2.566f)
                curveToRelative(-2.913f, -1.924f, -0.832f, -3.421f, 0f, -2.566f)
                moveTo(9f, 5f)
                arcToRelative(3f, 3f, 0f, true, true, -6f, 0f)
                arcToRelative(3f, 3f, 0f, false, true, 6f, 0f)
                moveToRelative(-9f, 8f)
                curveToRelative(0f, 1f, 1f, 1f, 1f, 1f)
                horizontalLineToRelative(10f)
                reflectiveCurveToRelative(1f, 0f, 1f, -1f)
                reflectiveCurveToRelative(-1f, -4f, -6f, -4f)
                reflectiveCurveToRelative(-6f, 3f, -6f, 4f)
                moveToRelative(13.5f, -8.09f)
                curveToRelative(1.387f, -1.425f, 4.855f, 1.07f, 0f, 4.277f)
                curveToRelative(-4.854f, -3.207f, -1.387f, -5.702f, 0f, -4.276f)
                close()
                moveTo(15f, 2.165f)
                curveToRelative(0.555f, -0.57f, 1.942f, 0.428f, 0f, 1.711f)
                curveToRelative(-1.942f, -1.283f, -0.555f, -2.281f, 0f, -1.71f)
                close()
            }
        }.build()

        return _PersonHearts!!
    }

private var _PersonHearts: ImageVector? = null






val Fire: ImageVector
    get() {
        if (_Fire != null) return _Fire!!

        _Fire = ImageVector.Builder(
            name = "Fire",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(8f, 16f)
                curveToRelative(3.314f, 0f, 6f, -2f, 6f, -5.5f)
                curveToRelative(0f, -1.5f, -0.5f, -4f, -2.5f, -6f)
                curveToRelative(0.25f, 1.5f, -1.25f, 2f, -1.25f, 2f)
                curveTo(11f, 4f, 9f, 0.5f, 6f, 0f)
                curveToRelative(0.357f, 2f, 0.5f, 4f, -2f, 6f)
                curveToRelative(-1.25f, 1f, -2f, 2.729f, -2f, 4.5f)
                curveTo(2f, 14f, 4.686f, 16f, 8f, 16f)
                moveToRelative(0f, -1f)
                curveToRelative(-1.657f, 0f, -3f, -1f, -3f, -2.75f)
                curveToRelative(0f, -0.75f, 0.25f, -2f, 1.25f, -3f)
                curveTo(6.125f, 10f, 7f, 10.5f, 7f, 10.5f)
                curveToRelative(-0.375f, -1.25f, 0.5f, -3.25f, 2f, -3.5f)
                curveToRelative(-0.179f, 1f, -0.25f, 2f, 1f, 3f)
                curveToRelative(0.625f, 0.5f, 1f, 1.364f, 1f, 2.25f)
                curveTo(11f, 14f, 9.657f, 15f, 8f, 15f)
            }
        }.build()

        return _Fire!!
    }

private var _Fire: ImageVector? = null


