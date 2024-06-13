package com.example.genericoutlinebug

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class GenericOutlineShape(private val radius: Dp = 40.dp) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val cornerRadius = with(density) { radius.toPx() }
        val path = Path().apply {
            reset()
            lineTo(x = size.width, y = 0f)
            lineTo(x = size.width, y = size.height)
            bottomCurves(size, cornerRadius)
            lineTo(x = 0f, y = 0f)
            close()
        }
        return Outline.Generic(path)
    }
}

private fun Path.bottomCurves(
    size: Size,
    cornerRadius: Float
) {
    bottomRightArc(size, cornerRadius)
    lineTo(x = cornerRadius, y = size.height - cornerRadius)
    bottomLeftArc(size, cornerRadius)
}

@Suppress("MagicNumber")
private fun Path.bottomLeftArc(
    size: Size,
    cornerRadius: Float
) {
    arcTo(
        rect = Rect(
            left = 0f,
            top = size.height - cornerRadius * 3,
            right = cornerRadius * 2,
            bottom = size.height - cornerRadius
        ),
        startAngleDegrees = 90.0f,
        sweepAngleDegrees = 90.0f,
        forceMoveTo = false
    )
}

@Suppress("MagicNumber")
private fun Path.bottomRightArc(
    size: Size,
    cornerRadius: Float
) {
    arcTo(
        rect = Rect(
            left = size.width - cornerRadius * 2,
            top = size.height - cornerRadius,
            right = size.width,
            bottom = size.height + cornerRadius
        ),
        startAngleDegrees = 0.0f,
        sweepAngleDegrees = -90.0f,
        forceMoveTo = false
    )
}