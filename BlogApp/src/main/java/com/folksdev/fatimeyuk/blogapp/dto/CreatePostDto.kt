package com.folksdev.fatimeyuk.blogapp.dto

import com.folksdev.fatimeyuk.blogapp.model.BlogStatus


data class CreatePostDto(
        val title: String,
        val content: String,
        val status: BlogStatus = BlogStatus.DRAFT
)
