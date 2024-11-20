package com.example.hciapp.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hciapp.R


@Composable
fun ButtonTile(
    onClick: () -> Unit,
    @StringRes text: Int,
    @DrawableRes icon : Int,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        IconButton(
            onClick = {  },
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)

        ) {
            Icon(
                modifier = Modifier.size(40.dp),
                painter = painterResource(id = icon),
                contentDescription = "Increase balance",

            )
        }
        Text(text = stringResource(text))
    }
}

@Preview
@Composable
fun ButtonTilePreview() {
    ButtonTile(
        onClick = { },
        text = R.string.increase_balance,
        icon = R.drawable.dinero
    )
}
