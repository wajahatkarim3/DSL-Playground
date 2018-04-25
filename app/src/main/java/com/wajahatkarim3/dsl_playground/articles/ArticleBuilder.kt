package com.wajahatkarim3.dsl_playground.articles

class ArticleBuilder {

    var title: String = ""
    var imageUrl: String? = null
    var paragraphsList = mutableListOf<Paragraph>()

    operator fun invoke(block: ArticleBuilder.() -> Unit)
    {
        block()
    }

    fun addParagraph(block: Paragraph.() -> Unit)
    {
        val paragraph = Paragraph()
        paragraph.block()
        paragraphsList.add(paragraph)
    }

}

class Paragraph {
    lateinit var body: String
    var imageUrl: String? = null
}