package com.developeralamin.softlearning.model.post

data class Links(
    val about: List<About>,
    val author: List<Author>,
    val collection: List<Collection>,
    val curies: List<Cury>,
    val predecessor_version: List<PredecessorVersion>,
   // val predecessor-version: List<PredecessorVersion>,
    val replies: List<Reply>,
    val self: List<Self>,
    val version_history: List<VersionHistory>,
    val attachment: List<WpAttachment>,
    val featuredmedia: List<WpFeaturedmedia>,
    val term: List<WpTerm>
)