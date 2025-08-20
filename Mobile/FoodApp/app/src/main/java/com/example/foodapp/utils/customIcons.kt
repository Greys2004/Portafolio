package com.example.foodapp.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val Logout: ImageVector
    get() {
        if (_Logout != null) {
            return _Logout!!
        }
        _Logout = ImageVector.Builder(
            name = "Logout",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(200f, 840f)
                quadToRelative(-33f, 0f, -56.5f, -23.5f)
                reflectiveQuadTo(120f, 760f)
                verticalLineToRelative(-560f)
                quadToRelative(0f, -33f, 23.5f, -56.5f)
                reflectiveQuadTo(200f, 120f)
                horizontalLineToRelative(280f)
                verticalLineToRelative(80f)
                horizontalLineTo(200f)
                verticalLineToRelative(560f)
                horizontalLineToRelative(280f)
                verticalLineToRelative(80f)
                close()
                moveToRelative(440f, -160f)
                lineToRelative(-55f, -58f)
                lineToRelative(102f, -102f)
                horizontalLineTo(360f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(327f)
                lineTo(585f, 338f)
                lineToRelative(55f, -58f)
                lineToRelative(200f, 200f)
                close()
            }
        }.build()
        return _Logout!!
    }

private var _Logout: ImageVector? = null

public val Account_circle: ImageVector
    get() {
        if (_Account_circle != null) {
            return _Account_circle!!
        }
        _Account_circle = ImageVector.Builder(
            name = "Account_circle",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(234f, 684f)
                quadToRelative(51f, -39f, 114f, -61.5f)
                reflectiveQuadTo(480f, 600f)
                reflectiveQuadToRelative(132f, 22.5f)
                reflectiveQuadTo(726f, 684f)
                quadToRelative(35f, -41f, 54.5f, -93f)
                reflectiveQuadTo(800f, 480f)
                quadToRelative(0f, -133f, -93.5f, -226.5f)
                reflectiveQuadTo(480f, 160f)
                reflectiveQuadToRelative(-226.5f, 93.5f)
                reflectiveQuadTo(160f, 480f)
                quadToRelative(0f, 59f, 19.5f, 111f)
                reflectiveQuadToRelative(54.5f, 93f)
                moveToRelative(246f, -164f)
                quadToRelative(-59f, 0f, -99.5f, -40.5f)
                reflectiveQuadTo(340f, 380f)
                reflectiveQuadToRelative(40.5f, -99.5f)
                reflectiveQuadTo(480f, 240f)
                reflectiveQuadToRelative(99.5f, 40.5f)
                reflectiveQuadTo(620f, 380f)
                reflectiveQuadToRelative(-40.5f, 99.5f)
                reflectiveQuadTo(480f, 520f)
                moveToRelative(0f, 360f)
                quadToRelative(-83f, 0f, -156f, -31.5f)
                reflectiveQuadTo(197f, 763f)
                reflectiveQuadToRelative(-85.5f, -127f)
                reflectiveQuadTo(80f, 480f)
                reflectiveQuadToRelative(31.5f, -156f)
                reflectiveQuadTo(197f, 197f)
                reflectiveQuadToRelative(127f, -85.5f)
                reflectiveQuadTo(480f, 80f)
                reflectiveQuadToRelative(156f, 31.5f)
                reflectiveQuadTo(763f, 197f)
                reflectiveQuadToRelative(85.5f, 127f)
                reflectiveQuadTo(880f, 480f)
                reflectiveQuadToRelative(-31.5f, 156f)
                reflectiveQuadTo(763f, 763f)
                reflectiveQuadToRelative(-127f, 85.5f)
                reflectiveQuadTo(480f, 880f)
                moveToRelative(0f, -80f)
                quadToRelative(53f, 0f, 100f, -15.5f)
                reflectiveQuadToRelative(86f, -44.5f)
                quadToRelative(-39f, -29f, -86f, -44.5f)
                reflectiveQuadTo(480f, 680f)
                reflectiveQuadToRelative(-100f, 15.5f)
                reflectiveQuadToRelative(-86f, 44.5f)
                quadToRelative(39f, 29f, 86f, 44.5f)
                reflectiveQuadTo(480f, 800f)
                moveToRelative(0f, -360f)
                quadToRelative(26f, 0f, 43f, -17f)
                reflectiveQuadToRelative(17f, -43f)
                reflectiveQuadToRelative(-17f, -43f)
                reflectiveQuadToRelative(-43f, -17f)
                reflectiveQuadToRelative(-43f, 17f)
                reflectiveQuadToRelative(-17f, 43f)
                reflectiveQuadToRelative(17f, 43f)
                reflectiveQuadToRelative(43f, 17f)
                moveToRelative(0f, 300f)
            }
        }.build()
        return _Account_circle!!
    }

private var _Account_circle: ImageVector? = null

public val Star: ImageVector
    get() {
        if (_Star != null) {
            return _Star!!
        }
        _Star = ImageVector.Builder(
            name = "Star",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(354f, 673f)
                lineToRelative(126f, -76f)
                lineToRelative(126f, 77f)
                lineToRelative(-33f, -144f)
                lineToRelative(111f, -96f)
                lineToRelative(-146f, -13f)
                lineToRelative(-58f, -136f)
                lineToRelative(-58f, 135f)
                lineToRelative(-146f, 13f)
                lineToRelative(111f, 97f)
                close()
                moveTo(233f, 840f)
                lineToRelative(65f, -281f)
                lineTo(80f, 370f)
                lineToRelative(288f, -25f)
                lineToRelative(112f, -265f)
                lineToRelative(112f, 265f)
                lineToRelative(288f, 25f)
                lineToRelative(-218f, 189f)
                lineToRelative(65f, 281f)
                lineToRelative(-247f, -149f)
                close()
                moveToRelative(247f, -350f)
            }
        }.build()
        return _Star!!
    }

private var _Star: ImageVector? = null
