package com.folksdev.fatimeyuk.blogapp.dto

import com.folksdev.fatimeyuk.blogapp.model.BlogStatus
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreatePostRequest(

        val id: Int,

        @field:NotBlank(message = "Title is mandatory")
        val title: String,

        @field:NotBlank(message = "Content is mandatory")
        @field:Size(min=50)
        val content: String,

        val status: BlogStatus = BlogStatus.DRAFT
)
