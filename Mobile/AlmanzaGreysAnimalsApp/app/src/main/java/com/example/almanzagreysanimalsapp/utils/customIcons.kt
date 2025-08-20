package com.example.almanzagreysanimalsapp.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val Cat: ImageVector
    get() {
        if (_Cat != null) {
            return _Cat!!
        }
        _Cat = ImageVector.Builder(
            name = "Cat",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(12f, 5f)
                curveToRelative(0.67f, 0f, 1.35f, 0.09f, 2f, 0.26f)
                curveToRelative(1.78f, -2f, 5.03f, -2.84f, 6.42f, -2.26f)
                curveToRelative(1.4f, 0.58f, -0.42f, 7f, -0.42f, 7f)
                curveToRelative(0.57f, 1.07f, 1f, 2.24f, 1f, 3.44f)
                curveTo(21f, 17.9f, 16.97f, 21f, 12f, 21f)
                reflectiveCurveToRelative(-9f, -3f, -9f, -7.56f)
                curveToRelative(0f, -1.25f, 0.5f, -2.4f, 1f, -3.44f)
                curveToRelative(0f, 0f, -1.89f, -6.42f, -0.5f, -7f)
                curveToRelative(1.39f, -0.58f, 4.72f, 0.23f, 6.5f, 2.23f)
                arcTo(9.04f, 9.04f, 0f, isMoreThanHalf = false, isPositiveArc = true, 12f, 5f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(8f, 14f)
                verticalLineToRelative(0.5f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(16f, 14f)
                verticalLineToRelative(0.5f)
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(11.25f, 16.25f)
                horizontalLineToRelative(1.5f)
                lineTo(12f, 17f)
                lineToRelative(-0.75f, -0.75f)
                close()
            }
        }.build()
        return _Cat!!
    }

private var _Cat: ImageVector? = null

public val Tree: ImageVector
    get() {
        if (_Tree != null) {
            return _Tree!!
        }
        _Tree = ImageVector.Builder(
            name = "TreePine",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(17f, 14f)
                lineToRelative(3f, 3.3f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.7f, 1.7f)
                horizontalLineTo(4.7f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.7f, -1.7f)
                lineTo(7f, 14f)
                horizontalLineToRelative(-0.3f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.7f, -1.7f)
                lineTo(9f, 9f)
                horizontalLineToRelative(-0.2f)
                arcTo(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8f, 7.3f)
                lineTo(12f, 3f)
                lineToRelative(4f, 4.3f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.8f, 1.7f)
                horizontalLineTo(15f)
                lineToRelative(3f, 3.3f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.7f, 1.7f)
                horizontalLineTo(17f)
                close()
            }
            path(
                fill = null,
                fillAlpha = 1.0f,
                stroke = SolidColor(Color(0xFF000000)),
                strokeAlpha = 1.0f,
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(12f, 22f)
                verticalLineToRelative(-3f)
            }
        }.build()
        return _Tree!!
    }

private var _Tree: ImageVector? = null
