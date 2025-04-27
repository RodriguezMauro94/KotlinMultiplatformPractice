package com.maurosergiorodriguez.rickandmortyappmp.ui.core.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.DefaultTextColor

@Composable
fun TextTitle(text: String) {
    Text(text.toUpperCase(Locale.current), color = DefaultTextColor, fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(12.dp))
}